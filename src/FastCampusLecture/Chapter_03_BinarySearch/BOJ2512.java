package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2512 {
    static FastReader reader = new FastReader();
    static int N = 0, budget = 0;
    static int[] budgetArray;

    static void input(){
        N = reader.nextInt();
        budgetArray = new int[N];
        for (int i = 0; i < N; i++) {
            budgetArray[i] = Integer.parseInt(reader.next());
        }

        budget = reader.nextInt();

    }

    static boolean determination(int m){
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += Math.min(budgetArray[i], m);
        }
        return budget >= total;
    }

    static boolean determineTotal(){
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += budgetArray[i];
        }

        return budget >= total;
    }

    static int binarySearch(){
        int L = 1 , R = 100000, answer =0;

        while (L <= R){
            int mid = (L + R) / 2;
            if(determination(mid)){
                L = mid + 1;
                answer = mid;
            }
            else {
                R = mid - 1;
            }

        }

        return answer;
    }

    static void print(){
        int max = Integer.MIN_VALUE;
        if(determineTotal()){
            for (int i = 0; i < N; i++)  max = Math.max(max,budgetArray[i]);
            System.out.println(max);
        }
        else{
            System.out.println(binarySearch());
        }
    }

    public static void main(String[] args){
        input();
        print();
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
