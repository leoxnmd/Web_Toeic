ALTER TABLE `userEntity`
ADD COLUMN `roleid` VARCHAR(45) NULL AFTER `createddate`;

ALTER TABLE `userEntity`
ADD CONSTRAINT `fk_user_role` FOREIGN KEY (`roleid`) REFERENCES `roleEntity` (`roleid`)


ALTER TABLE `comment`
ADD CONSTRAINT `fk_comment_user` FOREIGN KEY (`userid`) REFERENCES `userEntity` (`userid`)

ALTER TABLE `comment`
ADD CONSTRAINT `fk_comment_listenguideline` FOREIGN KEY (`listenguidelineid`) REFERENCES `listenguideline` (`listenguidelineid`)
