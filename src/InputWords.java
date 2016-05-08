import java.util.Scanner;


public class InputWords {
	public static String[] inputWords(){
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		String a[] = SplitString.spiltString(str);
		return a;
	}
}
