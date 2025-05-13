package com.demo.example.student_.library_.management_.system.converter;

import com.demo.example.student_.library_.management_.system.model.Transaction;
import com.demo.example.student_.library_.management_.system.requestdto.TransactionRequestDto;

public class TransactionConverter {

    public static Transaction convertTransactionRequestDtoIntoTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction = new Transaction();

        transaction.setFine(transactionRequestDto.getFine());
        transaction.setDueDate(transactionRequestDto.getDueDate());
        transaction.setTransactionType(transactionRequestDto.getTransactionType());

        return transaction;
    }
}
