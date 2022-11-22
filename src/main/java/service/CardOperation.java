package service;

public interface CardOperation {

    String checkBalance(String cardNum);

    String decreaseBalance(String cardNum, Double amount);

    String replenishBalance(String cardNum, Double amount);
}
