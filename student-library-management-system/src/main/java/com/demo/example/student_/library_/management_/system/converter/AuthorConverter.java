package com.demo.example.student_.library_.management_.system.converter;

import com.demo.example.student_.library_.management_.system.model.Author;
import com.demo.example.student_.library_.management_.system.model.Student;
import com.demo.example.student_.library_.management_.system.requestdto.AuthorRequestDto;
import com.demo.example.student_.library_.management_.system.requestdto.StudentRequestDto;

public class AuthorConverter {

    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto) {
        Author author = new Author();

        author.setName(authorRequestDto.getName());
        author.setCountry(authorRequestDto.getCountry());
        author.setGender(authorRequestDto.getGender());
        author.setRating(authorRequestDto.getRating());
        author.setEmail(authorRequestDto.getEmail());

        return author;
    }
}
