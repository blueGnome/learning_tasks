import java.io.IOException;
import java.util.Scanner;

public class Triangle {
	private Integer n = 0;
	
	public void getN() throws IOException {
		System.out.println("Enter n");
		Scanner in = new Scanner(System.in);
		this.n = in.nextInt();
	}
	
	private Long getFactorial(Integer k) {
		Long factorial = 1l;
		for (int i = 2; i <= k; ++i) {
			factorial = i * factorial;
		}
		return factorial;
	}
	
	private Long C(int n, int k) {
		return getFactorial(n) / (getFactorial(k) * getFactorial(n - k));
	}
	
	public void printTriangle() {
		for (int i = 0; i < this.n; ++i) {
			for (int j = 0; j <= i; ++j) {
				System.out.print(C(i,j) + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Triangle triangle = new Triangle();
		
		triangle.getN();
		triangle.printTriangle();
		
	}
}
