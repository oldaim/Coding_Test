package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ2110 { // 접근은 맞았는데 , 설치하는 공유기 갯수 구하는 과정에서 오류가 발생했었음

    static int numOfHouse = 0 , numOfAP = 0 , maxDis = 0, max = Integer.MIN_VALUE;
    static int[] location;




    static void input(){

        FastReader reader = new FastReader();
        numOfHouse = Integer.parseInt(reader.next());
        numOfAP = Integer.parseInt(reader.next());
        location = new int[numOfHouse];

        for (int i = 0; i < numOfHouse; i++) {
            location[i] = reader.nextInt();

        }

        Arrays.sort(location);

    }

    static boolean determination(int M){
        int cnt = 1, last = location[0];
        for (int i = 1; i < numOfHouse ; i++) {
            if(location[i] - last < M) continue;
            last = location[i];
            cnt++;
        }
        return cnt >= numOfAP;
    }

    static void binarySearch(){
        int L = 1 , R = 1000000000;
        while (L <= R){
            int mid = (L + R) / 2;
            if(!determination(mid)){
                R = mid - 1;
            }
            else{
                L = mid + 1;
                max = mid;
            }
        }

    }

    static void print(){
        binarySearch();
        System.out.println(max);
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
