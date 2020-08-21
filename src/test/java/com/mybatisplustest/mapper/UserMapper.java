package com.mybatisplustest.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplustest.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jj
 * @since 2019-05-04
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
