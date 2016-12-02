#create database if not exists 'coffeehouse';
use coffeehouse;

#drop table if exists User_Roles;
#drop table if exists Users;
#drop table if exists Roles;

#--Create User
create table Users(
	user_id int(11) primary key auto_increment,
	username varchar(36) unique not null,
	user_email varchar(40) unique not null,
	password varchar(20) not null,
	enabled tinyint(1) not null default 1
);


#--Create Role
create table Roles (
	role_id int(11) primary key auto_increment,
	role_name varchar(45) null
);
alter table Roles auto_increment = 1001;


#--User Roles
create table User_Roles (
	user_id int(11) not null,
	role_id int(11) not null,
	constraint PK_USER_ROLE primary key (user_id, role_id),
	constraint FK_USER_ID foreign key (user_id) references Users(user_id),
	constraint FK_ROLE_ID foreign key (role_id) references Roles(role_id)
);
*/
#--Insert Users

#--Insert Roles
insert into Roles(role_name) values('ROLE_USER');
insert into Roles(role_name) values('ROLE_ADMIN');

#--insert User Roles

#--Save and Commit Changes
commit;

