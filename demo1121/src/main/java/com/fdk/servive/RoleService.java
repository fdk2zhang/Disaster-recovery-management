package com.fdk.servive;

import java.util.List;

public interface RoleService {
    public List<String> findRoleByUserId(long userId);
}
