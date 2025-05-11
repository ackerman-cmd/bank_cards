package com.example.bank_cards.utils.card;

import com.example.bank_cards.dto.CardDTO;
import com.example.bank_cards.entity.card.Card;

public class CardMapper {
    public static CardDTO toDTO(Card card) {
        return CardDTO.builder()
                .id(card.getId())
                .maskedCardNumber(maskCardNumber(card.getCardNumber()))
                .cardStatus(card.getCardStatus())
                .startTime(card.getStartTime())
                .endTime(card.getEndTime())
                .balance(card.getBalance())
                .build();
    }

    public static String maskCardNumber(String fullNumber) {
        return "**** **** **** " + fullNumber.substring(fullNumber.length() - 4);
    }
}
