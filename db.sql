drop database if exists final;
create database if not exists final;
use final;

drop table if exists `users`;
drop table if exists `posts`;
drop table if exists `photos`;
drop table if exists `friends`;
drop table if exists `friendrequests`;

    
create table `users` (
	`userId` int not null auto_increment,
	`name` varchar(50) not null,
	`username` varchar(100) not null, 
	`password` varchar(20) not null,
    `state` varchar(30) not null,
	Primary Key (`userId`),
    Unique (`username`)
    );
    
/* USER_PROFILE table contains all possible roles */
create table USER_PROFILE(
   id int NOT NULL AUTO_INCREMENT,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (type)
);
  
/* JOIN TABLE for MANY-TO-MANY relationship*/ 
CREATE TABLE APP_USER_USER_PROFILE (
    user_id int NOT NULL,
    user_profile_id int NOT NULL,
    PRIMARY KEY (user_id, user_profile_id),
    CONSTRAINT FK_APP_USER FOREIGN KEY (user_id) REFERENCES users (userId),
    CONSTRAINT FK_USER_PROFILE FOREIGN KEY (user_profile_id) REFERENCES USER_PROFILE (id)
);

create table if not exists `photos` (
	`photo_id` 	int not null auto_increment,
    `user_id`	int not null,
    `photo_title`	VARCHAR(50) not null,
    `photo_filename` VARCHAR(50) not null,
    Primary Key (`photo_id`),
	Foreign Key (`user_id`) REFERENCES `users` (`userId`)
    );
   
create table if not exists `posts` (
	`post_id`	int not null auto_increment,
    `user_id`   int not null,
	`post_name` varchar(50) not null,
	`post_content` varchar (140) not null,
    Primary Key (`post_id`),
    Foreign Key (`user_id`) REFERENCES `users`(`userId`)
    );

	
create table `friends` (
	`friend_id` int not null auto_increment,
	`user_id` int not null,
	Primary Key (`friend_id`,`user_id`),
    Foreign Key (`user_id`) REFERENCES `users`(`userId`)
	);		

create table `friendrequests` (
	`request_id` int not null auto_increment,
	`user_id` int not null,
    `friends_id` int not null,
    `status` int,
	Primary Key (`request_id`),
    Foreign Key (`user_id`) REFERENCES `users`(`userId`)
	);
insert into users values(1,'Daniel', 'danscmr' ,'1234', 'Active');
INSERT INTO USER_PROFILE(type) VALUES ('USER');
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.userId, profile.id FROM users user, USER_PROFILE profile
  where user.username='danscmr' and profile.type='USER';


select * from users;
select * from USER_PROFILE;
select * from APP_USER_USER_PROFILE;