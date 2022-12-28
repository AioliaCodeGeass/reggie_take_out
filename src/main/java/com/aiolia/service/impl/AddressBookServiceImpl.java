package com.aiolia.service.impl;

import com.aiolia.entity.AddressBook;
import com.aiolia.mapper.AddressBookMapper;
import com.aiolia.service.AddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/19
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService
{
}
