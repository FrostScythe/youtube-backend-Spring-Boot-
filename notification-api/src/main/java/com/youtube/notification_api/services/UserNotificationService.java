package com.youtube.notification_api.services;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.time.LocalDate;
import java.util.Properties;

@Service
public class UserNotificationService {

    public TemplateEngine getTemplateEngine(){
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/"); // Make sure this folder exists in resources
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    public JavaMailSender generateJavaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com"); // For now email which i am using belongs to gmail so, the host will be smtp.gmail.com
        javaMailSender.setPort(587); // genrally to send mail from our computer we require some port number so, the port number which we will use is 587
        javaMailSender.setUsername("accioshoppingwebsite@gmail.com");// We will be sending email so, by what email our spring application will send mail to the users
        javaMailSender.setPassword("relcfdwhahhcvokv"); // Password of the email.... It is app password, not actual password
        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true"); // Our springboot api will connect gmail to send email via password so, mail.smtp.auth is true
        props.put("mail.smtp.starttls.enable", "true"); // This property we are setting for secure connection
        return javaMailSender;

    }

    public void sendUserRegistrationNotification(String userName,
                                                 String userEmail){
        JavaMailSender javaMailSender = generateJavaMailSender();
        // We require MimeMessage object to create mail content.
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // Now to set values inside the mimeMessage we require object of another class called MiMeMessageHelper
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        // We will start setting mail content
        Context context = new Context();
        context.setVariable("appName", "AccioWatch");
        context.setVariable("userName", userName);
        context.setVariable("year", 2025);
        TemplateEngine templateEngine = getTemplateEngine();
        String htmlTemplate = templateEngine.process("registration-template", context);

        try{
            mimeMessageHelper.setTo(userEmail);
            mimeMessageHelper.setSubject("Congratulations!! " + userName +  " for successfull registration at our video platform");
            mimeMessageHelper.setText(htmlTemplate, true);
        }catch (Exception e){

        }
        javaMailSender.send(mimeMessage);
    }
}
