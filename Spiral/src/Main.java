
public class Main {

	public static void main(String[] args) {
		int argInt = 0;
		try {
			String argStr = args[0];
			argInt = Integer.parseInt(argStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Spiral mySpiral = new Spiral(argInt);
		mySpiral.printShape();
	}

}
