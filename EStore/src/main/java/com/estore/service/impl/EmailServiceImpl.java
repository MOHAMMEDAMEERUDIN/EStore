package com.estore.service.impl;

import com.estore.service.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service("emailService")
public class EmailServiceImpl implements EmailService {

    private Logger logger = LogManager.getLogger(EmailServiceImpl.class);
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String customerEmail, String template, String sub) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(customerEmail);
            msg.setSubject(sub);
            msg.setText(template);

            javaMailSender.send(msg);
        } catch (final Exception ex) {
            logger.error(ex.getMessage());
        }

    }


}
