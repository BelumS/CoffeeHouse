use coffeehouse;

#drop table if exists User_Roles;
#drop table if exists Users;
#drop table if exists Roles;

#--Create User
create table Users(
	user_id int(11) unsigned not null auto_increment,
	username varchar(36) unique not null,
	user_email varchar(50) unique not null,
	password varchar(20) not null,
	enabled tinyint(1) not null default 1,
	primary key(user_id)
)Engine=InnoDB default charset=utf8;


#--Create Role
create table Roles (
	role_id int(11) unsigned not null auto_increment,
	role_name varchar(45),
	primary key(role_id)
)Engine=InnoDB auto_increment=1001 default charset=utf8;

#--User Roles
create table User_Roles (
	user_id int(11) unsigned not null,
	role_id int(11) unsigned not null,
	created_date date not null,
	created_by varchar(20) not null,
	constraint PK_USER_ROLES primary key (user_id, role_id),
	constraint FK_USER_ROLE_USER_ID foreign key (user_id) references Users(user_id),
	constraint FK_USER_ROLE_ROLE_ID foreign key (role_id) references Roles(role_id)
)Engine=InnoDB default charset=utf8;

#--Insert Users

#--Insert Roles
#insert into Roles(role_name) values('USER');
#insert into Roles(role_name) values('ADMIN');
#insert into Roles(role_name) values('DBA');

#--insert User Roles

#--Save and Commit Changes
commit;


