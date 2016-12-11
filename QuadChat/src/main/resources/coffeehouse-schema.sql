drop database if exists coffeehouse;
use coffeehouse;

drop table if exists Users;
#--Create User
create table Users (
	user_id int(11) unsigned not null auto_increment,
	username varchar(45) not null,
	password varchar(60) not null,
	user_email varchar(60) not null,
    primary key(user_id),
    unique key UK_USERNAME (username),
 	unique key UK_USER_EMAIL (user_email)
)Engine=InnoDB default charset=utf8;

drop table if exists Roles;
create table Roles (
	role_id int(11) unsigned not null auto_increment,
	role_name varchar(45) not null,
	primary key(role_id)
)Engine=InnoDB auto_increment=1001 default charset-utf8;

drop table if exists User_Roles;
#--User Roles
create table User_Roles (
	user_id int(11) unsigned not null,
	role_id int(11) unsigned not null,
	created_date date not null,
	activated tinyint(1) not null,
	primary key (user_id, role_id),
	constraint FK_USER_ID foreign key (user_id) references Users(user_id),
	constraint FK_ROLE_ID foreign key (role_id) references Roles(role_id)
);

#--Save and Commit Changes
commit;


