package com.aiolia.mapper;

import com.aiolia.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/21
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders>
{
}
