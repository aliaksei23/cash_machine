package service.impl;

import entity.AllData;
import entity.Atm;
import service.CardOperation;

public class CardOperationImpl implements CardOperation {
    private final AllData allData;
    private final Atm atm = new Atm();

    public CardOperationImpl(AllData allData) {
        this.allData = allData;
    }

    @Override
    public String checkBalance(String cardNum) {
        return allData.getData().get(cardNum).get(1);
    }

    @Override
    public String decreaseBalance(String cardNum, Double amount) {
        Double currentBalance = Double.valueOf(allData.getData().get(cardNum).get(1));
        if (currentBalance - amount > 0 && atm.getAtmBalance() > amount) {
            String newBalance = String.valueOf(currentBalance - amount);
            atm.setAtmBalance(atm.getAtmBalance() - amount);
            allData.getData().get(cardNum).set(1, newBalance);
        } else {
            System.out.println("amount which you want is too big try another one ");
        }
        return allData.getData().get(cardNum).get(1);
    }

    @Override
    public String replenishBalance(String cardNum, Double amount) {
        Double currentBalance = Double.valueOf(allData.getData().get(cardNum).get(1));
        if (amount <= 1000000) {
            String newBalance = String.valueOf(currentBalance + amount);
            atm.setAtmBalance(atm.getAtmBalance() + amount);
            allData.getData().get(cardNum).set(1, newBalance);
        } else {
            System.out.println("amount which you want add to your balance bigger than 1 000 000 try another one ");
        }
        return allData.getData().get(cardNum).get(1);
    }
}
