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
		for (int i = 2; i <= k; i++) {
			factorial = i * factorial;
		}
		return factorial;
	}
	
	private static Long getMuntiplication(Integer a, Integer b) {
		Long result = 1L;
		for (int i = a; i <= b; i++) {
			result = i * result;
		}
		return result;
	}
	
	private static Long C(int n, int k) {
		Integer max = Integer.max(k, n-k);
		Integer min = Integer.min(k, n-k);
		return getMuntiplication(max + 1, n) / (getFactorial(min));
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
		double startMemoryCounter = Runtime.getRuntime().totalMemory();
		double finishMemoryCounter;
		long beginTimer;
		long endTimer;
		
		beginTimer = System.nanoTime();
		
		Triangle triangle = new Triangle();
		
		int n = triangle.getN();
		triangle.printTriangle(n);
		
		endTimer = System.nanoTime();
		finishMemoryCounter = Runtime.getRuntime().totalMemory();
		System.out.println("time: " + (endTimer - beginTimer)*1e-9);
		System.out.println("memory: " + (finishMemoryCounter - startMemoryCounter));
	}
}
