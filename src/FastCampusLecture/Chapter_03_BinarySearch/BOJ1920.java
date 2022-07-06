package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1920 {

    static HashSet<Integer> set = new HashSet<>();
    static int N = 0 , M = 0;
    static FastReader reader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){

        N = reader.nextInt();

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(reader.next()));
        }

        M = reader.nextInt();

        for (int i = 0; i < M; i++) {
            int inputM = Integer.parseInt(reader.next());
            if(set.contains(inputM)) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }
    }

    public static void main(String[] args) {
        input();
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
