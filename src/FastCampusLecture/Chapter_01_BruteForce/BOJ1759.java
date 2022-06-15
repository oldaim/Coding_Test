package FastCampusLecture.Chapter_01_BruteForce;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Arrays.asList;

public class BOJ1759 {
    static int L = 0 , C = 0; // L : 문자열 자릿수 , C : 입력될 문자의 갯수
    static StringBuilder candidateChar;
    static StringBuilder result = new StringBuilder();
    static char[] selected;

    static void input(){

        FastReader reader = new FastReader();
        L = reader.nextInt();
        C = reader.nextInt();
        selected = new char[L + 1]; // 암호 후보군을 저장할 배열

        String tmpString = reader.nextLine();
        tmpString = tmpString.replaceAll(" ","");
        char[] temp = tmpString.toCharArray();
        Arrays.sort(temp);
        tmpString= new String(temp);
        candidateChar = new StringBuilder(tmpString);

    }



    static boolean isHaveTwo(char[] sel){
        int notVowelCount = 0;
        int vowelCount =0;
        System.out.println(sel);
        for (int i = 1; i <= L; i++) {

            if (sel[i] == 'a' || sel[i] == 'e' || sel[i] == 'i' || sel[i] == 'o' || sel[i] == 'u') vowelCount++;
            else notVowelCount++;

        }

        return notVowelCount >= 2 && vowelCount >= 1;
    }

    // 최소 한개의 모음을 가지고 있어야하고
    // 알파벳이 증가하는 순서로 정렬

    static void rec_func(int k){
        if(k == L  + 1){
           if(isHaveTwo(selected)) {
               for (int i = 1; i <= L; i++) result.append(selected[i]);
               result.append('\n');
           }
        }
        else if (k == 1){
            for (int cand = 0; cand < L; cand++) {

                selected[k] = candidateChar.charAt(cand);
                //candidateChar.deleteCharAt(cand);

                rec_func(k + 1);

               // candidateChar.insert(cand, selected[k]);
                selected[k] = '\0';
            }
        }
        else {

            for (int cand = 0; cand < C; cand++) {
                if(selected[k-1] < candidateChar.charAt(cand)){

                    selected[k] = candidateChar.charAt(cand);
                    //candidateChar.deleteCharAt(cand);

                    rec_func(k + 1);

                    //candidateChar.insert(cand, selected[k]);
                    selected[k] = '\0';

                }
            }


        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(result.toString());
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
