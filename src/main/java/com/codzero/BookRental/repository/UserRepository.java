package com.codzero.BookRental.repository;

import com.codzero.BookRental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
