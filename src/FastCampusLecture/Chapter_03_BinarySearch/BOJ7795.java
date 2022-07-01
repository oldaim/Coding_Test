package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.*;

public class BOJ7795 {


    static int T = 0 , N = 0 , M = 0;
    static StringBuilder sb = new StringBuilder();
    static int[] A, B;
    static FastReader reader = new FastReader();

    static void input(){

        N = Integer.parseInt(reader.next());
        M = Integer.parseInt(reader.next());
        A = new int[N];
        B = new int[M];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(reader.next());
        }

        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(reader.next());
        }

        Arrays.sort(A);
        Arrays.sort(B);

    }

    static int binarySearch(int[] array, int L , int R, int key){
        // lower bound : K 값 이상이 처음 발견되는 위치
        // upper bound : K 값을 초과하는 값이 처음 발견되는 위치
        // 해당 문제에서는 K 값 초과가 맞는듯
        int res = -1;
        while(L <= R){
            int mid = (L + R)/2;
            if(key > array[mid]){
                L = mid + 1;
                res = mid;
            }
            else {
                R = mid - 1;
            }
        }

        return res;

    }

    static void print(){

        int total = 0;

        for (int i = 0; i < N; i++) {
            int result = binarySearch(B,0, M - 1 , A[i]) + 1;
            total += result;
        }

        sb.append(total).append('\n');
    }

    public static void main(String[] args) {

        T = reader.nextInt();


        for (int i = 0; i < T; i++) {
            input();
            print();

        }

        System.out.println(sb);



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
