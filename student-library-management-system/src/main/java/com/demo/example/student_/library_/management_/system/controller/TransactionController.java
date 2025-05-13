package com.demo.example.student_.library_.management_.system.controller;


import com.demo.example.student_.library_.management_.system.model.Transaction;
import com.demo.example.student_.library_.management_.system.requestdto.TransactionRequestDto;
import com.demo.example.student_.library_.management_.system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/apis")
public class TransactionController {


    @Autowired
    private TransactionService transactionService;


    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto){

        String response = transactionService.saveTransaction(transactionRequestDto);
            return response;
    }
}
