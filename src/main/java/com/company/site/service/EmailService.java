package com.company.site.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendReplyNotification(String to, String contactTitle, String replyContent) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject("[썬라이팅] 문의하신 내용에 답변이 등록되었습니다.");
            message.setText(
                "안녕하세요.\n\n" +
                "문의하신 내용에 관리자 답변이 등록되었습니다.\n\n" +
                "■ 문의 제목: " + contactTitle + "\n\n" +
                "■ 관리자 답변:\n" + replyContent + "\n\n" +
                "추가 문의사항이 있으시면 언제든지 연락 주세요.\n\n" +
                "감사합니다.\n" +
                "(주)썬라이팅 드림\n" +
                "TEL: 010-9124-7815 | E-mail: sunlig2030@naver.com"
            );
            mailSender.send(message);
            log.info("답변 알림 메일 발송 완료 - 수신자: {}", to);
        } catch (MailException e) {
            log.error("답변 알림 메일 발송 실패 - 수신자: {}", to, e);
        }
    }
}
