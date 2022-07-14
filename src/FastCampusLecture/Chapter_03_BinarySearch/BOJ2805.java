package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 { // 실패!

    static int N = 0 , lenOfWood = 0;
    static int[] wood;
    static FastReader reader = new FastReader();

    static void input(){
        N = Integer.parseInt(reader.next());
        lenOfWood = Integer.parseInt(reader.next());
        wood = new int[N];

        for (int i = 0; i < N; i++) {
            wood[i] = Integer.parseInt(reader.next());
        }

        Arrays.sort(wood);
    }

    static int binarySearch(int[] arr, int L, int R , int key){

        int maxIndex = 0;

        while (L <= R){
            int mid = (L + R) / 2;
            long cutLen = cutWood(arr, mid, N - 1);

            if(cutLen < key){ // 자른길이가 필요한 길이보다 짧다 = 작은 것도 탐색 진행
                R = mid - 1;
                maxIndex = mid;
            }
            else if(cutLen > key){ // 자른 길이가 필요한 길이보다 길다 = 큰거에서 범위를 좁혀나간다.
                L = mid + 1;
                maxIndex = mid;
            }
            else {
                maxIndex = mid;
                break;
            }

        }

        return maxIndex; // 최소 로 잘라낼 나무의 index를 반환
    }
    static long cutWood(int[] arr, int start, int end){ // 나무 자른 길이 구하는 함수

        long M = arr[start] , total = 0;

        for (int i = start; i <= end; i++) {
            total += ( arr[i] - M );
        }

        return total;
    }

    static long cutWoodFinal(int[] arr, long max, int startIndex, int endIndex){ // 나무 자른 길이 구하는 함수

        long total = 0;

        for (int i = startIndex; i <= endIndex; i++) {
            total += ( arr[i] - max);
        }

        return total;
    }

    static void print(){
        int maxIndex = binarySearch(wood,0,N - 1,lenOfWood);

        long score = cutWood(wood, maxIndex,N-1) - lenOfWood; // 나무 최소 길이 보다 작다 == 탐색범위보다 아래쪽에 M 이 존재 한다.
                                                                    // 나무 최소 길이 보다 크다 == 탐색범위보다 위쪽에 M 이 존재 한다.
        long cut = wood[maxIndex];

        if(score > 0) {
            while (true){
               if(lenOfWood >= cutWoodFinal(wood,cut,maxIndex + 1,N -1)){
                   System.out.println(cut);
                   break;
               }
               cut++;
            }
        }
        else if(score < 0) {

            while (true){
                if(lenOfWood <= cutWoodFinal(wood,cut, maxIndex,N -1)){

                    System.out.println(cut);
                    break;
                }
                cut--;
            }

        }
       else{
            System.out.println(wood[maxIndex]);
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
