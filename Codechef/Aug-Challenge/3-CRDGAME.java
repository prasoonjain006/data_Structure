package codeChef;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.*;
import java.math.*;
import java.text.*;

public class CRDGAME3 {

	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = i();
		while (t > 0) {
			int a=i();
			int b=i();
			int x=(a-1)/9+1;
			int y=(b-1)/9+1;
			if(x>=y) {
				System.out.println("1 "+y);
			}
			else {
				System.out.println("0 "+x);
			}

			t--;
		}

		//		long l=l();
		//		String s=s();     //	ONLY BEFORE SPACE IN STRING , ELSE USE BUFFER-READER

	}

	public static long pow(long a, long b) {
		long m = 1000000007;
		long result = 1;
		while (b > 0) {
			if (b % 2 != 0) {
				result = (result * a) % m;
				b--;
			}
			a = (a * a) % m;
			b /= 2;
		}
		return result % m;
	}

	public static long gcd(long a, long b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}

	public static long lcm(long a, long b) {
		return a * (b / gcd(a, b));
	}

	public static long l() {
		String s = in.String();
		return Long.parseLong(s);
	}

	public static void pln(String value) {
		System.out.println(value);
	}

	public static int i() {
		return in.Int();
	}

	public static String s() {
		return in.String();
	}

}

class pair {
	int x, y;

	pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class CompareValue {

	static void compare(pair arr[], int n) {
		Arrays.sort(arr, new Comparator<pair>() {
			public int compare(pair p1, pair p2) {
				return p1.y - p2.y;
			}
		});
	}
}

class CompareKey {
	static void compare(pair arr[], int n) {
		Arrays.sort(arr, new Comparator<pair>() {
			public int compare(pair p1, pair p2) {
				return p2.x - p1.x;
			}
		});
	}
}

class InputReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int Int() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String String() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public String next() {
		return String();
	}

	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}

	public double readDouble() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		double res = 0;
		while (!isSpaceChar(c) && c != '.') {
			if (c == 'e' || c == 'E') {
				return res * Math.pow(10, Int());
			}
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res *= 10;
			res += c - '0';
			c = read();
		}
		if (c == '.') {
			c = read();
			double m = 1;
			while (!isSpaceChar(c)) {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, Int());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				m /= 10;
				res += (c - '0') * m;
				c = read();
			}
		}
		return res * sgn;
	}
}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0) {
				writer.print(' ');
			}
			writer.print(objects[i]);
		}
		writer.flush();
	}

	public void printLine(Object... objects) {
		print(objects);
		writer.println();
		writer.flush();
	}

	public void close() {
		writer.close();
	}

	public void flush() {
		writer.flush();
	}
}

class IOUtils {
	public static int[] readIntArray(InputReader in, int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = in.Int();
		return array;
	}
}

/**
 * TO SORT VIA TWO KEYS , HERE IT IS ACCORDING TO ASCENDING ORDER OF FIRST AND
 * DESC ORDER OF SECOND
 * LIST name-list 
 * ARRAYLIST
 * COPY PASTE
 * 
 * Collections.sort(list, (first,second) ->{
		    	if(first.con >second.con)
		    		return -1;
		    	else if(first.con<second.con)
		    		return 1;
		    	else {
		    		if(first.index >second.index)
		    			return 1;
		    		else
		    			return -1;
		    	}
		    	
		    });
 * 
 */

/**
 * 
 

  DECIMAL FORMATTER
Double k = in.readDouble();

System.out.println(k);
DecimalFormat df = new DecimalFormat("#.##");
System.out.print(df.format(k));
out.printLine(k);
* 
* */