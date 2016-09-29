package com.demo.ServletPractise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

 public class OwnerDAO1 {
	Connection con = null;

	public  void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3305/petclinic", "root", "root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	public OwnerDTO findOwnerByID(int id) {
		OwnerDTO o = new OwnerDTO();
		o.setId(id);
		
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from owners where id=" + id);
			rs.next();

			o.setFname(rs.getString(2));
			o.setLname(rs.getString(3));
			o.setAddress(rs.getString(4));
			o.setCity(rs.getString(5));
			o.setTelephone(rs.getLong(6));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	public OwnerDTO findOwnerByName(String name) {
	OwnerDTO o=new OwnerDTO();
	
			try {
				connect();
				String sql = "Select * from owners where first_name=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs=ps.executeQuery();
				//System.out.println("in while");
				while(rs.next()){
				o.setId(rs.getInt(1));
				o.setFname(rs.getString(2));
				o.setLname(rs.getString(3));
				o.setAddress(rs.getString(4));
				o.setCity(rs.getString(5));
				o.setTelephone(rs.getLong(6));
				//System.out.println(o.getId());
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		return o;
	}
	public ArrayList displayOwnerNames()
	{
		ArrayList<String > al=new ArrayList<String>();
		try
		{
		connect();
		Statement st=  con.createStatement();
		 ResultSet rs=st.executeQuery("select first_name from owners");
		 while(rs.next())
		 {
			String name=rs.getString(1);
			al.add(name);
		 }
			return al;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return al ;
	}
	}
	

