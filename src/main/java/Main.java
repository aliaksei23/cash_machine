import entity.AllData;
import service.*;
import service.impl.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AllData allData = new AllData();
        DataReader dataReader = new DataReaderImpl();
        dataReader.getData(allData);
        CardValidator cardValidator = new CardValidatorImpl(allData);
        CardOperation cardOperation = new CardOperationImpl(allData);
        AuthorizationAtm authorizationAtm = new AuthorizationAtmImpl(cardValidator);
        DataWriter dataWriter = new DataWriterImpl(allData);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your card number and pin in format:" +
                "card number XXXX-XXXX-XXXX-XXXX " +
                "pin **** you have 3 attempts");

        String validCard = authorizationAtm.authorization();
        System.out.println("Welcome!");
        System.out.println("Press 1 - check balance");
        System.out.println("Press 2 - withdraw funds from the account");
        System.out.println("Press 3 - replenish the balance");
        System.out.println("Press -1 - for exit");

        int choice = 0;
        while (choice != -1) {
            choice = scanner.nextInt();
            switch (choice) {
                case (1) -> System.out.println(cardOperation.checkBalance(validCard));
                case (2) -> {
                    System.out.println("Put amount for withdraw funds from the account");
                    Double amountDecrease = scanner.nextDouble();
                    System.out.println(cardOperation.decreaseBalance(validCard, amountDecrease));
                    dataWriter.writeData();
                }
                case (3) -> {
                    System.out.println("Put amount for replenish your balance");
                    Double amountDecrease = scanner.nextDouble();
                    System.out.println(cardOperation.replenishBalance(validCard, amountDecrease));
                    dataWriter.writeData();
                }
            }
        }
    }
}

