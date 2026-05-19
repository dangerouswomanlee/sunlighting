package com.company.site.service;

import com.company.site.model.Contact;
import com.company.site.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public Contact save(Contact contact) {
        if (contact.getId() == null) {
            contact.setCreatedAt(LocalDateTime.now());
            contact.setPassword(passwordEncoder.encode(contact.getPassword()));
        }
        return contactRepository.save(contact);
    }

    public List<Contact> findAll() {
        List<Contact> list = contactRepository.findAll();
        list.sort(Comparator.comparing(Contact::getId).reversed());
        return list;
    }

    public List<Contact> search(String keyword) {
        if (keyword == null || keyword.isBlank()) return findAll();
        List<Contact> list = contactRepository.findByTitleContainingIgnoreCase(keyword);
        list.sort(Comparator.comparing(Contact::getId).reversed());
        return list;
    }

    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    public boolean checkPassword(Contact contact, String inputPassword) {
        return passwordEncoder.matches(inputPassword, contact.getPassword());
    }

    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
