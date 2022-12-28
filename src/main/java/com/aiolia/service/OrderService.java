package com.aiolia.service;

import com.aiolia.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/21
 */
public interface OrderService extends IService<Orders>
{
    public void submit(Orders orders);
}
