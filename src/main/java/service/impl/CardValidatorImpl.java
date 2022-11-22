package service.impl;

import entity.AllData;
import service.CardValidator;

import java.util.List;
import java.util.Set;

public class CardValidatorImpl implements CardValidator {
    private final AllData allData;

    public CardValidatorImpl(AllData allData) {
        this.allData = allData;
    }

    @Override
    public boolean checkCardNumAndPin(String cardNum, String cardPin) {
        boolean checkedCardNum = checkCardNum(cardNum);
        if (checkedCardNum) {
            return checkCardPin(cardNum, cardPin);
        }
        return false;
    }

    private boolean checkCardPin(String checkedCardNum, String cardPin) {
        List<String> list = allData.getData().get(checkedCardNum);
        for (String cardPinFromData : list) {
            if (cardPinFromData.equals(cardPin)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCardNum(String cardNum) {
        Set<String> keySet = allData.getData().keySet();
        for (String cardNumFromData : keySet) {
            if (cardNumFromData.equals(cardNum)) {
                return true;
            }
        }
        return false;
    }
}
