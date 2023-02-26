package com.yvette.bookingbuddy.repository;

import com.yvette.bookingbuddy.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,String> {

}