package com.company.site.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String name;
    private String phone;
    private String email;
    private String password;


    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDateTime createdAt;
    
    

    // 관리자 답변
    @Column(columnDefinition = "TEXT")
    private String adminReply;
    private LocalDateTime replyAt;
}
