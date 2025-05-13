package com.demo.example.student_.library_.management_.system.converter;


import com.demo.example.student_.library_.management_.system.model.Book;
import com.demo.example.student_.library_.management_.system.requestdto.BookRequestDto;

public class BookConverter {

    public static Book convertbookRequestDtoIntobook(BookRequestDto bookRequestDto) {
        Book book = new Book();

        book.setTitle(bookRequestDto.getTitle());
        book.setAvailability(bookRequestDto.isAvailability());
        book.setPrice(bookRequestDto.getPrice());
        book.setRackNo(bookRequestDto.getRackNo());
        book.setCategory(bookRequestDto.getCategory());
        book.setPublishedDate(bookRequestDto.getPublishedDate());
        book.setPublisherName(bookRequestDto.getPublisherName());
        book.setPages(bookRequestDto.getPages());

        return book;
    }
}
