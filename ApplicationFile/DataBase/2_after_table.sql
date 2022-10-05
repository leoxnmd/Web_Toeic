ALTER TABLE `user`
ADD COLUMN `roleid` VARCHAR(45) NULL AFTER `createddate`;

ALTER TABLE `user`
ADD CONSTRAINT `fk_user_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
