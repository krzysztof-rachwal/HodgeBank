package com.example.demo.auth.reg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserRepository implements UserInterface {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    @Bean //https://www.baeldung.com/spring-bean
    public BCryptPasswordEncoder passwordEncoder2() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    /*
    Method to return whether a username already exists. Used as part of the registration process
    */
    public boolean doesUserNameExist(String u) {
        return (jdbcTemplate.queryForList("select email from People where email = ?", new Object[]{u})).size() > 0;
    }

    /*
    Add a new user to the users table in the database using a User object passed
    from RegController which is built from what the user submits as part of the
    registration form.
    */
    private int _addToUserTable(User u){
        String sql = "insert into People(Email, password, enabled,FirstName,Surname) values(?,?,?,?,?)";
        return jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                //unlike the databases learning resources surrounding tv shows, the user table here does not contain
                // an auto-incrementing field named id, otherwise a second attribute would be added to the line
                // above --> new String[]{"id"}
                ps.setString(1, u.getUsername());
                ps.setString(2, passwordEncoder2().encode(u.getPassword()));
                ps.setInt(3, 1);
                ps.setString(4,u.getFName());
                ps.setString(5,u.getSName());
                return ps;
            }
        });
    }
    /*
    Add authority information for a user. Authorities refer to user groups which
    can have different levels of security access. Here all users are part of a
    single group, but this could be extended to allow some users to also be
    administrators, or other types of additional privilege.
    */

    private int _addToAuthoritiesTable(User u){
        String sql2 = "insert into authorities(PeopleId, authority) values(?,?)";

        u.setId(jdbcTemplate.queryForObject("SELECT PeopleID from People where Email = ?",
                new Object[]{u.getUsername()},
                (rs,i) -> new Integer(
                        rs.getInt("PeopleId")
                )
        ));

        return jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql2);
                ps.setInt(1, u.getId());
                ps.setString(2, "ROLE_USER");
                return ps;
            }
        });
    }

    /*
        Add a new user to the database.
        User data is added across two tables, which have been split into separate methods here.
    */
    public boolean addUser(User u) {
        return _addToUserTable(u) > 0 && _addToAuthoritiesTable(u) > 0;
    }
}
