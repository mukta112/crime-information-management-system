package com.cims.dao;

import java.util.List;

import com.cims.exceptions.CriminalException;
import com.cims.models.Criminal;

public interface CriminalDao {

	public String addCriminal(String criminalName,int criminalAge,String criminalGender,
			String criminalAddress,String criminalIdentificationMark)throws CriminalException;
	public List<Criminal> showCriminalDetails()throws CriminalException;
	
}

