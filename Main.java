import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*

- rearrange p = [p[1], p[2], ..., p[n]] so that adjacent elements have:
2 <= abs(p[i] - p[i+1]) <= 4, where 1 <= i < n

------------------------

17

1 3 5 7 9 11 13 15 17 16 14 12 10 8 6 4 2
1 3 5 7 9 11 13 15 17 14 16 12 10 8 6 4 2

for odd:
- swap(p[n/2+1], p[n/2+2])
- except for n = 3

------------------------

16

1 3 5 7 9 11 13 15 16 14 12 10 8 6 4 2
1 3 5 7 9 11 15 13 16 14 12 10 8 6 4 2

for even:
- swap(p[n/2], p[n/2-1])
- except for n = 2

------------------------

 */

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			if (n <= 3) {
				System.out.println(-1);
				continue;
			}
			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 1; i <= n; i += 2) {
				arr.add(i);
			}
			for (int i = (n % 2 == 1 ? n - 1 : n); i > 1; i -= 2) {
				arr.add(i);
			}
			int[] ans = new int[n];
			for (int i = 0; i < n; i++) {
				ans[i] = arr.get(i);
			}
			if (n % 2 == 1) {
				int temp = ans[n/2+1];
				ans[n/2+1] = ans[n/2+2];
				ans[n/2+2] = temp;
			} else {
				int temp = ans[n/2-1];
				ans[n/2-1] = ans[n/2-2];
				ans[n/2-2] = temp;
			}
			for (int x : ans) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
