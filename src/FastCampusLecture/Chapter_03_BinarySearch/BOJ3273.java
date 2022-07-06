package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    static int N = 0 , result = 0, count = 0;
    static int[] nArray;
    static FastReader reader = new FastReader();

    static void input(){
        N = reader.nextInt();
        nArray = new int[N];

        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(reader.next());
        }

        result = reader.nextInt();
        Arrays.sort(nArray);
    }

    static void binarySearch(int i){
        int L = i + 1 , R = N - 1;

        while (L <= R){
            int mid = (L + R) / 2;
            int num = nArray[i] + nArray[mid];

            if(num < result ){
                L = mid + 1;
            }
            else if(num > result){
                R =  mid - 1;
            }
            else{
                count ++;
                break;
            }

        }
    }

    static void print(){
        for (int i = 0; i < N; i++) {
            binarySearch(i);
        }
        System.out.println(count);
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
