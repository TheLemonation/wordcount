package wordcount;
import java.util.*;

public class emplye {
private String firstname;
private String lastname;
private int age;
private double montlysalary;
private String dob;
public emplye(String fName, String lName, double sal,int age,double yearlysal) {
	 if (fName != null) firstname =fName;
	 if (lName != null) lastname = lName;
	 if (sal > 0.0) {
	 montlysalary=sal;
	 }
	 else {
	 montlysalary=0.0;
	 }
	 }
public double getyearlysalary(double yearlysalary){
	yearlysalary=12*montlysalary;
	return yearlysalary;
}
public String getFirstName(){
	return firstname;
}
public String getLastName(){
	return lastname;
}
public int getAGE(){
	return age;
}
public double getSalary(){
	return montlysalary;
}
public String getDateofbirth(){
	return dob;
}
public void setFirstName(String fName){
	 if (fName != null)
	 firstname = fName;
	 }
public void setLastName(String lName){
	 if (lName != null)
	 lastname = lName;
	 }
public void setAGE(int Age){
	Age=age;
	 }
public void setSalary(double sal){
	 if (sal > 0.0){
	 montlysalary = sal;
	 }
	 else {
	 montlysalary = 0.0;
	 }
	 }
public void setDob(String Dateofbirth){
	Dateofbirth=dob;
}
public void setYearlysalary(double Yearlysalary){
	Yearlysalary=getyearlysalary(0);
}
}
