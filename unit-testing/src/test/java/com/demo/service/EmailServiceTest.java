package com.demo.service;

import com.demo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {
     EmailService emailService= mock(EmailService.class);
    @Test(expected = RuntimeException.class)
    public void testSendEmail_SingleArgument(){
        doThrow(new RuntimeException("A Runtime Exception Occurred"))
                .when(emailService)
                .sendEmail(any(Order.class));
        emailService.sendEmail(new Order());
    }

    @Test
    public void testSendEmail_MultiArgument(){
        when(emailService.sendEmail(any(Order.class), anyString()))
                .thenReturn(true);
        assertTrue(emailService.sendEmail(new Order(),"Order Placed"));
    }


}