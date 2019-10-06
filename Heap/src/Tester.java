
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OurHeap<String> H = new OurHeap<String>();
		H.add(10, "a");
		H.add(5, "b");
		H.add(9, "c");
		H.add(13, "d");
		H.add(4, "e");
		H.add(7, "f");
		H.add(16, "g");
		System.out.println(H.toString());
		System.out.println(H.remove());
		System.out.println(H.toString());
	}

}