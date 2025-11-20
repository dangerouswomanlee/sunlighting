package com.company.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.site.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
