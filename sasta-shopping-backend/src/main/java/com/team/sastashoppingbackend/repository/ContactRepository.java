package com.team.sastashoppingbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.sastashoppingbackend.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>  {

}
