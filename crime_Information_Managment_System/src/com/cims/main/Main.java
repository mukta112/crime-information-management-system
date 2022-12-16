package com.cims.main;

import com.cims.models.Crime;
import com.cims.useCases.AreaUsecases;
import com.cims.useCases.CrimeUsecases;
import com.cims.useCases.CriminalUsecases;
import com.cims.useCases.LoginUsecase;
import com.cims.useCases.PoliceStationUsecase;
import com.cims.useCases.VictimUsecases;

public class Main {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";

	public static void main(String[] args) {
		
		
		System.out.println(ANSI_BLUE+"Welcome to Crime Information Management System !"+ANSI_RESET);
		
//		PoliceStationUsecase ps=new PoliceStationUsecase();
//		ps.addPoliceStation();
//		ps.showPoliceStationDetails();
		
//		AreaUsecases a=new AreaUsecases();
//		a.addArea();
//		a.showAreaDetails();
		
//		VictimUsecases v=new VictimUsecases();
//		v.addVictim();
		
		CriminalUsecases c = new CriminalUsecases();
//		c.addCriminal();
//		c.SearchCriminalByArea();
//		c.SearchCriminalByPoliceStation();
		
		CrimeUsecases crime=new CrimeUsecases();
		//crime.addCrime();
//		crime.showCrimeDetails();
//		crime.SearchCrimeByArea();
//		crime.SearchCrimeByPoliceStation();
//		crime.checkStatusByCrimeID();
//		crime.updateCrimeStatusByCrimeID();
//		crime.numberOfSolvedOrUnsolvedCases();
//		crime.numberOfCrimesRecordedInCurrentMonth();
		
		LoginUsecase login=new LoginUsecase();
		login.validateLogin();
		
		
		
		
		
		
		
		
		
		
	}

}
