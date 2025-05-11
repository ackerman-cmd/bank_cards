package com.example.bank_cards.utils.card;

public class CardUtil {
    public static String generateCardNumber() {
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int group = (int) (Math.random() * 9000) + 1000; // от 1000 до 9999
            cardNumber.append(group);
            if (i < 3) {
                cardNumber.append(" ");
            }
        }
        return cardNumber.toString();
    }


}
