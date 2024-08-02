package com.bebyaa.bookinventory.service;

import com.bebyaa.bookinventory.dto.BookDto;
import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    BookDto getBookById(Integer id);
    List<BookDto> getAllBooks();
    BookDto updateBook(Integer id, BookDto bookDto);
    void deleteBook(Integer id);
}
