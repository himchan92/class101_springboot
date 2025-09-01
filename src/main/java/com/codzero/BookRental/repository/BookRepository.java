package com.codzero.BookRental.repository;

import com.codzero.BookRental.entity.Book;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByTitle(String title); //제목조회
  List<Book> findByAuthor(String author);
  List<Book> findByPublishedDate(LocalDateTime publishedDate);
  List<Book> findByAuthorAndPublishedDate(String author, LocalDateTime publishedDate);
}
