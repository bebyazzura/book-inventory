package com.bebyaa.bookinventory.service.impl;

import com.bebyaa.bookinventory.dto.BookDto;
import com.bebyaa.bookinventory.exception.BookNotFoundException;
import com.bebyaa.bookinventory.mapper.BookMapper;
import com.bebyaa.bookinventory.model.Book;
import com.bebyaa.bookinventory.repository.BookRepository;
import com.bebyaa.bookinventory.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = BookMapper.toBook(bookDto);
        Book savedBook = bookRepository.save(book);
        return BookMapper.toBookDto(savedBook);
    }

    @Override
    public BookDto getBookById(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        return BookMapper.toBookDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookMapper::toBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(Integer id, BookDto bookDto) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        existingBook.setTitle(bookDto.getTitle());
        existingBook.setAuthor(bookDto.getAuthor());
        existingBook.setPublishedDate(bookDto.getPublishedDate());

        Book updatedBook = bookRepository.save(existingBook);
        return BookMapper.toBookDto(updatedBook);
    }

    @Override
    public void deleteBook(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        bookRepository.delete(book);
    }
}