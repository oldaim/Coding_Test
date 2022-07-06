package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2343 {
    static FastReader reader = new FastReader();
    static int N = 0 , numOfBlue = 0;
    static int[] lecture;

    static void input(){
        N = Integer.parseInt(reader.next());
        numOfBlue = Integer.parseInt(reader.next());
        lecture = new int[N];

        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(reader.next());
        }
    }

    static boolean determination(int m){
        int total = 0;
        int count = 1;
        for (int i = 0; i < N; i++) {
            int num = total + lecture[i];
            if(num > m) {
                count++;
                total = lecture[i];
            }
            else{
                total += lecture[i];
            }

        }

        return count <= numOfBlue; // 원하는 갯수보다 많다 = 저장용량이 부족하니 늘려야한다!
                                    // 적거나 같다 = 저장용량이 충분하니 줄여야 한다.
                                    // 줄이는 쪽에 answer를 두면 최소값 기대
    }

    static int binarySearch(){
        int L = 0, R = 1000000000, answer = 0; // R의 범위? 강의수 * 강의 시간 고려했었어야... ㅠㅠ
        for (int i = 0; i < N; i++) L = Math.max(L,lecture[i]);
        while (L <= R){
            int mid = (L + R) / 2;
            if(determination(mid)){

                answer = mid;
                R = mid - 1;


            }
            else{
                L = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        input();
        System.out.println(binarySearch());
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
