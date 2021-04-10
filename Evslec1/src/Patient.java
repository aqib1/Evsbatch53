
/*
 * access modifier are those which help us to access a field from a class
 * 
 * public 
 * protected
 * default (no modifier)
 * private 
 * 
 * **/

public class Patient {
//	public static int CNIC = 8788888;
	private int id = 1546362;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
