package com.demo.ServletPractise;

import java.sql.*;

public class Owners {
	public static void main(String args[]) {
		OwnerDAO1 dao = new OwnerDAO1();
		dao.connect();
		OwnerDTO o = dao.findOwnerByID(2);
		// System.out.println(o1.getFname());
		System.out.println(o.getId() + "\t" + o.getFname() + "\t" + o.getFname() + "\t" + o.getAddress() + "\t"
				+ o.getCity() + "\t" + o.getTelephone());
		OwnerDTO o1=dao.findOwnerByName("Betty");
		System.out.println(o1.getId()+"\t"+o1.getFname()+"\t"+o1.getLname()+"\t"+o1.getAddress()+"\t"+o1.getCity()+"\t"+o1.getTelephone());
	}
}


