package FastCampusLecture.Chapter_02_Sort;

import java.io.*;
import java.util.*;

public class BOJ1181 {

    static int N = 0;

    static class StringWrapper implements Comparable<StringWrapper>{
        String word;
        int stringLength;

        public StringWrapper(String word) {
            this.word = word;
            this.stringLength = word.length();
        }

        @Override
        public int compareTo(StringWrapper o) {
            if(stringLength == o.stringLength) return word.compareTo(o.word);
            return stringLength - o.stringLength;
        }
    }

    static List<StringWrapper> wordList = new ArrayList<>();
    static HashSet<String> wordSet = new HashSet<>();

    static void input(){
        FastReader reader = new FastReader();
        N = reader.nextInt();

        for (int i = 0; i < N; i++) {
            String inputString = reader.nextLine();

            if(!wordSet.contains(inputString)){
                wordSet.add(inputString);
                wordList.add(new StringWrapper(inputString));
            }
        }

        Collections.sort(wordList);
    }

    static void print(){
        for(StringWrapper s:wordList){
            System.out.println(s.word);
        }
    }

    public static void main(String[] args) {
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
