package com.leo.webCore.utils;

import com.leo.webCore.dto.UserDTO;
import com.leo.webCore.peristence.entity.UserEntity;

public class UserBeanUtil {
    public static UserEntity DtoToEntity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setUserId(dto.getUserId());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setFullName(dto.getFullName());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setRole(RoleBeanUtil.dtoToEntity(dto.getRoleDTO()));
        return entity;

    }

    public static UserDTO EntityToDto(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setUserId(entity.getUserId());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setFullName(entity.getFullName());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setRoleDTO(RoleBeanUtil.entityToDto(entity.getRole()));
        return dto;
    }
}
