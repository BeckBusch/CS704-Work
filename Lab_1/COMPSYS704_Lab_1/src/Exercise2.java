public class Exercise2 {
	public static void main(String[] args) {
		Fibonacci list1 = new Fibonacci(10);
		Fibonacci list2 = new Fibonacci(20);
		list1.printList();
		list2.printList();
	}
	static class Fibonacci {
		private int n;
		public Fibonacci(int n) {
			this.n = n;
		}
		public void printList() {
			int numb;
			int a = 1;
			int b = 1;
			
			System.out.println("1\n1");
			
			for (int i=2; i<n; i++) {
				numb = a+b;
				a = b;
				b = numb;
				System.out.println(Integer.toString(numb));
			}
		}
	}
}
