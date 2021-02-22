package com.mebank.codechallenge;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommonFormatterTest {

   
    @Test
    void testGetLocalDateTimeFromString(){
        Assertions.assertSame(LocalDateTime.class, CommonFormatter.getLocalDateTimeFromString("20/10/2018 19:45:00").getClass());
    }

    
    @Test
    void testStringToLongCurrencyConversion(){
        ;
        Assertions.assertEquals(2523l, CommonFormatter.convertCurrencyToCents("25.23"));
    }

    
    @Test
    void testLongToDollarDisplayConversion(){
        Assertions.assertEquals("$25.23", CommonFormatter.convertCentToDollarDisplay(2523));
    }

}
