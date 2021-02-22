package com.mebank.codechallenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainProgramme {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        String fileName = args[0];//"path-to-file/filename.csv";

        Stream<String> streamedFile = null;
        try {
            streamedFile = getStreamfromFile(fileName);
        }catch (IOException ioe){
            ioe.printStackTrace();
            System.exit(1);
        }
        List<Transaction> transactionList = transformStreamToTransactions(streamedFile);
        RelBalAndTransCalc rbc = new RelBalAndTransCalc(transactionList);

        System.out.println("Enter the Account ID : ");
        String accountID = scanner.nextLine();
        System.out.println("Enter the From Date : ");
        LocalDateTime fromDate = CommonFormatter.getLocalDateTimeFromString(scanner.nextLine());
        System.out.println("Enter the To Date : ");
        LocalDateTime toDate = CommonFormatter.getLocalDateTimeFromString(scanner.nextLine());
        System.out.println(rbc.calculateRelativeBalanceAndTransactions(accountID, fromDate, toDate));
        System.exit(0);

        
    }

    private static Stream<String> getStreamfromFile(String fileNameWithPath) throws IOException {
        Stream<String> transactions = Files.lines(Paths.get(fileNameWithPath));        
        Stream<String> transactionsWithoutHeader = transactions.skip(1);
        return transactionsWithoutHeader;
    }

    static List<Transaction> transformStreamToTransactions(Stream<String> transactions) {
        List<Transaction> transactionList = new ArrayList<>();
        transactions.forEach(transaction ->  transactionList.add(createTransactionFromInput(transaction)));
        return transactionList;
    }

    static Transaction createTransactionFromInput(String inputLine){
        return new Transaction(inputLine.split(","));
    }

   
}
