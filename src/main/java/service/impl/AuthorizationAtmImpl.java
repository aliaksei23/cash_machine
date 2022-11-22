package service.impl;

import exception.CardValidatorException;
import service.AuthorizationAtm;
import service.CardValidator;

import java.util.Scanner;

public class AuthorizationAtmImpl implements AuthorizationAtm {

    private Scanner scanner = new Scanner(System.in);
    private final CardValidator cardValidator;

    public AuthorizationAtmImpl(CardValidator cardValidator) {
        this.cardValidator = cardValidator;
    }

    @Override
    public String authorization() {
        String validCard = null;
        int attempt = 3;
        for (int i = 0; i < 3; ++i) {
            String cardNum = scanner.next().trim();
            String cardPin = scanner.next().trim();
            boolean numAndPin = cardValidator.checkCardNumAndPin(cardNum, cardPin);
            if (numAndPin) {
                validCard = cardNum;
                break;
            }
            --attempt;
            if (attempt == 0) {
                try {
                    throw new CardValidatorException("Your card blocked for 24 hours");
                } catch (CardValidatorException e) {
                    e.printStackTrace();
                    System.out.println("Wrong card number or pin");
                    System.exit(1);
                }
            }
            System.out.println("Wrong card number or pin " + attempt + " attempts left");
        }
        return validCard;
    }
}
