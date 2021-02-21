
This repository contains code that is a solution to the Relative Balance Calculator Coding Test.

## Getting Started

Checkout the Git Repository on `master`. 

### Prerequisites

This program is build in Java using `JDK 11`.

The program uses `Apache Maven 3.6` to build. Please ensure you have a Maven installation of `3.6 +` on your local environment.

What things you need to install the software and how to install them

### Installing

The program is packaged as an executable `JAR` file.

Code needs to be compiled and the `JAR` file created by running the maven install command at the project root.

```
mvn clean install
```

The program produces a JAR file in the `target` directory and the local `maven repo`.

### Running

The JAR file is executable and the program can be run by executing it. Use the command:
```
java -jar codechallenge-0.0.1-SNAPSHOT.jar <path-to-input-csv>
```

The program takes a CSV list of transactions as input specified in the challenge requirements.

Once run, the program requests User Input:

- `accountID` - The account to calculate the balance for
- `fromDate` - The From Date to begin the calculation at. Input Format `dd/MM/yyyy HH:mm:ss`
- `toDate` - The To Date to begin the calculation at. Input Format `dd/MM/yyyy HH:mm:ss`

The program outputs the relative balance and number of transactions in the calculation as per the challenge requirements

### Running the tests

Tests with coverage reports can be obtained by running the below command on the project root

```
mvn clean test jacoco:report
```

Reports are produced using `JoCoCo` and are available under `/target/site`


