package com.cims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cims.exceptions.CrimeException;
import com.cims.models.Crime;
import com.cims.utility.DBUtil;

public class CrimeDaoImpl implements CrimeDao {

	@Override
	public String addCrime(String crimeDate, String crimeType, String crimeDetails, String crimeStatus,
			String CrimeSuspect, int criminalID, int areaID, int psID, int victimID) throws CrimeException {

		String message="Crime details not inserted.....";
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO CRIME(crime_date,crime_type,"
					+ "crime_details,crime_status,crime_suspect,criminal_id,area_id,ps_id,victim_id) "
					+ "VALUES(?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, crimeDate);
			ps.setString(2, crimeType);
			ps.setString(3, crimeDetails);
			ps.setString(4, crimeStatus);
			ps.setString(5, CrimeSuspect);
			ps.setInt(6, criminalID);
			ps.setInt(7, areaID);
			ps.setInt(8, psID);
			ps.setInt(9, victimID);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Crime details added successfully.";
				showCrimeDetails();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Crime> showCrimeDetails() throws CrimeException {

		List<Crime> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM CRIME ORDER BY CRIME_ID");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("crime_id");
				String date=rs.getString("crime_date");
				String type=rs.getString("crime_type");				
				String details=rs.getString("crime_details");
				String status=rs.getString("crime_status");
				String suspect=rs.getString("crime_suspect");
				int crid=rs.getInt("criminal_id");
				int aid=rs.getInt("area_id");
				int psid=rs.getInt("ps_id");
				int vid=rs.getInt("victim_id");
				
				Crime crime=new Crime();
				crime.setCrimeID(id);
				crime.setCrimeDate(date);
				crime.setCrimeType(type);
				crime.setCrimeDetails(details);
				crime.setCrimeStatus(status);
				crime.setCrimeSuspect(suspect);
				crime.setCriminalID(crid);
				crime.setAreaID(aid);
				crime.setPsID(psid);
				crime.setVictimID(vid);
				
				list.add(crime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		
		return list;
	}
	
}
