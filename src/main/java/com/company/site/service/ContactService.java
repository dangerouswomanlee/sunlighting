package com.company.site.service;

import com.company.site.model.Contact;
import com.company.site.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public Contact save(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public List<Contact> findAll() {
        List<Contact> list = contactRepository.findAll();

        list.sort(Comparator.comparing(Contact::getId).reversed());

        return list;
    }

    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    public boolean checkPassword(Contact contact, String inputPassword) {
        return contact.getPassword().equals(inputPassword);
    }
}
