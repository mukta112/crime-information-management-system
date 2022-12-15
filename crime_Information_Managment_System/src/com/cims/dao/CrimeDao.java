package com.cims.dao;

import java.util.List;

import com.cims.exceptions.CrimeException;
import com.cims.models.Crime;

public interface CrimeDao {
	
	public String addCrime(String crimeDate,String crimeType,String crimeDetails,
			String crimeStatus,String CrimeSuspect,int criminalID,int areaID,
			int psID,int victimID )throws CrimeException;
	
	public List<Crime> showCrimeDetails()throws CrimeException;
	
}
