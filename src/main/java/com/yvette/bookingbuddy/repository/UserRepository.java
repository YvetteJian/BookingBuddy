package com.yvette.bookingbuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yvette.bookingbuddy.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
