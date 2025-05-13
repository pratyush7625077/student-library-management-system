package com.demo.example.student_.library_.management_.system.service;

import com.demo.example.student_.library_.management_.system.converter.TransactionConverter;
import com.demo.example.student_.library_.management_.system.model.Book;
import com.demo.example.student_.library_.management_.system.model.Card;
import com.demo.example.student_.library_.management_.system.model.Transaction;
import com.demo.example.student_.library_.management_.system.repository.BookRepository;
import com.demo.example.student_.library_.management_.system.repository.CardRepository;
import com.demo.example.student_.library_.management_.system.repository.TransactionRepository;
import com.demo.example.student_.library_.management_.system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;


    public String saveTransaction(TransactionRequestDto transactionRequestDto){

        Transaction transaction = TransactionConverter.convertTransactionRequestDtoIntoTransaction(transactionRequestDto);

        Book book = bookRepository.findById(transactionRequestDto.getBookId()).get();
        if(book==null){
            transaction.setBook(null);
        }else{
            transaction.setBook(book);
        }

        Card card = cardRepository.findById(transactionRequestDto.getCardId()).get();
        if(card==null){
            transaction.setCard(null);
        }else{
            transaction.setCard(card);
        }

        transactionRepository.save(transaction);
        return "Transaction saved Successfully";
    }
}
