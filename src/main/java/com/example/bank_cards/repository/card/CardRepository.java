package com.example.bank_cards.repository.card;

import com.example.bank_cards.entity.card.Card;
import com.example.bank_cards.entity.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface CardRepository extends CrudRepository<Card, Long> {
    @Query("SELECT c FROM Card c ORDER BY c.startTime, c.endTime")
    List<Card> findAll();

    List<Card> findByOwner(User owner);
}
