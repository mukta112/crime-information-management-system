package com.cims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cims.exceptions.CriminalException;
import com.cims.models.Criminal;
import com.cims.utility.DBUtil;

public class CriminalDaoImpl implements CriminalDao {

	@Override
	public String addCriminal(String criminalName,int criminalAge,String criminalGender,String criminalAddress,String criminalIdentificationMark) throws CriminalException {
		String message="Criminal not inserted.....";
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO CRIMINAL(criminal_name,criminal_age,criminal_gender,criminal_address,criminal_identification_mark) VALUES(?,?,?,?,?)");
			
			ps.setString(1, criminalName);
			ps.setInt(2, criminalAge);
			ps.setString(3, criminalGender);
			ps.setString(4, criminalAddress);
			ps.setString(5, criminalIdentificationMark);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Criminal added successfully.";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CriminalException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Criminal> showCriminalDetails() throws CriminalException {

		List<Criminal> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM CRIMINAL ORDER BY CRIMINAL_ID");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("criminal_id");
				String n=rs.getString("criminal_name");
				int age=rs.getInt("criminal_age");
				String g=rs.getString("criminal_gender");
				String add=rs.getString("criminal_address");
				String im=rs.getString("criminal_identification_mark");
				
				Criminal criminal=new Criminal();
				criminal.setCriminalID(id);
				criminal.setCriminalName(n);
				criminal.setCriminalAge(age);
				criminal.setCriminalGender(g);
				criminal.setCriminalAddress(add);
				criminal.setCriminalIdentificationMark(im);
				
				list.add(criminal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CriminalException(e.getMessage());
		}
		
		
		return list;
	}

}

