package com.aiolia.service.impl;

import com.aiolia.entity.User;
import com.aiolia.mapper.UserMapper;
import com.aiolia.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{
}
