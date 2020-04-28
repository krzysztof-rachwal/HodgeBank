CREATE TABLE Status (
StatusId int PRIMARY KEY AUTO_INCREMENT,
Stat VARCHAR(10) NOT NULL
);

CREATE TABLE BookingStatus(
BookingStatusId int PRIMARY KEY AUTO_INCREMENT,
PersonId int,
EventId int,
StatusId int,
FOREIGN KEY (PeopleId) REFERENCES People(PeopleId),
FOREIGN KEY (EventId) REFERENCES Events(EventsId),
FOREIGN KEY (StatusId) REFERENCES Status(StatusId)
);
