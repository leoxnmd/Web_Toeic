create TABLE `user` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `fullname` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `createddate` TIMESTAMP(6)  NULL,
  PRIMARY KEY (`userid`)
  );

create TABLE `role` (
  `roleid` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`roleid`)
  );

create TABLE `listenguideline` (
  `listenguidelineid` INT NOT NULL AUTO_INCREMENT,
  `image` VARCHAR(50) NULL,
  `title` VARCHAR(150) NULL,
  `content` TEXT NULL,
  `createddate` TIMESTAMP NULL,
  `modifiedate` TIMESTAMP NULL,
  PRIMARY KEY (`listenguidelineid`)
  );

  create TABLE `comment` (
  `commentid` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NULL,
  `userid` INT NULL,
  `listenguidelineid` INT NULL,
  `createddate` TIMESTAMP NULL,
  PRIMARY KEY (`commentid`)
  );

