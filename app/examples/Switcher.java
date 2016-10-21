package examples;

public class Switcher {

	public static void main(String[] args) {
		int a = 50;
		int b = 100;
		switch(a & b){
			case 130 & 500:
				System.out.println("oi2");
			case 100 & 50:
				System.out.println("oi");
		}

	}

}
