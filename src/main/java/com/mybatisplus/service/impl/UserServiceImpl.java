package com.mybatisplus.service.impl;

import com.mybatisplus.entity.User;
import com.mybatisplus.mapper.UserMapper;
import com.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jj
 * @since 2019-05-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
