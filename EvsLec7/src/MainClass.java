
public class MainClass {
public static void main(String[] args) {
	Mobile android = new Android();
	Mobile apple = new Apple();
	
	RepairHelper helper = new RepairHelper();
	helper.repair(android);
	helper.repair(apple);
}
}
