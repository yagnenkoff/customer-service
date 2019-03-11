package com.yagnenkoff.demo.repository;

import com.yagnenkoff.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Transactional
    void deleteById(Long id);
}
