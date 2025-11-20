package com.company.site.service;

import com.company.site.model.Admin;
import com.company.site.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public boolean login(String username, String password) {
        return adminRepository.findById(username)
                .map(a -> a.getPassword().equals(password))
                .orElse(false);
    }
}
