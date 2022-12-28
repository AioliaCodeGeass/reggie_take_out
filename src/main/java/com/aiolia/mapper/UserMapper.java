package com.aiolia.mapper;

import com.aiolia.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/19
 */
@Mapper
public interface UserMapper extends BaseMapper<User>
{
}
