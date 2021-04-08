package com.mail.demo.sbmail.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.mail.demo.sbmail.MyConstants;

@Configuration
public class MailConfig {
 
    @Bean
    public JavaMailSender getJavaMailSender() {
        
        // config gmail
        // remember activate gmail used by less secure apps
        //  https://www.google.com/settings/security/lesssecureapps
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
// 
//        mailSender.setUsername(MyConstants.MY_EMAIL);
//        mailSender.setPassword(MyConstants.MY_PASSWORD);
// 
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
        
        // config company mail
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("your.company.mail.host");
        mailSender.setPort(587);
 
        mailSender.setUsername(MyConstants.MY_EMAIL);
        mailSender.setPassword(MyConstants.MY_PASSWORD);
 
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.ssl", "true");
        props.put("mail.debug", "true");
 
        return mailSender;
    }
 
}
