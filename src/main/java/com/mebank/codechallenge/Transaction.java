package com.mebank.codechallenge;

import java.time.LocalDateTime;

public class Transaction {

    private String transactionID;
    private String fromAccountID;
    private String toAccountID;
    private LocalDateTime createdAt;
    private long amountInCents;
    private TransactionTypes transactionType;
    private String relatedPayment;

    public Transaction(String... transactionData) {
        this.transactionID = transactionData[0].strip();
        this.fromAccountID = transactionData[1].strip();
        this.toAccountID = transactionData[2].strip();
        this.createdAt = CommonFormatter.getLocalDateTimeFromString(transactionData[3].strip());
        this.amountInCents = CommonFormatter.convertCurrencyToCents(transactionData[4].strip());
        this.transactionType = TransactionTypes.valueOf(transactionData[5].strip());
        if(this.transactionType.equals(TransactionTypes.REVERSAL)) {
            this.relatedPayment = transactionData[6].strip();
        }
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getFromAccountID() {
        return fromAccountID;
    }

    public String getToAccountID() {
        return toAccountID;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public long getAmountInCents() {
        return amountInCents;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public String getRelatedPayment() {
        return relatedPayment;
    }
}
