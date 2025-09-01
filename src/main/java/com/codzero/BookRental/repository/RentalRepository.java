package com.codzero.BookRental.repository;

import com.codzero.BookRental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
