import java.util.Vector;
//Heap as a wrapper around Vector class
public class OurHeap<T> {
	private class Node<T>{
		T data;
		int key;
		//default constructor set both to key to 0
		private Node()
		{
			data=null;
			key=0;
		}
		//constructor that accepts the data and key
		private Node(int k, T d)
		{
			data=d;
			key=k;
		}
		//accessors and setters.
		public T getData() {
			return data;
		}
		public int getKey() {
			return key;
		}
		public String toString(){
			String st = "(" + key + ", " + data + ")";
			return st;
		}
	}
	private Vector<Node> vec;
	public OurHeap() {
		vec = new Vector<Node>();
	}
	public void add(int k, T d){
		//create a node
		Node<T> n = new Node<T>(k,d);
		//if the vector is empty assign the node to the first element
		if(vec.size()==0)
		{
			vec.add(n);
		}
		//else indert the node at index size 
		else
		{
			vec.add(vec.size(), n);
			//heapify
			int index = vec.size()-1;
			while(index>0 && vec.elementAt(index).getKey()>vec.elementAt((index-1)/2).getKey())
			{
				//swap index with its parent (index-1)/2
				int tempKey = vec.elementAt(index).getKey();
				T tempData = (T) vec.elementAt(index).getData();
				vec.elementAt(index).key = vec.elementAt((index-1)/2).getKey();
				vec.elementAt(index).data = vec.elementAt((index-1)/2).getData();
				vec.elementAt((index-1)/2).key = tempKey;
				vec.elementAt((index-1)/2).data = tempData;
				index = (index-1)/2;
			}
		}
	}
	public void heapify(int index){
		if(2*index+1>= vec.size()){
			return;
		}
		if(2*index+2<vec.size()){
		//both left and right child exist
		//replace parent with maximum of the two
			int left= 2*index+1;
			int right= 2*index+2;
			if(vec.elementAt(left).key>vec.elementAt(right).key){
				if(vec.elementAt(index).key<vec.elementAt(left).key){
					int k =vec.elementAt(index).key;
					T d = (T) vec.elementAt(index).data;
					vec.elementAt(index).key = vec.elementAt(left).key;
					vec.elementAt(index).data = vec.elementAt(left).data;
					vec.elementAt(left).key =k;
					vec.elementAt(left).data = d;
					heapify(left);
				}else{ 
					return;
				}
			}else{//right is larger swap it with the index
				if(vec.elementAt(index).key<vec.elementAt(right).key){
					int k =vec.elementAt(index).key;
					T d = (T) vec.elementAt(index).data;
					vec.elementAt(index).key = vec.elementAt(right).key;
					vec.elementAt(index).data = vec.elementAt(right).data;
					vec.elementAt(right).key =k;
					vec.elementAt(right).data = d;
					heapify(right);
				}else{ 
					return;
				}
			}
		}else {
			int left = 2*index+1;
			if(vec.elementAt(index).key<vec.elementAt(left).key){
				int k =vec.elementAt(index).key;
				T d = (T) vec.elementAt(index).data;
				vec.elementAt(index).key = vec.elementAt(left).key;
				vec.elementAt(index).data = vec.elementAt(left).data;
				vec.elementAt(left).key =k;
				vec.elementAt(left).data = d;
				//no heapify again because this is your last child
				return;
			}else{ 
				return;
			}
		}
	}
	public T remove() {
		//if root is null return null
		 if(vec.isEmpty()){
			 return null;
		 }		
		//remember the T of the root  
		 T returner = (T)vec.elementAt(0).data;
		//copy the last node to the root.
		 vec.setElementAt(vec.elementAt(vec.size()-1), 0);
		//decrease the size
		vec.removeElementAt(vec.size()-1);
		//call reheapify method with index (0). 
		heapify(0);
		//return saved T
		return (T)returner;
	}
	public String toString(){
		String st = "[";
		int i=0;
		for(i=0; i<vec.size()-1;i++)
		{
			st = st + vec.elementAt(i).toString() + ",";	
		}
		st = st + vec.elementAt(i).toString() + "]";
		return st;
	}
}