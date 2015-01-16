package com.my.messages.service.impl;


import com.my.messages.dao.RoleDao;
import com.my.messages.model.Role;
import com.my.messages.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role getRole(int id) {

        return roleDao.getRole(id);
    }
}