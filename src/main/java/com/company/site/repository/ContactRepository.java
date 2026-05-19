package com.company.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.site.model.Contact;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByTitleContainingIgnoreCase(String keyword);
}
