import java.io.IOException;
import java.util.Scanner;

public class Triangle {
	public int getN() throws IOException {
		System.out.println("Enter n");
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	private static Long getFactorial(Integer k) {
		Long factorial = 1L;
		for (int i = 2; i <= k; ++i) {
			factorial = i * factorial;
		}
		return factorial;
	}
	
	private static Long C(int n, int k) {
		return getFactorial(n) / (getFactorial(k) * getFactorial(n - k));
	}
	
	public void printTriangle(int n) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= i; ++j) {
				sb.append(C(i,j) + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		Triangle triangle = new Triangle();
		
		int n = triangle.getN();
		triangle.printTriangle(n);
	}
}
