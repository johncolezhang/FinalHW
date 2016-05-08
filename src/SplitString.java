import java.io.File;
import java.util.ArrayList;
import java.util.List;
/*
 *该类的作用为将传入的串进行削减，
 *将.,()/等符号删去  
 */

public class SplitString {
	public static String[] spiltString(String str){
		str = str.replaceAll("[.]" , "");
		str = str.replaceAll("[,]" , "");
		str = str.replaceAll("\"" , "");
		str = str.replaceAll("[(]" , "");
		str = str.replaceAll("[)]" , "");
		String []ss = str.split(" ");
		return ss;
	}
	
}
