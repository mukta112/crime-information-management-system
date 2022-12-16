package com.cims.useCases;

import java.util.Scanner;

import com.cims.dao.LoginDao;
import com.cims.dao.LoginDaoImpl;
import com.cims.exceptions.LoginException;

public class LoginUsecase {
			
	public void validateLogin() {
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Username");
		String username=sc.next();
		
		System.out.println("Enter Password");
		String password=sc.next();
		
		LoginDao dao=new LoginDaoImpl();
		
		try {
			String msg=dao.validateLogin(username, password);
			
			System.out.println(msg);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
