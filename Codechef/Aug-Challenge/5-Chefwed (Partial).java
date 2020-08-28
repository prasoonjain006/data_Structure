package codeChef;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.*;
import java.math.*;
import java.text.*;

public class Chefwed2 {

	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = i();
		while (t > 0) {

			int n=i();
			int k=i();
			int arr[]=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=i();
			}
			if(k==1) {
				
			
			Set<Integer> set = new HashSet<>();
			int c=0;
//			set.add(arr[0]);
				for(int i=0;i<n-1;i++) {
					set.add(arr[i]);
					if(set.contains(arr[i+1])) {
						c++;
						set.clear();
					}
					else {
						continue;
					}
				}
				System.out.println(c+1);
			}
			else {
				
			
//			int count[]=new int[101];
//				Set<Integer> set =new HashSet<>();
//				int con=0;
//				
//				for(int i=0;i<n-1;i++) {
//					int m=arr[i];
//					set.add(m);
//					if(set.contains(arr[i+1])) {
//						c++;
//					}
//				}
//				System.out.println(c+k);
				
				
				int f=0;
				int h=0;
				int table=1;
				Set<Integer> set = new HashSet<>();
				int pp=0;
				int temp=0;
				Map<Integer,Integer> map=new HashMap<>();
				Map<Integer,Integer> map1=new HashMap<>();
				Map<Integer,Integer> map2=new HashMap<>();
				Queue<Integer> ll = new LinkedList<>();
				int sum=0;
				for(int i=0;i<n-1;i++) {
					pp=0;
					if(map.containsKey(arr[i])) {
						map.put(arr[i], map.get(arr[i])+1);
					}
					else {
						map.put(arr[i], 1);
					}
					
					if(map.get(arr[i])==2) {
						sum=sum+2;
					}
					else if(map.get(arr[i])>2) {
						sum=sum+1;
					}
//					System.out.println("sum  "+sum);
					
					f=sum;
					h=f;
					temp=i;
//					System.out.println(sum+" tttt "+h+" "+f+" "+map);
					
//					if(i==4)
//						System.out.println(map);
					if(map.containsKey(arr[i+1])) {
						map1.putAll(map);
						for(int j=i+1;j<n;j++) {
//							System.out.println(i);
							
//							System.out.println("map1111    "+map1);
							if(map1.containsKey(arr[j])) {
								map1.put(arr[j], map1.get(arr[j])+1);
							}
							else {
								map1.put(arr[j], 1);
							}
							if(map1.get(arr[j])==2) {
								f=f+2;
							}
							else if(map1.get(arr[j])>2) {
								f=f+1;
							}
//							System.out.println(map1+" map1 f map  "+f+map);
							
							
							if(map2.containsKey(arr[j])) {
								map2.put(arr[j], map2.get(arr[j])+1);
							}
							else {
								map2.put(arr[j], 1);
							}
							if(map2.get(arr[j])==2) {
								h=h+2;
							}
							else if(map2.get(arr[j])>2) {
								h=h+1;
							}
//							System.out.println(temp+"   i h f  "+h+" "+f);
//							if(i==4) {
//								System.out.println(" "+f+" "+h+" "+map1+" "+map2);
//								System.out.println("j---  "+j+"       "+temp);
//							}
//							System.out.println("");
						
							if(k<(f-h)) {
								table++;
								map.clear();
								ll.add(i);
								
								f=0;
								h=0;
								break;
								
							}
//							else {
//								pp=1;
////								continue;
//							}
						}
//						
						map1.clear();
						map2.clear();
						
					}
				}
				Deque<Integer> dq= new LinkedList<>();
				
				dq.addAll(ll);
				
				
				
				
				int t1=0;
				int t2=0;
				int st=0;
				int en=0;
				int f1=0;
				int f2=0;
				int i1=0;
				int i2=0;
				int len=dq.size();
				int dif=0;
				int c[][]=new int[len+1][102];
				int min=1000000;
				
				
				for(int i=0;i<len+1;i++) {
					if(!dq.isEmpty())
						en=dq.poll()+1;
					else
						en=n;
					for(int j=st;j<en;j++) {
						c[i][arr[j]]++;
						}
					st=en;
				}
				
//				System.out.println(ll);
//				
//				
//				for(int i=0;i<len+1;i++) {
//					for(int j=0;j<101;j++) {
//						if(j<10)
//						System.out.print(c[i][j]+" ");
//					}
//					System.out.println("");
//				}
				
				Deque<Integer> dq1= new LinkedList<>();
				dq1.addAll(ll);
				
				int ansf=0;
				
				st=0;
				int kin=0;
				i1=0;
				i2=0;
				en=0;
				for(int i=0;i<(len+1);i++) {
					if(!dq1.isEmpty())
						en=dq1.poll()+1;
					else
						en=n;
					for(int j=st;j<en;j++) {
						if(i>0) {
							i1=c[i-1][arr[j]];
							i2=c[i][arr[j]];
//							c[i][j]--;
//							c[i-1][j]++;
//							f1=c[i-1][j];
//							f2=c[i][j];
//							System.out.println(i1+" h  "+i2);
//							if(i2==1 && i1==0) {
//								continue;
//							}
							if(i2==1  && i1==1) {
								dif=dif+2;
//								System.out.println(i+" "+arr[j]);
							}
							else if(i2==1 && i1>=2) {
								dif=dif+1;
							}
							else if(i2==2 && i1==0) {
								dif=dif-2;
							}
//							else if(i2==2 && i1==1) {
//								continue;
//							}
							else if(i2==2 && i1==2) {
								dif=dif-1;
							}
							else if(i2==2 && i1>2) {
								dif=dif-1;
							}
							else if(i2>2 && i1==0) {
								dif=dif-1;
							}
							else if(i2>2 && i1==1) {
								dif=dif+1;
							}
//							else if(i2>2 && i1>=2) {
//								continue;
//							}
//							System.out.println(dif);
							c[i-1][arr[j]]++;
						}
						if(dif<=min) {
							min=dif;
							kin=j;
						}
						
					}
					if(min<0) {
						ansf=ansf+min;
						for(int cf=st;cf<=Math.min(kin,n-1);cf++) {
							c[i][arr[cf]]--;
//							c[i-1][arr[cf]]++;
						}
						
					}
					min=0;
					dif=0;
					st=en;
				}
				
				
//				System.out.println(min+"  "+ansf);
//				for(int i=0;i<len+1;i++) {
//					for(int j=0;j<101;j++) {
//						if(j<6)
//						System.out.print(c[i][j]+" ");
//					}
//					System.out.println("");
//				}
				
				Map<Integer,Integer> map11 = new HashMap<>();
				Map<Integer,Integer> mapf22 = new HashMap<>();
				int anss=0;
				
				for(int hi=0;hi<n;hi++) {
					
					
					if(map11.containsKey(arr[hi])) {
						map11.put(arr[hi], map11.get(arr[hi])+1);
					}
					else {
						map11.put(arr[hi], 1);
					}
					
					if(map11.get(arr[hi])==2) {
						anss=anss+2;
					}
					else if(map11.get(arr[hi])>2) {
						anss=anss+1;
					}
				}
//				System.out.println("   hhhh       "+anss);
				anss=anss+k;
				
				
				
				
				Map<Integer,Integer> mapf = new HashMap<>();
//				System.out.println(table+" "+ll);
				int cl=0;
				for(int hi=0;hi<n;hi++) {
					
					
					if(mapf.containsKey(arr[hi])) {
						mapf.put(arr[hi], mapf.get(arr[hi])+1);
					}
					else {
						mapf.put(arr[hi], 1);
					}
					
					if(mapf.get(arr[hi])==2) {
						cl=cl+2;
					}
					else if(mapf.get(arr[hi])>2) {
						cl=cl+1;
					}
//					System.out.println("loop cl  "+hi+"  "+cl);
				
//					System.out.println(cl+" "+hi);
					if(!ll.isEmpty()) {
					int tmp=ll.peek();
						if(hi==tmp) {
							ll.poll();
							mapf.clear();
						}
					}
					
					
				}
				
				if(ansf<0) {
					cl=cl+ansf;
				}
				
//				System.out.println("cl  "+cl);
				System.out.println(Math.min(table*k +cl,anss));
//				System.out.println(set);
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