package com.aiolia.service;

import com.aiolia.dto.DishDto;
import com.aiolia.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/12
 */
public interface DishService extends IService<Dish>
{
    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);

    public void deleteWithFlavor(String ids);
}
