import java.awt.List;
import java.io.IOException;
import java.math.BigInteger;
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
	
	private static Long getMultiplicationAtoB(Integer a, Integer b) {
		Long result = 1L;
		for (int i = a; i <= b; i++) {
			result = i * result;
		}
		return result;
	}
	
	public void fix1_SoutToSBuilder(int _n) {
		StringBuilder sb = new StringBuilder();
		
		for (int n = 0; n <= _n; ++n) {
			for (int k = 0; k <= n; ++k) {
				sb.append(C(n,k) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static Long C(int n, int k) {
		return getFactorial(n) / (getFactorial(k) * getFactorial(n - k));
	}
	
	public void fix2_FactorialToPartMult(int _n) {
		StringBuilder triangle = new StringBuilder();
		
		for (int n = 0; n <= _n; n++) {
			for (int k = 0; k <= n; k++) {
				triangle.append(C_update(n, k) + " ");
			}
			triangle.append("\n");
		}
		System.out.println(triangle);
	}
	
	private static Long C_update(int n, int k) {
		Integer max = Integer.max(k, n-k);
		Integer min = Integer.min(k, n-k);
		return getMultiplicationAtoB(max + 1, n) / (getFactorial(min));
	}
	
	public void fix3_LongToBigInteger(int _n) {
		StringBuilder triangle = new StringBuilder();
		
		for (int n = 0; n <= _n; n++) {
			for (int k = 0; k <= n; k++) {
				triangle.append(C_update_BigInt(n, k) + " ");
			}
			triangle.append("\n");
		}
		System.out.println(triangle);
	}
	
	private static BigInteger C_update_BigInt(int n, int k) {
		Integer max = Integer.max(k, n-k);
		Integer min = Integer.min(k, n-k);
		return getMultiplicationAtoB_BigInt(max + 1, n).divide((getFactorial_BigInt(min)));
	}
	
	private static BigInteger getMultiplicationAtoB_BigInt(Integer a, Integer b) {
		BigInteger result = BigInteger.ONE;;
		for (int i = a; i <= b; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
	
	private static BigInteger getFactorial_BigInt(Integer k) {
		BigInteger factorial = BigInteger.ONE;
		for (int i = 2; i <= k; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}
	
	public void fix4_CalculatingToLists(int _n) {
//		StringBuilder triangle = new StringBuilder();
//		List previous = new List();
//		previous.add("1");
//		
//		for (int n = 1; n <= _n; n++) {
//			
//			for (int k = 0; k <= n; k++) {
//				triangle.append(C_update_BigInt(n, k) + " ");
//			}
//			triangle.append("\n");
//		}
//		System.out.println(triangle);
	}
	
	public static void main(String[] args) throws IOException {
		double startMemoryCounter = Runtime.getRuntime().totalMemory();
		double finishMemoryCounter;
		long beginTimer_1;
		long beginTimer_2;
		long beginTimer_3;
		long beginTimer_4;
		long endTimer_1;
		long endTimer_2;
		long endTimer_3;
		long endTimer_4;
		
		Triangle triangle = new Triangle();
		int n = triangle.getN();
		
		beginTimer_1 = System.nanoTime();	
			triangle.fix1_SoutToSBuilder(n);
		endTimer_1 = System.nanoTime();
		
		beginTimer_2 = System.nanoTime();	
			triangle.fix2_FactorialToPartMult(n);
		endTimer_2 = System.nanoTime();
		
		beginTimer_3 = System.nanoTime();	
			triangle.fix3_LongToBigInteger(n);
		endTimer_3 = System.nanoTime();
		
		beginTimer_4 = System.nanoTime();	
			triangle.fix4_CalculatingToLists(n);
		endTimer_4 = System.nanoTime();
		
		finishMemoryCounter = Runtime.getRuntime().totalMemory();
		System.out.println("time_1: " + (endTimer_1 - beginTimer_1)*1e-9);
		System.out.println("time_2: " + (endTimer_2 - beginTimer_2)*1e-9);
		System.out.println("time_3: " + (endTimer_3 - beginTimer_3)*1e-9);
		System.out.println("time_4: " + (endTimer_4 - beginTimer_4)*1e-9);
		
		System.out.println("memory: " + (finishMemoryCounter - startMemoryCounter));
	}
}
