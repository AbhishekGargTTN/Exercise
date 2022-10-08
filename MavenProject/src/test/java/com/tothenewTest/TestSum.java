package com.tothenewTest;

import com.tothenew.SumClass;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class TestSum {
    SumClass sumClass=new SumClass();
    private long input1;
    private long input2;
    private long expectedOutput;

    public TestSum(long input1, long input2, long expectedOutput) {
        this.input1 = input1;
        this.input2 = input2;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Long[]> testConditions(){
        Long expectedOutputs[][]= {{1L,2l,3l}, {5l,6l,11l}};
        return Arrays.asList(expectedOutputs);
    }
    @Test
   public void testSum(){
        assertEquals(expectedOutput, sumClass.sum(input1,input2));
    }
}
