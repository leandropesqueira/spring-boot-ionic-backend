package com.leandrolopes.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.leandrolopes.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
