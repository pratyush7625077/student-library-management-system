package com.demo.example.student_.library_.management_.system.converter;

import com.demo.example.student_.library_.management_.system.model.Card;
import com.demo.example.student_.library_.management_.system.requestdto.CardRequestDto;

public class CardConverter {

    public static Card convertCardRequestDtoIntoCard(CardRequestDto cardRequestDto){
        Card card = new Card();

        card.setCardStatus(cardRequestDto.getCardStatus());
        return card;
    }
}
