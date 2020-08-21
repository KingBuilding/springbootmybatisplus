package com.mybatisplustest.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplustest.entity.User;
import com.mybatisplustest.mapper.UserMapper;
import com.mybatisplustest.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jj
 * @since 2019-05-04
 */
@Service("UserServiceImpl2")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
