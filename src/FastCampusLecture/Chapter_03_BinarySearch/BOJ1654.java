package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1654 {
    static FastReader reader = new FastReader();
    static int N = 0 , cutNum = 0;
    static int[] lenArray;

    static void input(){
        N = Integer.parseInt(reader.next());
        cutNum = Integer.parseInt(reader.next());
        lenArray = new int[N];

        for (int i = 0; i < N; i++) {
            lenArray[i] = reader.nextInt();
        }
    }

    static boolean determination(long m){
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += (lenArray[i] / m);
        }
        return cutNum <= total;
    }

    static long binarySearch(){
        long L = 1 , R = Integer.MAX_VALUE, answer = 0;
        while (L<=R){
            long mid = (L + R) / 2;
            if(determination(mid)){
                L = mid + 1;
                answer = mid;
            }
            else{
                R = mid -1;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        input();
        System.out.println(binarySearch());
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
