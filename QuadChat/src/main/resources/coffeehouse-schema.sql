use coffeehouse;

drop table if exists User_Roles;
drop table if exists Users;

#--Create User
create table Users (
	user_id int(10) unsigned not null auto_increment,
	username varchar(45) not null,
	user_email varchar(50) not null,
	user_password varchar(60) not null,
	user_enabled tinyint not null default 1,
	user_created_date date not null,
    primary key(user_id),
    unique key UK_USERNAME (username),
 	unique key UK_USER_EMAIL (user_email)
)Engine=InnoDB default charset=utf8;

#--User Roles
create table User_Roles (
	user_role_id int(10) unsigned not null auto_increment,
	user_id int(10) unsigned not null,
	user_role_name varchar(45) not null,
	primary key (user_role_id),
	constraint FK_USER_ID foreign key (user_id) references Users(user_id)
)Engine=InnoDB default charset=utf8 auto_increment=1001;

#insert into User_Roles(user_id, user_role_name) values(1, "USER");
#insert into User_Roles(user_id, user_role_name) values(1, "ADMIN");
#--Save and Commit Changes
commit;


