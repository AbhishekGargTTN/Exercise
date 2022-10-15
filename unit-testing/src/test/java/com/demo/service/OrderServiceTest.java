package com.demo.service;

import com.demo.domain.Order;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
    OrderService orderService= mock(OrderService.class);
    @Test
    public void testPlaceOrder_SingleArgument(){
        Order order=mock(Order.class);
        orderService.placeOrder(order);
        verify(orderService).placeOrder(order);
    }
    @Test
    public void testPlaceOrder_MultiArgument(){
        when(orderService.placeOrder(any(Order.class), anyString())).thenReturn(true);
        assertTrue(orderService.placeOrder(new Order(), "Order Placed"));
    }
}