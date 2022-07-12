package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ6236 {
    static FastReader reader = new FastReader();
    // N일동안 돈을 사용한다 , M번만 인출한다.
    // K원을 인출한다 , 하루를 보낼 수 있으면 그대로 사용
    // 모자라면 남은 금액을 통장에 넣고 다시 K원 인출
    // M번을 맞추기 위해서는 남은 금액이 그날 사용할 금액 보다 많더라도 통장에 집어넣고 다시 K원 인출 가능
    static int N = 0 , limit = 0;
    static int[] budget;

    static void input(){
        N = Integer.parseInt(reader.next());
        limit = Integer.parseInt(reader.next());
        budget = new int[N];

        for (int i = 0; i < N; i++) {
            budget[i] = reader.nextInt();
        }

    }

    static boolean determination(long mid){
        int cnt = 1; // 일단 한번 인출 하고 시작
        int total = 0;

        for (int i = 0; i < N; i++) {

            if(total + budget[i] > mid) {
                total = budget[i];
                cnt++;
            }
            else{
                total += budget[i];
            }


        }


        return cnt <= limit;  // mid가 커질수록 cnt 는 감소
                            // cnt 가 더 크면 mid를 증가 해야한다
    }

    static long binarySearch(){
        int L = budget[0], R = 1000000000, answer = 0;
        for (int i = 0; i < N; i++) L = Math.max(L,budget[i]); // 이 조건이 없을때 왜 안되는지 모르겠다
                                                                // N 이 M 보다 작거나 같아야 하니깐 무조건 하루 예산보다 클수밖에 없다
                                                                // 반례가 있었으면 좋겠는데
        while (L <= R){
            int mid = (L + R) / 2;
            if(determination(mid)){

                R = mid - 1;
                answer = mid;
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
