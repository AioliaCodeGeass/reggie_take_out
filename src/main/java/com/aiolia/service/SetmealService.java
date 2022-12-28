package com.aiolia.service;

import com.aiolia.dto.SetmealDto;
import com.aiolia.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/12
 */
public interface SetmealService extends IService<Setmeal>
{
    public void saveWithDish(SetmealDto setmealDto);

    public void updateWithDish(SetmealDto setmealDto);

    public SetmealDto getByIdWithDish(Long id);

    public void deleteWithDish(String ids);
}
