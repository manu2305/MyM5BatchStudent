package Basic;

import java.util.Random;

public class GenerateRandomValue {
public static void main(String[] args) {
	Random r=new Random();
	int data = r.nextInt(1000);
	System.out.println(data);
}
}
