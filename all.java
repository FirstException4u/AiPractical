import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.*;
/* 
100 110 

1101 1001 1111 0000 
0010 
1110  1010 1100 0010
0001 
1111
1111 




 */
 
public class Main{
   
public static long gcd(long a, long b) {
      return b == 0 ? a : gcd(b, a % b); }
 public static long lcm(long u, long v)
    {
        return (u / gcd(u, v)) * v;
    }
 static final int mod=1_000_000_007;
 public static boolean areAllBitsSet(long n)
    {
        // all bits are not set
        if (n == 0)
            return false;
     
        // loop till n becomes '0'
        while (n > 0)
        {
            // if the last bit is not set
            if ((n & 1) == 0)
                return false;
     
            // right shift 'n' by 1
            n = n >> 1;
        }
     
            // all bits are set
            return true;
    }
    public static int Call(int[][] a,int n,int[] b,int j){
        int ans=0;
        for(int i=0;i<n;i++){
            b[a[i][j]]++;
            if(b[a[i][j]]==n-1){
                return a[i][j];
            }  
        }
        return 0;
    }
     public static int binarySearch(long[] a, long x)
    {
        int l = 0, r = a.length- 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            // Check if x is present at mid
            if (a[m] == x)
                return m;
 
            // If x greater, ignore left half
            if (a[m]< x)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        // if we reach here, then element was
        // not present
        return -1;
    }
    public static long powerN(long number, long power) {
    long res = 1;
    long sq = number;
    while (power > 0) {
        if (power % 2 == 1) {
            res *= sq;
        }
        sq = sq * sq;
        power /= 2;
    }
    return res;
}
public static long powerOptimised(long a, long n)
{
 
    // Stores final answer
    long ans = 1;
 
    while (n > 0)
    {
        long last_bit = (n & 1);
 
        // Check if current LSB
        // is set
        if (last_bit > 0)
        {
            ans = ans * a;
        }
         
        a = a * a;
 
        // Right shift
        n = n >> 1;
    }
    return ans;
}
public static boolean isPrime(int n) {
    if(n <= 1) {
        return false;
    }
    for(int i = 2; i <= Math.sqrt(n); i++) {
        if(n % i == 0) {
            return false;
        }
    }
    return true;
}
 public static final int LIMIT = 1000001;
  public static final boolean[] isPrime = new boolean[LIMIT + 1];
public  static ArrayList<Integer> primes = new ArrayList<Integer>();
 public static void helper(){
        Arrays.fill( isPrime, true ); // first we assume all numbers are primes if not shown otherwise
        isPrime[ 0 ] = false; // zero is not prime - it'is not greater than 1
        isPrime[ 1 ] = false; // one is not prime - it'is not greater than 1
        isPrime[ 2 ] = true; // only one even prime
        primes.add( 2 );
        for ( int i = 4; i <= LIMIT; i += 2 ) {
            isPrime[ i ] = false;
        }
        for ( int p = 3; p <= LIMIT; p += 2 ) {
            if ( isPrime[ p ] ) {
                primes.add( p );
                for ( int m = 3; m * p < LIMIT; m += 2 ) {
                    isPrime[ m * p ] = false;
                }
            }
        }
    }
    static boolean isPowerOfTwo(int n)
    {
        if (n == 0)
            return false;

        return (int)(Math.ceil((Math.log(n) / Math.log(2))))
            == (int)(Math.floor(
                ((Math.log(n) / Math.log(2)))));
    }
    public static void nQueens(int row,ArrayList<char[][]> ans,char[][] a,int n ){
        if (row == n) { 
        char[][] temp = new char[n][n];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i].clone();
        }
        ans.add(temp);
        
        return;
    }
       for(int i=0;i<n;i++){
           if(a[row][i]=='.'){
               if(checkQueens(a,row,i,n)){
                   a[row][i]='Q';
                   nQueens(row+1,ans,a,n);
                   a[row][i]='.';
               }
           }
       }
    }
    public static boolean checkQueens(char[][] a,int i,int j,int n){
        //lower 
        for(int l=i+1;l<n;l++){
            if(a[l][j]=='Q'){
                return false;
            }
        }
        //upper 
         for(int l=i-1;l>=0;l--){
            if(a[l][j]=='Q'){
                return false;
            }
        }
        //right
         for(int l=j+1;l<n;l++){
            if(a[i][l]=='Q'){
                return false;
            }
        }
        //left
         for(int l=j-1;l>=0;l--){
            if(a[i][l]=='Q'){
                return false;
            }
        }
        //upper right
        for(int l=i-1,k=j+1;l>=0 && k<n ; l--,k++){
            if(a[l][k]=='Q'){
                return false;
            }
        }
        //upper left
        for(int l=i-1,k=j-1;l>=0 && k>=0 ; l--,k--){
            if(a[l][k]=='Q'){
                return false;
            }
        }
        //lower right
        for(int l=i+1,k=j+1;l<n && k<n ; l++,k++){
            if(a[l][k]=='Q'){
                return false;
            }
        } 
        //lower left
        for(int l=i+1,k=j-1;l<n && k>=0 ; l++,k--){
            if(a[l][k]=='Q'){
                return false;
            }
        } 
      return true;
    }
    
 public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		Scanner sc=new Scanner(System.in);
     int T=fs.nextInt();

		for (int tt=1; tt<=T; tt++) {
	    int  n=fs.nextInt();
	    ArrayList<char[][]> ans=new ArrayList<>();
	    char[][] a=new char[n][n];
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            a[i][j]='.';
	        }
	    }
	    nQueens(0,ans,a,n);
	    for(char[][] b:ans){
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                out.print(b[i][j]+" ");
	            }
	            out.println();
	        }
	        out.println("here !");
	    }
		}
		out.close();
		 
	}
public static long Ok(int n,int r){
    double sum=0;
     for(int i = 1; i <= r; i++){
            sum = sum * (n - r + i) / i;
        }
        return (long)sum;
}
	static int[] match(int[] a, int[] b) {
		int[] res=new int[a.length];
		for (int i=0; i<a.length; i++) res[i]=o(a[i], b[i]);
		return res;
	}
	static long toL(int[] a) {
		long ans=0;
		for (int i:a) ans=ans*3+i;
		return ans;
	}
	static int o(int a, int b) {
		if (a==b) return a;
		return a^b^3;
	}

	static final Random random=new Random();
	
	
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		
		Arrays.sort(a);
	} 
	}
	static long add(long a, long b) {
		return (a+b)%mod;
	}
	static long sub(long a, long b) {
		return ((a-b)%mod+mod)%mod;
	}
	static long mul(long a, long b) {
		return (a*b)%mod;
	}
	static long exp(long base, long exp) {
		if (exp==0) return 1;
		long half=exp(base, exp/2);
		if (exp%2==0) return mul(half, half);
		return mul(half, mul(half, base));
	}
	static long[] factorials=new long[2_000_001];
	static long[] invFactorials=new long[2_000_001];
	static void precompFacts() {
		factorials[0]=invFactorials[0]=1;
		for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
		invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
		for (int i=invFactorials.length-2; i>=0; i--)
			invFactorials[i]=mul(invFactorials[i+1], i+1);
	}
	
	static long nCk(int n, int k) {
		return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}

	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	} 

}