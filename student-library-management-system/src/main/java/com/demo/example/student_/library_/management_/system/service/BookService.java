package com.demo.example.student_.library_.management_.system.service;

import com.demo.example.student_.library_.management_.system.converter.BookConverter;
import com.demo.example.student_.library_.management_.system.model.Author;
import com.demo.example.student_.library_.management_.system.model.Book;
import com.demo.example.student_.library_.management_.system.model.Card;
import com.demo.example.student_.library_.management_.system.repository.AuthorRepository;
import com.demo.example.student_.library_.management_.system.repository.BookRepository;
import com.demo.example.student_.library_.management_.system.repository.CardRepository;
import com.demo.example.student_.library_.management_.system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CardRepository cardRepository;
    public String saveBook(BookRequestDto bookRequestDto){

       Book book = BookConverter.convertbookRequestDtoIntobook(bookRequestDto);

       // using AuthorId fetch the complete object of author from author repository

      Author author =  authorRepository.findById(bookRequestDto.getAuthorId()).get();
       if(author == null){
           book.setAuthor(null);
       }else{
           book.setAuthor(author);
       }

       Card card = cardRepository.findById(bookRequestDto.getCardId()).get();
       if(card==null){
           book.setCard(null);
        }else{
           book.setCard(card);
       }
       bookRepository.save(book);

       return "Book Saved Successfully";
    }
}
