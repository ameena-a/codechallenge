package com.mebank.codechallenge;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@DisplayName("Test the Code Challenge")
public class MainProgrammeTest {

   
    @Test
    void testTransformation(){
        Stream<String> stringStream = Mockito.mock(Stream.class);
        Assertions.assertSame(ArrayList.class, MainProgramme.transformStreamToTransactions(stringStream).getClass());
    }

    
    @Test
    void testCreateTransaction(){
        String input = "TX10001,ACC998877,ACC778899,20/10/2018 18:00:00,8.50,PAYMENT";
        Assertions.assertEquals(850l, MainProgramme.createTransactionFromInput(input).getAmountInCents());
    }

   
}


