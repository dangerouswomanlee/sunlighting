package com.company.site.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "작성자를 입력해주세요.")
    private String name;

    @NotBlank(message = "전화번호를 입력해주세요.")
    @Pattern(regexp = "^0\\d{1,2}-?\\d{3,4}-?\\d{4}$", message = "올바른 전화번호 형식으로 입력해주세요. (예: 010-1234-5678)")
    private String phone;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 형식으로 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 4, max = 20, message = "비밀번호는 4자 이상 20자 이하로 입력해주세요.")
    private String password;

    @NotBlank(message = "문의 내용을 입력해주세요.")
    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDateTime createdAt;

    @Column(columnDefinition = "TEXT")
    private String adminReply;
    private LocalDateTime replyAt;
}
