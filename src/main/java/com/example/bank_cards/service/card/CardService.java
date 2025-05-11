package com.example.bank_cards.service.card;


import com.example.bank_cards.dto.CardDTO;
import com.example.bank_cards.entity.card.Card;
import com.example.bank_cards.entity.user.Role;
import com.example.bank_cards.entity.user.User;
import com.example.bank_cards.repository.card.CardRepository;
import com.example.bank_cards.utils.card.CardMapper;
import com.example.bank_cards.utils.card.CardUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public List<CardDTO> getCardsForUser(User user) {
        if (user.getUserRole().equals(Role.ADMIN)) {
            return cardRepository.findAll().stream()
                    .map(CardMapper::toDTO)
                    .collect(Collectors.toList());
        } else {
            return cardRepository.findByOwner(user).stream()
                    .map(CardMapper::toDTO)
                    .collect(Collectors.toList());

        }
    }

    public CardDTO addCard(Card card, User owner) {
        card.setOwner(owner);
        card.setStartTime(LocalDate.now());
        card.setEndTime(LocalDate.now().plusYears(4));
        card.setCardNumber(CardUtil.generateCardNumber());
        card.setBalance(card.getBalance() == null ? BigDecimal.ZERO : card.getBalance());

        Card savedCard = cardRepository.save(card);
        return CardMapper.toDTO(savedCard);
    }
}
