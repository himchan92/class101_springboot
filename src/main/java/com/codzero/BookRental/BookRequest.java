package com.codzero.BookRental;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class BookRequest {
  @NotBlank(message = "제목은 필수입니다.")
  private String title;

  @NotBlank(message = "저자는 필수입니다.")
  private String author;

  @NotBlank(message = "출판일은 필수입니다.")
  private LocalDateTime publishedDate;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public LocalDateTime getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(LocalDateTime publishedDate) {
    this.publishedDate = publishedDate;
  }
}
