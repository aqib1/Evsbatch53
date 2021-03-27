
/**
 * 1- public -> accessible 2- protected -> within package accessible, outside
 * package only child class can access 3- default -> within package only 4-
 * private -> only within class
 * 
 * 
 * a person id can not be -ve
 */

public class Person {
	private int id;
	private String name;
	private String cnic;
	private String email;
	private String jobDescription;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id < 0)
			System.err.println("Please enter positive id");
		else
			this.id = id;
	}

	public void setCnic(String cnic) {
		this.cnic = cnic;
	}

	public String getCnic() {
		return cnic;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID : ").append(id).append("\n").append("NAME : ").append(name).append("\n").append("CNIC : ")
				.append(cnic).append("\n").append("EMAIL : ").append(email).append("\n").append("JOB DESCRIPTION : ")
				.append(jobDescription);
		return sb.toString();
	}

}
