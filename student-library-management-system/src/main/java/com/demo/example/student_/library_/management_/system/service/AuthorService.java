package com.demo.example.student_.library_.management_.system.service;

import com.demo.example.student_.library_.management_.system.converter.AuthorConverter;
import com.demo.example.student_.library_.management_.system.model.Author;
import com.demo.example.student_.library_.management_.system.repository.AuthorRepository;
import com.demo.example.student_.library_.management_.system.requestdto.AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String saveAuthor(AuthorRequestDto authorRequestDto){

        Author author = AuthorConverter.convertAuthorRequestDtoIntoAuthor(authorRequestDto);
        authorRepository.save(author);

        return "Author saved successfully";
    }
}
