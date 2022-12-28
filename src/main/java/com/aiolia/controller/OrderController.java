package com.aiolia.controller;

import com.aiolia.common.R;
import com.aiolia.dto.DishDto;
import com.aiolia.entity.Category;
import com.aiolia.entity.Dish;
import com.aiolia.entity.Employee;
import com.aiolia.entity.Orders;
import com.aiolia.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/21
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    /**
     * 用户下单
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders)
    {
        orderService.submit(orders);
        return R.success("下单成功");
    }

    /**
     * 订单信息分页查询
     * @param page
     * @param pageSize
     * @param number
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String number, Date beginTime,Date endTime)
    {
        //构造分页构造器
        Page pageInfo=new Page(page,pageSize);
        LambdaQueryWrapper<Orders> wrapper=new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotEmpty(number),Orders::getNumber,number);
        wrapper.orderByDesc(Orders::getOrderTime);

        orderService.page(pageInfo,wrapper);
        return R.success(pageInfo);
    }

    /**
     * 改变订单状态
     */
    @PutMapping
    public R<String> updateStatus(@RequestBody Orders orders)
    {
        orderService.updateById(orders);
        return R.success("订单状态修改成功");
    }
}
