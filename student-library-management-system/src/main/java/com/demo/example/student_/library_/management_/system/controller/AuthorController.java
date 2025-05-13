package com.demo.example.student_.library_.management_.system.controller;

import com.demo.example.student_.library_.management_.system.requestdto.AuthorRequestDto;
import com.demo.example.student_.library_.management_.system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author/apis")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        String response = authorService.saveAuthor(authorRequestDto);
        return response;
    }
}
