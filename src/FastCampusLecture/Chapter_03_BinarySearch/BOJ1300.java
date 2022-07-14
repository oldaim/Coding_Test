package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1300 {
    static FastReader reader = new FastReader();
    static int N = 0 , K = 0;

    // 1 2 3 4
    // 2 4 6 8       // 1 2 2 4
    // 3 6 9 12      // 1 2 2 3 3 4 6 6 9
   //  4 8 12 16     // 1 2 2 3 3 4 4 4 6 6 8 8 9 12 12 16
    static void input(){
        N = reader.nextInt();
        K = reader.nextInt();

    }

    static int numOfDivisor(int N){
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(N % i==0) cnt++;
        }
        return cnt;
    }

    static int numOfSpecial(int X){
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(X % i == 0) cnt++;
        }
        return cnt;
    }

    static boolean findIndex(long mid){

        long sum = 0;

        for (int i = 1; i <= mid; i++) {
            if(i <= N) sum += numOfDivisor(i);
            else {
               if(numOfSpecial(i) == 2) sum += 1;
               else if (numOfSpecial(i) > 2) sum += 2;
            }


        }

        return K > sum;
    }

    static void binarySearch(){
        long L = 1 , R = (long) N * N , answer = 0;
        while (L <= R){
            long mid = (L + R) / 2;
            if(findIndex(mid)){
                L = mid + 1;
            }
            else{
                R = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args){
        input();
        binarySearch();
    }

    static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File(s)));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
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

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    }


}
