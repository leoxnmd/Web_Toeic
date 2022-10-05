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

