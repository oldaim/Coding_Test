package FastCampusLecture.Chapter_01_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15650 {
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

    static void rec_func(int k){
        if(k == M + 1){ // selected 배열이 자릿수만큼 채워진다면 stringBuilder 에 답안을 채워넣는다.
                        // stringBuilder를 사용하는 이유는 String + String 은 메모리 해제후 재할당해서 새로운 String 을 만들어 내야 하기 때문이다.
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');

            }
            sb.append('\n');
        }
        else{
            if(k == 1) { // 1의 자리수에서는 차례대로 넣어준다
                for (int cand = 1; cand <= N; cand++) {
                    selected[k] = cand;
                    rec_func(k + 1);
                    selected[k] = 0;
                }
            }
            else {

                for (int cand = 1; cand <= N ; cand++) { // 2의 자리수부터 후보군을 한정해서 정한다.
                    boolean isUsed = false;
                    for (int i = 1; i <= M ; i++) { // 만약 전의 자리수에서 사용한 숫자라면 후보군에서 제외한다.
                        if (selected[i] == cand) {
                            isUsed = true;
                            break;
                        }
                    }
                    if(!isUsed && selected[k - 1] < cand){ // 사용하지 않았고 또한 전의 자리수보다 큰 숫자라면 (오름차순을 위해)
                        selected[k] = cand;                // 후보군에 넣고 재귀 함수에 사용한다.
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
