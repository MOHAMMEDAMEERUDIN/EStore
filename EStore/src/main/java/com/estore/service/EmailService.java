package com.estore.service;


public interface EmailService {

    public void sendEmail(String to, String template, String sub);

}
