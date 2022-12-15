package com.cims.useCases;

import java.util.List;
import java.util.Scanner;

import com.cims.dao.CriminalDao;
import com.cims.dao.CriminalDaoImpl;
import com.cims.exceptions.CriminalException;
import com.cims.models.Criminal;

public class CriminalUsecases {
	
	CriminalDao dao=new CriminalDaoImpl();
	
	public void addCriminal() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter criminal name");
		String criminalName=sc.next();
		
		System.out.println("Enter criminal age");
		int criminalAge=sc.nextInt();
		
		System.out.println("Enter criminal gender (M/F)");
		String criminalGender=sc.next();
		
		System.out.println("Enter criminal address");
		String criminalAddress=sc.next();
		
		System.out.println("Enter criminal identification mark");
		String criminalIdentificationMark=sc.next();
		
		try {
			String msg=dao.addCriminal(criminalName, criminalAge, criminalGender,criminalAddress,criminalIdentificationMark);
			System.out.println(msg);
			showCriminalDetails();
			
		} catch (CriminalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

	public void showCriminalDetails() {
		
		try {
			List<Criminal> list=dao.showCriminalDetails();
			
			String leftAlignFormat = "| %-4d | %-15s | %-4d | %-8s | %-15s | %-20s |%n";
			System.out.format("+------+-----------------+------+----------+-----------------+----------------------+%n");
			System.out.format("| ID   | CriminalName    | Age  | Gender   | Address         | IdentificationMark   |%n");
			System.out.format("+------+-----------------+------+----------+-----------------+----------------------+%n");
			
			for(int i=0;i<list.size();i++) {
				System.out.format(leftAlignFormat,list.get(i).getCriminalID(),
						list.get(i).getCriminalName(),list.get(i).getCriminalAge(),
						list.get(i).getCriminalGender(),list.get(i).getCriminalAddress(),list.get(i).getCriminalIdentificationMark());
				
//				System.out.println(list.get(i));
			}		
			System.out.format("+------+-----------------+------+----------+-----------------+----------------------+%n");			
			
		} catch (CriminalException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}

