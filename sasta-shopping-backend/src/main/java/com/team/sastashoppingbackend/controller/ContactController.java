package com.team.sastashoppingbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.sastashoppingbackend.entity.Contact;
import com.team.sastashoppingbackend.service.ContactService;

@RestController
@RequestMapping("/contactQueries")
@CrossOrigin(origins = "*")
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@PostMapping
	public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
		Contact newContact = contactService.createContact(contact);
		return new ResponseEntity<>(newContact, HttpStatus.CREATED);
	}

}
