package FastCampusLecture.Chapter_01_BruteForce;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1182 { // 실패 (강의좀 들어야될듯)
    static int N = 0;
    static int S = 0;
    static int sumEqualS;
    static List<Integer> union = new ArrayList<>();
    static List<Integer> backUpUnion = new ArrayList<>();
    static int[] selected;

    static void input(){

        FastReader reader = new FastReader();
        N = reader.nextInt();
        S = reader.nextInt();
        selected = new int[N  + 1];

        for (int i = 1; i <= N; i++) {
            union.add(reader.nextInt());
        }


    }

    static boolean isEqualS(int[] sel, int count){

        int totalSum = 0;

        for (int i = 1; i <= count ; i++) {
            totalSum += sel[i];
        }

        return totalSum == S;

    }

    static void rec_func(int k , int count){

        int tempInteger = 0;

        if(k == count + 1){
            System.out.print("");
        }
        else if(k == 1) {

            for (int i = 0; i < union.size(); i++) {
                tempInteger = union.get(i);
                selected[k] = union.remove(i);

                if(isEqualS(selected, count)) sumEqualS++;
                rec_func(k + 1, count);

                selected[k] = 0;
                union.add(i,tempInteger);

            }

        }
        else{

            for (int i = 0; i < union.size(); i++) {
                if(selected[k-1] < union.get(i)) {

                    tempInteger = union.get(i);
                    selected[k] = union.remove(i);

                    if(isEqualS(selected, count)) sumEqualS++;

                    rec_func(k + 1, count);

                    selected[k] = 0;
                    union.add(i,tempInteger);

                }

            }

        }
    }

    static void roof_recFunc(){

        rec_func(1, N);
        System.out.println(sumEqualS);

    }


    public static void main(String[] args) {
        input();
        roof_recFunc();
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
