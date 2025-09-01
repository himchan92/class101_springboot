package com.codzero.BookRental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Rental {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  private Book book;

  private LocalDateTime rentedDate;
  private LocalDateTime returnedDate;

  public Rental() {}

  public Rental(User user, Book book) {
    this.user = user;
    this.book = book;
    this.rentedDate = LocalDateTime.now();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public LocalDateTime getRentedDate() {
    return rentedDate;
  }

  public void setRentedDate(LocalDateTime rentedDate) {
    this.rentedDate = rentedDate;
  }

  public LocalDateTime getReturnedDate() {
    return returnedDate;
  }

  public void setReturnedDate(LocalDateTime returnedDate) {
    this.returnedDate = returnedDate;
  }
}
