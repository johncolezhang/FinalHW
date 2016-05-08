import java.io.File;
import java.util.ArrayList;
import java.util.List;
/*
 * 该类为主函数
 * root用来记录文件的root路径
 * list用来存所有的文件名
 * nodes用来存postinglist
 * files用来存所有的文件名
 * content用来存读取文件后返回的文件信息
 * term用来存拆分好的单词
*/

public class Main {
	public static List<Node> nodes = new ArrayList<Node>();//记录所有单词结点
	public static String []word;//记录要搜索的单词
	
	public static void main(String args[]){ 
		word = InputWords.inputWords();
		function();
		SearchWords.searchWords(word, nodes);
	}
	
	public static void function(){
		File root = new File("D://FinalHW");
		List<String> list = new ArrayList<String>();//记录文件名
		ShowAllFile.showAllFiles(root, list);//遍历所有文件并且将文件放入list中
		String []files = new String[list.size()];
		for(int i =0;i<list.size();i++){
			files[i] = list.get(i);//表示文本名
			String content = FileReader.readTextFile(files[i]);//表示文本中的内容
			String file = files[i].substring(11, files[i].length()-4);	//11为前缀的长度	，4为.txt的长度	
			content=content+" "+file; 
			String []term = SplitString.spiltString(content);
			for(int j =0;j<term.length;j++){
				term[j] = Stemmer.stemmer(term[j]);
			}
			PostingList.postingList(nodes, term, files[i]);
		}
		//display();
	}
	public static void display(){
		System.out.println("->WORD->ID->FREQ->ARTICLE->......");
		System.out.println("---------------------------------");
		for(int i = 0;i<nodes.size();i++){
			nodes.get(i).showNode();
		}
	}
}
