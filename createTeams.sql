create table Teams(
TeamId int primary key auto_increment,
TeamName nvarchar(15));

create table PTeams(
TeamID int not null,
PersonID int not null,
foreign key (TeamID) references Teams(TeamID),
foreign key (PersonID) references People(PeopleId),
constraint PTID primary key (TeamID, PersonID));