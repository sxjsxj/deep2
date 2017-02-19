package com.deep.two.service.authority;

import com.deep.two.util.ViewException;

public interface EmailService {
	public boolean sendEmail(String to) throws ViewException;
	public boolean validateCode(String to, String code) throws ViewException;
}
