use coffeehouse;

#drop table User_Roles;
#drop table Users;

#--Create User
create table Users(
	user_id int(11) primary key auto_increment,
	username varchar(36) unique not null,
	password varchar(20) not null,
	enabled tinyint(1) not null default 1
);
	
#--User Roles
create table User_Roles (
	user_role_id int(11) primary key auto_increment,
	username varchar(36) not null,
	user_role varchar(30) not null,
	constraint UK_USERNAME_ROLE unique (user_role, username),
	constraint FK_USER_ROLES_USERNAME foreign key (username) references Users(username)
);
alter table User_Roles auto_increment = 1001;

#--insert Users
insert into Users(username, password, enabled) values('coffeeadmin', 'coffeehouse', true);
insert into Users(username, password, enabled) values('coffeeuser1','12345', true);
 
#--insert User Roles
insert into User_Roles(username, user_role) values('coffeeadmin', 'ROLE_USER');
insert into User_Roles(username, user_role) values('coffeeadmin', 'ROLE_ADMIN');
insert into User_Roles(username, user_role) values('coffeeuser1', 'ROLE_USER');

#--Save and Commit Changes
commit;

