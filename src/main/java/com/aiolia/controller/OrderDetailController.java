package com.aiolia.controller;

import com.aiolia.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/21
 */
@Slf4j
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController
{
    @Autowired
    private OrderDetailService orderDetailService;
}
