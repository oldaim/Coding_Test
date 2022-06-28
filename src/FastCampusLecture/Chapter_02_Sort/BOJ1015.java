package FastCampusLecture.Chapter_02_Sort;

import java.io.*;
import java.util.*;

public class BOJ1015 {
    // 0부터 N -1 까지수를 한 번씩 포함하고 있는 수열
    // p -> index A가 비 내림차순이 되도록 만드는 index를 찾으면 된다.
    // 뭔소린지를 모르겠네
    static class OriginIndex implements Comparable<OriginIndex>{ // 원래 인덱스를 저장해서 출력하는 class
        int element;
        int index;

        public OriginIndex(int element,int index) {
            this.element = element;
            this.index = index;
        }

        @Override
        public int compareTo(OriginIndex o) {
            return element - o.element;
        }
    }

    static int N = 0;
    static List<OriginIndex> originIndexList = new ArrayList<>();
    static int[] originArray;

    static void input(){
        FastReader reader = new FastReader();
        N = reader.nextInt();
        originArray = new int[N];
        for (int i = 0; i < N; i++) {
            originIndexList.add(new OriginIndex(Integer.parseInt(reader.next()),i));
        }


    }

    static void sort(){
        Collections.sort(originIndexList);
        for (int i = 0; i < N; i++) {
            originArray[originIndexList.get(i).index] = i;
        }
    }

    static void print(){
        for (int i = 0; i < N; i++) {
            System.out.print(originArray[i]);
            System.out.print(' ');
        }
    }



    public static void main(String[] args) {
        input();
        sort();
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
