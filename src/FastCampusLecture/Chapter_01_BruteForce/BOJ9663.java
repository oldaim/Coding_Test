package FastCampusLecture.Chapter_01_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9663 { // N-Queen 문제 분류: 백트래킹 , 브루트포스 알고리즘
    static int N = 0, isAble = 0;
    static int[][] chessTable;
    static void input(){
        FastReader reader = new FastReader();

        N = reader.nextInt();

        chessTable = new int[N + 1][N + 1];

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N ; j++) {
                chessTable[i][j] = 0;
            }
        }
    }

    static void rec_func(int k){ // N-Queen의 갯수를 구하는 함수
        if(k == N + 1){
            isAble++; // 여기까지 진행되었다면 N-Queen의 경우의 수로 인정
        }
        else{
            for (int i = 1; i <= N ; i++) {
                if(check_column(chessTable,k) && check_row(chessTable,i) && check_cross(chessTable,k,i)){
                    chessTable[k][i] = 1;
                    rec_func(k + 1);
                    chessTable[k][i] = 0;
                }
            }
        }
    }

    static boolean check_row(int[][] chessTableLocal,int row){ // chess 말의 세로를 검사하는 함수

        for (int i = 1; i <=N ; i++) {
            if(chessTableLocal[i][row] == 1)
                return false;
        }

        return true;
    }

    static boolean check_column(int[][] chessTableLocal,int column){ // chess 말의 가로를 검사하는 함수

        for (int i = 1; i <=N ; i++) {
            if(chessTableLocal[column][i] == 1)
                return false;
        }

        return true;
    }

    static boolean check_cross(int[][] chessTableLocal,int column, int row){// chess 말의 대각선을 검사하는 함수

        int i = column;
        int j = row;

        while (i > 0 && j > 0){
           if(chessTableLocal[i][j] == 1)
               return false;
           i--;
           j--;
        }

        i = column;
        j = row;

        while (i > 0 && j < N + 1){
            if(chessTableLocal[i][j] == 1)
                return false;
            i--;
            j++;
        }

        i = column;
        j = row;

        while (i < N + 1 && j < N + 1){
            if(chessTableLocal[i][j] == 1)
                return false;
            i++;
            j++;
        }

        i = column;
        j = row;

        while (i < N + 1 && j > 0){
            if(chessTableLocal[i][j] == 1)
                return false;
            i++;
            j--;
        }

        return true;
    }




    public static void main(String[] args) {

        input();
        rec_func(1);
        System.out.println(isAble);
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
