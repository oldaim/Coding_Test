package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.*;

public class BOJ1764 {

    static int N = 0 , M = 0;
    static String[] nArray;
    static List<String> result = new ArrayList<>();
    static FastReader reader = new FastReader();

    static void input(){

        N = Integer.parseInt(reader.next());
        M = Integer.parseInt(reader.next());
        nArray = new String[N];

        for (int i = 0; i < N; i++) {
            nArray[i] = reader.nextLine();
        }

        Arrays.sort(nArray);

        for (int i = 0; i < M; i++) {
            String inputString = reader.nextLine();
            binarySearch(inputString);
        }
    }

    static void binarySearch(String key){
        int L = 0 , R = N - 1;
        while(L <= R){
            int mid = (L + R) / 2;
            if(nArray[mid].compareTo(key) > 0){
                R = mid - 1;
            }
            else if (nArray[mid].compareTo(key) < 0) {
                L = mid + 1;
            }
            else {
                result.add(key);
                break;
            }
        }
    }

    static void print(){
        Collections.sort(result);
        System.out.println(result.size());
        for (String r: result) {
            System.out.println(r);
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
