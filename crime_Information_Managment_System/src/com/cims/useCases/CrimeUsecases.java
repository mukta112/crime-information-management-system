package com.cims.useCases;

import java.util.List;
import java.util.Scanner;

import com.cims.dao.CrimeDao;
import com.cims.dao.CrimeDaoImpl;
import com.cims.exceptions.CrimeException;
import com.cims.models.Crime;

public class CrimeUsecases {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	
	CrimeDao dao=new CrimeDaoImpl();
	
	public void addCrime() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter crime date like yyyy-mm-dd");
		String crimeDate=sc.next();
		
		System.out.println("Enter crime type");
		String crimeType=sc.next();
		
		System.out.println("Enter crime detail");
		String crimeDetail=sc.next();
		
		System.out.println("Enter crime status like solved or unsolved");
		String crimeStatus=sc.next();
		
		System.out.println("Enter crime suspect");
		String crimeSuspect=sc.next();
		
		System.out.println("Enter criminal ID");
		int criminalID=sc.nextInt();
		
		System.out.println("Enter area ID");
		int areaID=sc.nextInt();
		
		System.out.println("Enter ps ID");
		int psID=sc.nextInt();
		
		System.out.println("Enter victim ID");
		int victimID=sc.nextInt();
		
		
		
		try {
			String msg=dao.addCrime(crimeDate, crimeType, crimeDetail, crimeStatus,
					crimeSuspect, criminalID, areaID, psID, victimID);
			
			System.out.println(msg);
			showCrimeDetails();
			
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

	public void showCrimeDetails() {
		
		try {
			List<Crime> list=dao.showCrimeDetails();
			
			System.out.println(ANSI_RED+"CRIME TABLE"+ANSI_RESET);
			
			String leftAlignFormat = "| %-4d | %-10s | %-15s | %-25s | %-10s | %-15s | %-4d | %-4d | %-4d | %-4d |%n";
			System.out.format("+------+------------+-----------------+---------------------------+------------+-----------------+------+------+------+------+%n");
			System.out.format("| ID   | Date       | Type            | Detail               | Status     | SuspectName     | CrID | ArID | PsID | VmID |%n");
			System.out.format("+------+------------+-----------------+----------------------+------------+-----------------+------+------+------+------+%n");
			
			for(int i=0;i<list.size();i++) {
				System.out.format(leftAlignFormat,list.get(i).getCrimeID(),
						list.get(i).getCrimeDate(),list.get(i).getCrimeType(),
						list.get(i).getCrimeDetails(),list.get(i).getCrimeStatus(),
						list.get(i).getCrimeSuspect(),list.get(i).getCriminalID(),
						list.get(i).getAreaID(),list.get(i).getPsID(),list.get(i).getVictimID());
				
//				System.out.println(list.get(i));
			}		
			System.out.format("+------+------------+-----------------+----------------------+------------+-----------------+------+------+------+------+%n");			
		} catch (CrimeException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}


