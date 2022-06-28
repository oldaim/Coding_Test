package FastCampusLecture.Chapter_01_BruteForce;

import java.io.*;
import java.util.*;

// N과 M 9
public class BOJ15663 {
    // N 개의 수로 만들 수 있는 길이 M 의 수열
    static int N,M;
    static int[] candArray;
    static int[] selected;
    static boolean[] isUsed;
    static List<String> stringList = new ArrayList<>();

    static void input(){
        FastReader reader = new FastReader();
        N = reader.nextInt();
        M = reader.nextInt();

        candArray = new int[N];
        selected = new int[M + 1];
        isUsed = new boolean[N];

        for (int i = 0; i < N; i++) {
            candArray[i] = reader.nextInt();
        }

        Arrays.sort(candArray);
    }


    static void rec_func(int k){ // 중복되는 수열을 여러번 출력하면 안된다 =  같은자리에 중복되는 수만 없으면 된다?
        if(k == M){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {

                sb.append(selected[i]).append(' ');
            }

            if(!stringList.contains(sb.toString())) stringList.add(sb.toString());


        }
        else{
            for (int i = 0; i < N; i++) {

                if(!isUsed[i]) {
                    selected[k] = candArray[i];
                    isUsed[i] = true;
                    System.out.println("* ");
                    rec_func(k + 1);
                    selected[k] = 0;
                    isUsed[i] = false;
                }


            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(0);
        for (String s:stringList) {
            System.out.println(s);
        }

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
