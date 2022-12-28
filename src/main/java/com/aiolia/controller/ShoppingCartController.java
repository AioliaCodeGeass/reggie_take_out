package com.aiolia.controller;

import com.aiolia.common.BaseContext;
import com.aiolia.common.R;
import com.aiolia.entity.ShoppingCart;
import com.aiolia.service.ShoppingCartService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/21
 */
@Slf4j
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController
{
    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加购物车
     * @param shoppingCart
     * @return
     */
    @PostMapping("/add")
    public R<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart)
    {
        Long currentId=BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);

        Long dishId=shoppingCart.getDishId();
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,currentId);
        if(dishId!=null)
        {
            queryWrapper.eq(ShoppingCart::getDishId,dishId);
        }
        else
        {
            queryWrapper.eq(ShoppingCart::getSetmealId,shoppingCart.getSetmealId());

        }

        ShoppingCart cartServiceOne= shoppingCartService.getOne(queryWrapper);
        if(cartServiceOne!=null)
        {
            int number =cartServiceOne.getNumber();
            cartServiceOne.setNumber(number+1);
            shoppingCartService.updateById(cartServiceOne);
        }
        else
        {
            shoppingCart.setNumber(1);
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartService.save(shoppingCart);
            cartServiceOne=shoppingCart;
        }

        return R.success(cartServiceOne);
    }

    /**
     * 减少购物车
     * @param shoppingCart
     * @return
     */
    @PostMapping("/sub")
    public R<ShoppingCart> sub(@RequestBody ShoppingCart shoppingCart)
    {
        Long currentId=BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);

        Long dishId=shoppingCart.getDishId();
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,currentId);
        if(dishId!=null)
        {
            queryWrapper.eq(ShoppingCart::getDishId,dishId);
        }
        else
        {
            queryWrapper.eq(ShoppingCart::getSetmealId,shoppingCart.getSetmealId());

        }

        ShoppingCart cartServiceOne= shoppingCartService.getOne(queryWrapper);
        if(cartServiceOne!=null)
        {
            int number =cartServiceOne.getNumber();
            cartServiceOne.setNumber(number-1);
            if(cartServiceOne.getNumber()<=0)
               shoppingCartService.removeById(cartServiceOne.getId());
            else
                shoppingCartService.updateById(cartServiceOne);

        }
        else
        {
            shoppingCart.setNumber(1);
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartService.save(shoppingCart);
            cartServiceOne=shoppingCart;
        }

        return R.success(cartServiceOne);
    }

    /**
     * 查看购物车
     * @return
     */
    @GetMapping("/list")
    public R<List<ShoppingCart>> list()
    {
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
        queryWrapper.orderByAsc(ShoppingCart::getCreateTime);
        List<ShoppingCart> list=shoppingCartService.list(queryWrapper);
        return R.success(list);
    }

    /**
     * 清空购物车
     * @return
     */
    @DeleteMapping("/clean")
    public R<String> clean()
    {
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
        shoppingCartService.remove(queryWrapper);

        return R.success("清空购物车成功");
    }
}
