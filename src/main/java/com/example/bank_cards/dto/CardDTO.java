package com.example.bank_cards.dto;

import com.example.bank_cards.entity.card.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDTO {

    private Long id;
    private String maskedCardNumber;
    private LocalDate startTime;
    private LocalDate endTime;
    private CardStatus cardStatus;
    private BigDecimal balance;

}
