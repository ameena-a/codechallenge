package com.mebank.codechallenge;

import java.time.LocalDateTime;
import java.util.List;

public class RelBalAndTransCalc {
    private List<Transaction> transactionList;

    public RelBalAndTransCalc(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }


    public String calculateRelativeBalanceAndTransactions(String accountID, LocalDateTime fromDateTime, LocalDateTime toDateTime){
    	
        long relativeBalance = 0;
        long reversalBalance = 0;
        int transactionCounter = 0;
        for (Transaction transaction : transactionList){
            if(transaction.getCreatedAt().isAfter(fromDateTime) && transaction.getCreatedAt().isBefore(toDateTime) && transaction.getTransactionType().equals(TransactionTypes.PAYMENT)){
                if(transaction.getFromAccountID().equals(accountID)){
            		relativeBalance -= transaction.getAmountInCents();
                    transactionCounter++;
                }else if(transaction.getToAccountID().equals(accountID)){
                    relativeBalance += transaction.getAmountInCents();
                    transactionCounter++;
                }
            }
            else if(transaction.getTransactionType().equals(TransactionTypes.REVERSAL)){
                if(transaction.getFromAccountID().equals(accountID)){
                    reversalBalance += transaction.getAmountInCents();
                    transactionCounter--;
                }else if(transaction.getToAccountID().equals(accountID)){
                    reversalBalance -= transaction.getAmountInCents();
                    transactionCounter--;
                }
               
            }
        }
        relativeBalance += reversalBalance;
        return "The Relative Balance for this period is " + CommonFormatter.convertCentToDollarDisplay(relativeBalance) + " and the Number of Transactions included is: " + transactionCounter;
    }
}
