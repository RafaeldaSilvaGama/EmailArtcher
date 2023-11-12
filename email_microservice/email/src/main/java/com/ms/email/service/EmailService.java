package com.ms.email.service;


import com.ms.email.enums.StatusEmail;
import com.ms.email.model.Email;
import com.ms.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;


    public Email sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("artcherapp@gmail.com");
            message.setTo(email.getEmail());
            message.setSubject("Bem-vindo ao Artcher");
            message.setText("Prezado(a) %s estamos muito felizes em receber-lhe. \n\n\nEquipe Artcher Tec.".formatted(email.getUsuario()));
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(email);
        }


    }
}
