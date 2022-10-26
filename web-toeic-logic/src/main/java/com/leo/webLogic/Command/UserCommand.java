package com.leo.webLogic.Command;

import com.leo.webCore.dto.UserDTO;
import com.leo.webCore.web.command.AbstractCommand;

public class UserCommand extends AbstractCommand<UserDTO> {
    public UserCommand() {
        this.pojo = new UserDTO();
    }
}
