package com.aiolia.service.impl;

import com.aiolia.entity.OrderDetail;
import com.aiolia.mapper.OrderDetailMapper;
import com.aiolia.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/21
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService
{
}
