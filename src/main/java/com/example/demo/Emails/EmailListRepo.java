package com.example.demo.Emails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmailListRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmailListRepo(JdbcTemplate aTemplate)
    {
        jdbcTemplate = aTemplate;
    }

    public List<EmailList> findAll() {


        return jdbcTemplate.query("SELECT Email " +
                        "from People p " +
                        "inner join PTeams PT " +
                        "on PT.PeopleID = p.PeopleID " +
                        "inner join Teams t " +
                        "on t.TeamID = PT.TeamID " +
                        "where TeamName like \"Developers\";",
                new Object[]{},
                (rs,i) -> new EmailList(
                        rs.getString("Email")
                )
        );
    }
}
