package FastCampusLecture.Chapter_01_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int N = 0;
    static int M = 0;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void input(){

        FastReader reader = new FastReader();
        N = reader.nextInt();
        M = reader.nextInt();
        selected = new int[M + 1]; // 이런식으로 동적할당이 가능하다!
     }

    static void rec_func (int k){

        if (k == M + 1) { // 1 ~ M 번째를 전부 다 골랐다!
            // selected[1...M] 배열이 새롭게 탐색된 결과
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }

        else{ // 자리수 K 에 조건의 맞는 숫자가 들어가야 된다.

            if(k == 1){ // 1의 자릿수는 N 까지 차례대로 넣어주자

                for (int cand = 1; cand <= N ; cand++) {
                    selected[k] = cand;
                    rec_func(k + 1);
                    selected[k] = 0;
                }

            }

            else {// 2의 자릿수에서 만약 K -1 의 자릿수 보다 후보군 숫자가 크다면?
                  // 자릿수에 넣어주고 K + 1 을 탐색한다
                for (int cand = 1; cand <= N ; cand++) {
                    if(selected[k-1] <= cand){
                        selected[k] = cand;
                        rec_func(k + 1);
                        selected[k] = 0;
                    }
                }

            }

        }
    }



    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());

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
