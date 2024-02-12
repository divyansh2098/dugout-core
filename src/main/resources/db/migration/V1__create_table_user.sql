create table `user` (
    id int(11) not null auto_increment,
    firstname varchar(255) default null,
    lastname varchar(255) default null,
    email varchar(255) default null,
    phone varchar(255) default null,
    gender varchar(16) default null,
    date_of_birth varchar(255) default null,
    country varchar(255) default null,
    city varchar(255) default null,
    specialisation varchar(255) deafult null,
    batting_style varchar(255) deafult null,
    bowling_style varchar(255) deafult null,
    created_on datetime default current_timestamp,
    updated_on datetime default current_timestamp on update current_timestamp,
    primary key (id),
    unique key (email),
    unique key (phone)
);