package com.aiolia.service;

import com.aiolia.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/12
 */
public interface CategoryService extends IService<Category>
{
    public void remove(Long id);
}
