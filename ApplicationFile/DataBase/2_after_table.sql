ALTER TABLE `user`
ADD COLUMN `roleid` VARCHAR(45) NULL AFTER `createddate`;

ALTER TABLE `user`
ADD CONSTRAINT `fk_user_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)


ALTER TABLE `comment`
ADD CONSTRAINT `fk_comment_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)

ALTER TABLE `comment`
ADD CONSTRAINT `fk_comment_listenguideline` FOREIGN KEY (`listenguidelineid`) REFERENCES `listenguideline` (`listenguidelineid`)
