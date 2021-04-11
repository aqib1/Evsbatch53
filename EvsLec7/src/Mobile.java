
public abstract class Mobile extends Repair {

	public void screenRepair() {
		System.out.println("Screen repair - Default");
	}

	public void bodyRepair() {
		System.out.println("Body repair - Default");
	}

	public void urgentRepair(int cost) {
		System.out.println("Urgent repair with cost - [" + cost + "]");
	}
}
