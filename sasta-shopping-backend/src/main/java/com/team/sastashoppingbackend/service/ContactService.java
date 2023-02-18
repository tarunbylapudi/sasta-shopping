package com.team.sastashoppingbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.sastashoppingbackend.entity.Contact;
import com.team.sastashoppingbackend.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
    private ContactRepository contactRepository;

	public Contact createContact(Contact contact) {
	
		return contactRepository.save(contact);
	}
}
