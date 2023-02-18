package com.team.sastashoppingbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.sastashoppingbackend.entity.Contact;
import com.team.sastashoppingbackend.entity.Customer;
import com.team.sastashoppingbackend.service.ContactService;

@RestController
@RequestMapping("/contactQueries")
public class ContactController {
	private ContactService contactService;
	
	  @PostMapping
	    public ResponseEntity<Contact> createCustomer(@RequestBody Contact contact) {
		  Contact newContact = contactService.createCustomer(contact);
	        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
	    }

}
