package com.bebyaa.bookinventory.mapper;

import com.bebyaa.bookinventory.dto.BookDto;
import com.bebyaa.bookinventory.model.Book;

public class BookMapper {

    public static BookDto toBookDto(Book book) {
        if (book == null) {
            return null;
        }
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublishedDate()
        );
    }

    public static Book toBook(BookDto bookDto) {
        if (bookDto == null) {
            return null;
        }
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublishedDate(bookDto.getPublishedDate());
        return book;
    }
}
