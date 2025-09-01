package com.codzero.BookRental.service;

import com.codzero.BookRental.BookRequest;
import com.codzero.BookRental.entity.Book;
import com.codzero.BookRental.exception.NotFoundException;
import com.codzero.BookRental.repository.BookRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  private final List<Book> books = new ArrayList<>();

  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public Book createBook(BookRequest bookRequest) {
    return bookRepository.save(new Book(bookRequest.getTitle(), bookRequest.getAuthor(), bookRequest.getPublishedDate()));
  }

  public List<Book> getBooks() {
    return books;
  }

  public Book updateBook(Long id, Book updateBook) {
    for(Book book : books) {
      if(book.getId().equals(id)) {
        book.setTitle(updateBook.getTitle());
        return book;
      }
    }

    return null;
  }

  public boolean deleteBook(Long id) {
    for(Iterator<Book> iterator = books.iterator(); iterator.hasNext();) {
      Book book = iterator.next();
      if(book.getId().equals(id)) {
        iterator.remove();
        return true;
      }
    }
    return false;
  }

  public Book getBookById(Long id) {
    return bookRepository.findById(id).orElseThrow(() -> new NotFoundException("도서를 찾을 수 없습니다."));
  }
}
