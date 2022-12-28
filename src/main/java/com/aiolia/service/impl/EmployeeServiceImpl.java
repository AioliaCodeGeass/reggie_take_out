package com.aiolia.service.impl;

import com.aiolia.entity.Employee;
import com.aiolia.mapper.EmployeeMapper;
import com.aiolia.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/11
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService
{
}
