package FastCampusLecture.Chapter_01_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14888 {

    static int N = 0; //연산자의 수
    static int[] calNumber; // 계산할 숫자을 저장할 배열
    static int[] operatorNum = new int[4]; // 연산자 갯수를 저장할 배열
    static char[] selected;
    static StringBuilder sb = new StringBuilder();
    static String operationArray;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    static void input(){
        FastReader reader = new FastReader();
        N = reader.nextInt();
        calNumber = new int[N + 1];
        selected = new char[N];
        for (int i = 0; i < N; i++) calNumber[i] = Integer.parseInt(reader.next());
        for (int i = 0; i < 4; i++) operatorNum[i] = Integer.parseInt(reader.next()); // + , - , * , / 의 순서대로 갯수 저장

        for (int i = 0; i < 4; i++) {
            if(operatorNum[i] != 0){
                if(i == 0){
                    while (operatorNum[i] != 0){
                        sb.append('+');
                        operatorNum[i] -= 1;
                    }
                }

                if(i == 1){
                    while (operatorNum[i] != 0){
                        sb.append('-');
                        operatorNum[i] -= 1;
                    }
                }

                if(i == 2){
                    while (operatorNum[i] !=  0){
                        sb.append('*');
                        operatorNum[i] -= 1;
                    }
                }

                if(i == 3){
                    while (operatorNum[i] !=  0){
                        sb.append('/');
                        operatorNum[i] -= 1;
                    }
                }
            }
        }

        operationArray = sb.toString();
    }





    static void rec_func(int k){

        if(k == N - 1){

           int result = operating(selected);
           max = Integer.max(max,result);
           min = Integer.min(min,result);

        }

        else{
            for (int cand = 0; cand < sb.length(); cand++) {

                String tempString = sb.toString();
                selected[k] = sb.charAt(cand);
                sb.deleteCharAt(cand);


                rec_func(k + 1);

                selected[k] = '\0';
                sb = new StringBuilder(tempString);
            }

        }

    }

    static int operating(char[] selected){
        int total = calNumber[0];

        for (int i = 0; i < N -1; i++) {
            if(selected[i] == '+') total = total + calNumber[i + 1];
            if(selected[i] == '-') total = total - calNumber[i + 1];
            if(selected[i] == '*') total = total * calNumber[i + 1];
            if(selected[i] == '/') total = total / calNumber[i + 1];
        }

        return total;
    }

    public static void main(String[] args) {
        input();
        rec_func(0);
        System.out.println(max);
        System.out.println(min);

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
