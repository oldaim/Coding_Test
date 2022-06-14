package FastCampusLecture.Chapter_01_BruteForce;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1182 {
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

        backUpUnion = new ArrayList<>(union);
    }

    static boolean isEqualS(int[] sel, int count){

        int totalSum = 0;

        for (int i = 1; i <= count ; i++) {
            totalSum += sel[i];
        }

        return totalSum == S;

    }

    static void rec_func(int k , int count){

        if(k == count + 1){
            if(isEqualS(selected, count)) sumEqualS++;
        }
        else if(k == 1) {

            for (int i = 0; i < union.size(); i++) {
                int tempInteger = union.get(i);
                selected[k] = union.remove(i);

                rec_func(k + 1, count);

                selected[k] = 0;
                union.add(i,tempInteger);

            }

        }
        else{

            for (int i = 0; i < union.size(); i++) {
                if(selected[k-1] < union.get(i)) {

                    int tempInteger = union.get(i);
                    selected[k] = union.remove(i);

                    rec_func(k + 1, count);

                    selected[k] = 0;
                    union.add(i,tempInteger);

                }

            }

        }
    }

    static void roof_recFunc(){
        for (int i = 1; i <= N ; i++) {
            rec_func(1, i);
            union = new ArrayList<>(backUpUnion);
        }
    }


    public static void main(String[] args) {
        input();
        roof_recFunc();
        System.out.println(sumEqualS);
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
