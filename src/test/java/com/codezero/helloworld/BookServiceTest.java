package com.codezero.helloworld;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookServiceTest {
  private BookService bookService;

  @BeforeEach //테스트 실행전 수행
  void setUp() {
    bookService = new BookService();
  }

  @Test
  void 책생성() {
    Book book = new Book();
    book.setTitle("테스트 책");
    Book saved = bookService.createBook(book);

    assertThat(saved.getId()).isNotNull();
    assertThat(saved.getTitle()).isEqualTo("테스트 책");
    assertThat(bookService.getBooks().size()).isEqualTo(1);
  }

  @Test
  void 책을수정한다() {
    createBook("원본 책");

    Book update = new Book();
    update.setTitle("수정된 책");

    Book updateBook = bookService.updateBook(1L, update);

    assertThat(updateBook.getTitle()).isEqualTo("수정된 책");
  }

  private void createBook(String title) {
    Book book = new Book();
    book.setTitle(title);
    bookService.createBook(book);
  }

  @Test
  void 책을삭제() {
    Book book = new Book();
    book.setTitle("삭제할 책");
    bookService.createBook(book);

    boolean deleted = bookService.deleteBook(1L);

    assertThat(deleted).isTrue();
    assertThat(bookService.getBooks().size()).isEqualTo(0);
  }
}