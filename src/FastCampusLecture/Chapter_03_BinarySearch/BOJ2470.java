package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {

    static int N = 0 , MIN = Integer.MAX_VALUE , pair1 = 0, pair2 = 0;
    static int[] liquidArray;
    static FastReader reader = new FastReader();

    static void input(){

        N = reader.nextInt();
        liquidArray = new int[N];

        for (int i = 0; i < N; i++) {
            liquidArray[i] = Integer.parseInt(reader.next());
        }

        Arrays.sort(liquidArray);
    }

    static void binarySearch(int[] arr, int L, int R, int key){
        // 두개의 합이 0초과이다 = 작은수를 탐색해야한다.
        // 두개의 합이 0미만이다. = 큰수를 탐색해야한다.
        // 0 이다. =  그거 출력해라.
        while(L <= R){

            int mid = (L + R)/2;
            int result = key + arr[mid];
            if(result < 0){
                L = mid + 1;
                if(isMinValue(result,key,arr[mid])){
                    pair1 = key;
                    pair2 = arr[mid];
                }
            }
            else if(result > 0){
                R = mid - 1;
                if(isMinValue(result,key,arr[mid])){
                    pair1 = key;
                    pair2 = arr[mid];
                }
            }
            else{
                if(isMinValue(result,key,arr[mid])){
                    pair1 = key;
                    pair2 = arr[mid];
                }
                break;
            }
        }

    }

    static void print(){

        for (int i = 0; i < N; i++) {
           binarySearch(liquidArray,0, N -1, liquidArray[i]);
        }
        if(pair2 > pair1) System.out.printf("%d %d",pair1,pair2);
        else System.out.printf("%d %d",pair2, pair1);
    }

    static boolean isMinValue(int result, int key , int mid){
        // 두 용액의 합이 절댓값 기준으로 0으로 부터 최소라면 MIN 갱신한다.
        int distance = Math.abs(result);
        if(MIN > distance && key != mid) {
            MIN = distance;
            return true;
        }
        else return false;
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
