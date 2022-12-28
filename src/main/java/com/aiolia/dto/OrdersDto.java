package com.aiolia.dto;

import com.aiolia.entity.OrderDetail;
import com.aiolia.entity.Orders;
import com.aiolia.entity.Orders;
import lombok.Data;
import java.util.List;

@Data
public class OrdersDto extends Orders
{

    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;
	
}
