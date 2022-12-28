package com.aiolia.mapper;

import com.aiolia.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/11
 */

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee>
{

}
