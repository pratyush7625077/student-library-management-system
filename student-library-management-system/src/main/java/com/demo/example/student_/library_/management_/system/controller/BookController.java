package com.demo.example.student_.library_.management_.system.controller;


import com.demo.example.student_.library_.management_.system.requestdto.BookRequestDto;
import com.demo.example.student_.library_.management_.system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/apis")
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping("/save")
    public String saveBook(@RequestBody BookRequestDto bookRequestDto){
        String response = bookService.saveBook(bookRequestDto);
        return response;
    }
}
