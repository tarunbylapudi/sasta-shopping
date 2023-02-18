package com.team.sastashoppingbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.sastashoppingbackend.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
