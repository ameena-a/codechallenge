package com.mebank.codechallenge;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests that verify the calculator logic")
public class RelativeBalanceCalculatorTest {
   
    private static List<Transaction> transactionListWithReturns = new ArrayList<>();

    @BeforeAll
    static void setupTransactionList(){
        transactionListWithReturns.add(new Transaction("TX10001", "ACC998877", "ACC778899", "20/10/2018 18:00:00", "8.50", "PAYMENT"));
        transactionListWithReturns.add(new Transaction("TX10002", "ACC998877", "ACC778899", "20/10/2018 18:30:00", "12.75", "PAYMENT"));
        transactionListWithReturns.add(new Transaction("TX10003", "ACC778899", "ACC998877", "20/10/2018 19:30:00", "6.35", "PAYMENT"));
        transactionListWithReturns.add(new Transaction("TX10004", "ACC998877", "ACC778899", "20/10/2018 19:30:00", "12.75", "REVERSAL", "TX10002"));
    }

      
    @Test
    void testCalculatorForDebitsWithReversals(){
        RelBalAndTransCalc rbc = new RelBalAndTransCalc(transactionListWithReturns);
        String value = rbc.calculateRelativeBalanceAndTransactions("ACC998877", CommonFormatter.getLocalDateTimeFromString("20/10/2018 17:50:00"), CommonFormatter.getLocalDateTimeFromString("20/10/2018 18:35:00"));
        Assertions.assertEquals("The Relative Balance for this period is -$8.50 and the Number of Transactions included is: 1", value);
    }

   
    @Test
    void testCalculatorForCreditsWithReversals(){
        RelBalAndTransCalc rbc = new RelBalAndTransCalc(transactionListWithReturns);
        String value = rbc.calculateRelativeBalanceAndTransactions("ACC778899", CommonFormatter.getLocalDateTimeFromString("20/10/2018 17:50:00"), CommonFormatter.getLocalDateTimeFromString("20/10/2018 18:35:00"));
        Assertions.assertEquals("The Relative Balance for this period is $8.50 and the Number of Transactions included is: 1", value);
    }

    
    @Test
    void testCalculatorForDebitsAndCreditsWithReverSals(){
        RelBalAndTransCalc rbc = new RelBalAndTransCalc(transactionListWithReturns);
        String value = rbc.calculateRelativeBalanceAndTransactions("ACC998877", CommonFormatter.getLocalDateTimeFromString("20/10/2018 18:25:00"), CommonFormatter.getLocalDateTimeFromString("20/10/2018 19:35:00"));
        Assertions.assertEquals("The Relative Balance for this period is $6.35 and the Number of Transactions included is: 1", value);
    }

   
    @Test
    void testCalculatorForCreditAndDebitsWithReversals(){
        RelBalAndTransCalc rbc = new RelBalAndTransCalc(transactionListWithReturns);
        String value = rbc.calculateRelativeBalanceAndTransactions("ACC778899", CommonFormatter.getLocalDateTimeFromString("20/10/2018 18:25:00"), CommonFormatter.getLocalDateTimeFromString("20/10/2018 19:35:00"));
        Assertions.assertEquals("The Relative Balance for this period is -$6.35 and the Number of Transactions included is: 1", value);
    }

   
    @Test
    void testCalculatorForAllWithReversalsDebit(){
        RelBalAndTransCalc rbc = new RelBalAndTransCalc(transactionListWithReturns);
        String value = rbc.calculateRelativeBalanceAndTransactions("ACC998877", CommonFormatter.getLocalDateTimeFromString("20/10/2018 17:55:00"), CommonFormatter.getLocalDateTimeFromString("20/10/2018 19:35:00"));
        Assertions.assertEquals("The Relative Balance for this period is -$2.15 and the Number of Transactions included is: 2", value);
    }

   
    @Test
    void testCalculatorForAllWithReversalsCredit(){
        RelBalAndTransCalc rbc = new RelBalAndTransCalc(transactionListWithReturns);
        String value = rbc.calculateRelativeBalanceAndTransactions("ACC778899", CommonFormatter.getLocalDateTimeFromString("20/10/2018 17:55:00"), CommonFormatter.getLocalDateTimeFromString("20/10/2018 19:35:00"));
        Assertions.assertEquals("The Relative Balance for this period is $2.15 and the Number of Transactions included is: 2", value);
    }

}
