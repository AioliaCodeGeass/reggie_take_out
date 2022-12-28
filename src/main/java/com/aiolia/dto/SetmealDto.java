package com.aiolia.dto;

import com.aiolia.entity.Setmeal;
import com.aiolia.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal
{

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
