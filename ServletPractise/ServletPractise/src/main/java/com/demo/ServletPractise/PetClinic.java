package com.demo.ServletPractise;

import java.sql.*;

public class PetClinic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VetDAO dao = new VetDAO();
		dao.connect();
		VetDTO v1 = dao.getVet(1);
		System.out.println(v1.getFname() + " " + v1.getLname());
		//VetDTO v2 = new VetDTO();
		v1.setId(7);
		v1.setFname("pavan");
		v1.setLname("karampudi");
		dao.addVet(v1);
	}

}

class VetDAO {
	Connection con = null;

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3305/petclinic", "root", "root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	public VetDTO getVet(int id) {
		VetDTO v = new VetDTO();
		v.setId(id);
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select first_name,last_name from vets where id=" + id);
			rs.next();
			String fname = rs.getString(1);
			String lname = rs.getString(2);

			v.setFname(fname);
			v.setLname(lname);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return v;

	}

	public void addVet(VetDTO v) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into vets values(?,?,?)");
			ps.setInt(1, v.getId());
			ps.setString(2, v.getFname());
			ps.setString(3, v.getLname());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class VetDTO {
	private int id;
	private String fname;
	private String lname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}