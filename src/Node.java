
/*
 * 该类为node数据结构
 * node有三个属性 node型next，整形num以及字符型word
 * node的基本样式为:字符型(记录单词)-> 整形(记录id)->整形(记录频率)->字符型(记录文件名)->......
 * 接下去的都为字符型，记录单词存在于哪个文件的文件名
*/
public class Node {
	Node next = null;
	int num;//频率
	String word;//单词
	
	public Node(String d){
		word = d;
	}
	public Node(int d){
		num = d;
	}
	
	void appendNum(int d)//增加表示频率的结点
	{
		Node end =new Node(d);
		Node n = this;
		while(n.next!=null){
			n=n.next;
		}
		n.next=end;
	}
	
	void appendWord(String d)//增加表示文章的结点
	{
		Node end =new Node(d);
		Node n = this;
		while(n.next!=null){
			n=n.next;
		}
		n.next=end;
	}
	
	void modifyFreq(int n){//freq放在第三个结点
		Node node =this;
		if(node.next.next!=null){
			node = node.next.next;
		}
		node.num = n;
	}
	
	int getFreq(){
		Node node =this;
		if(node.next.next!=null){
			node = node.next.next;
		}
		return node.num; 
	}
	
	void showNode(){
		Node node =this;
		while(node!=null){
			System.out.print("->");
			if(node.word!=null){
				System.out.print(node.word);
			}else{
				System.out.print(node.num);
			}
			node = node.next;
		}
		System.out.println();
	}
}
