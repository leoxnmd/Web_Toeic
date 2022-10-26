package com.leo.webCore.utils;

import com.leo.webCore.dto.RoleDTO;
import com.leo.webCore.peristence.entity.RoleEntity;

public class RoleBeanUtil {
    public static RoleEntity dtoToEntity(RoleDTO dto) {
        RoleEntity entity = new RoleEntity();
        dto.setRoleId(dto.getRoleId());
        dto.setName(dto.getName());
        return entity;
    }

    public static RoleDTO entityToDto(RoleEntity entity) {
        RoleDTO dto = new RoleDTO();
        dto.setRoleId(entity.getRoleId());
        dto.setName(entity.getName());
        return dto;
    }
}
