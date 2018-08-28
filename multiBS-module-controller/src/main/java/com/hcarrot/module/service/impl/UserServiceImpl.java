package com.hcarrot.module.service.impl;

import com.hcarrot.dao.core.AbstractService;
import com.hcarrot.dao.mapper.UserMapper;
import com.hcarrot.dao.model.User;
import com.hcarrot.module.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/27.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
