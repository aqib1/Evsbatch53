
public class Student extends Person {
	private String subjects;
	private String contactNumber;
	private double fee;
	private String dob;
	private String cnic;
	
	public Student() {
		
	}
	
	public Student(double fee) {
		this(null, fee);
	}	
	
	public Student(String subject, double fee) {
		this.subjects = subject;
		this.fee = fee;
	}
	
	
	@Override
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	
	@Override
	public String getCnic() {
		return "Student - " + cnic;
	}
	
	public String getSubjects() {
		return subjects;
	}
	
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public double getFee() {
		return fee;
	}
	
	public void setFee(double fee) {
		this.fee = fee;
	}
	//double, int, string
	
	public void setFee(int fee) {
		this.fee = (double)fee;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//		return super.equals(obj);
//	}
//	
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return super.hashCode();
//	}
	
}
