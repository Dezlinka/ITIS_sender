


CREATE DATABASE IF NOT EXISTS `userdb` ;
USE `userdb`;

CREATE TABLE IF NOT EXISTS `students` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `height` int(3) DEFAULT NULL,
  `weight` int(3) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;


INSERT INTO `recruits` (`userid`, `firstname`, `lastname`, `dob`, `email`, `height`, `weight`, `category`, `language`) VALUES
	
	(22, 'Test', 'test', '2016-11-24', 'test', 165, 60, '', ''),
	(23, 'Updated user', 'Updated last name', '2016-11-05', 'fwe', 170, 75, '', ''),
	(32, 'Naumov', 'Danil', '1998-4-24', 'dezl9873@gmail.com', 183, 70, 'B1', NULL);



CREATE TABLE IF NOT EXISTS `users` (
  `user_name` varchar(15) NOT NULL,
  `user_pass` varchar(15) NOT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `users` (`user_name`, `user_pass`) VALUES
	('admin', 'admin');

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_name` varchar(15) NOT NULL,
  `role_name` varchar(15) NOT NULL,
  PRIMARY KEY (`user_name`,`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `user_roles` (`user_name`, `role_name`) VALUES
	('admin', 'Polkovnik');
