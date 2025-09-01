package com.codzero.BookRental.service;

import com.codzero.BookRental.entity.Book;
import com.codzero.BookRental.entity.Rental;
import com.codzero.BookRental.entity.User;
import com.codzero.BookRental.exception.NotFoundException;
import com.codzero.BookRental.repository.BookRepository;
import com.codzero.BookRental.repository.RentalRepository;
import com.codzero.BookRental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

  private final BookRepository bookRepository;
  private final UserRepository userRepository;
  private final RentalRepository rentalRepository;

  @Autowired
  public RentalService(BookRepository bookRepository, UserRepository userRepository,
      RentalRepository rentalRepository) {
    this.bookRepository = bookRepository;
    this.userRepository = userRepository;
    this.rentalRepository = rentalRepository;
  }

  public void rentBook(Long bookId, Long userId) {
    Book  book = bookRepository.findById(bookId)
        .orElseThrow(() -> new NotFoundException("해당하는 책이 없습니다>"));

    User user = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("해당 사용자가 없습니다."));

    Rental rental = new Rental(user, book);
    rentalRepository.save(rental);
  }
}
