package com.codzero.BookRental;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import com.codzero.BookRental.exception.NotFoundException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookServiceTest {
  private BookService bookService;

  @BeforeEach //테스트 실행전 수행
  void setUp() {
    BookRepository bookRepository = mock(BookRepository.class);
    bookService = new BookService(bookRepository);
  }

  @Test
  void 책생성() {
    BookRequest bookRequest = new BookRequest();
    String bookName = "테스트 책";
    bookRequest.setTitle(bookName);
    bookRequest.setAuthor("홍길동");
    bookRequest.setPublishedDate(LocalDateTime.now());
    Book saved = bookService.createBook(bookRequest);

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
    BookRequest book = new BookRequest();
    book.setTitle(title);
    bookService.createBook(book);
  }

  @Test
  void 책을삭제() {
    BookRequest book = new BookRequest();
    book.setTitle("삭제할 책");
    bookService.createBook(book);

    boolean deleted = bookService.deleteBook(1L);

    assertThat(deleted).isTrue();
    assertThat(bookService.getBooks().size()).isEqualTo(0);
  }

  @Test
  void 책을조회한다() {
    assertThatThrownBy(() -> bookService.getBookById(11L))
        .isInstanceOf(NotFoundException.class)
        .hasMessage("도서를 찾을 수 없습니다.");
  }
}