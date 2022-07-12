package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
/*
* 일차원 상에서 갈수있는 방법 3가지를 가지고 진행하는 최단거리 문제 (DFS 도 상관 없었을듯)
* 기존 2차원상에서 상하좌우로 적용하던 케이스를 좌 우 순간이동 3가지로 변경 하여 적용
* 처음 접하면 못풀수도 있을거같았음 -> 2251과 유사해서 접근할 수 있었음
*/
    static class location{
        int N;
        int time;

        public location(int n, int t) {
            N = n;
            time = t;
        }

        public location back(){
            return new location(N - 1, time + 1);
        }

        public location front(){
            return new location(N + 1, time + 1);
        }

        public location magic(){
            return new location(2 * N, time + 1);
        }
    }
    static FastReader reader = new FastReader();
    static int N , K;
    static location[] bfsArray = new location[1000001];
    static boolean[] visited = new boolean[1000001];
    static location start;

    static void input(){
        N =  Integer.parseInt(reader.next());
        K =  Integer.parseInt(reader.next());
        start = new location(N,0);
    }

    static void BFS(){
        Queue<location> queue = new LinkedList<>();
        visited[start.N] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            location tmp = queue.remove();

            if(tmp.N == K) {
                System.out.println(tmp.time);
                break;
            }

            for (int i = 1; i <= 3 ; i++) {
                location move = null;

                if(i == 1) {
                    move = tmp.back();
                }
                if(i == 2) {
                    move = tmp.front();
                }
                if(i == 3){
                    move = tmp.magic();
                }


                if(move.N < 0 || move.N > 100000 || visited[move.N]) continue;

                visited[move.N] = true;
                queue.add(move);

            }


        }

    }

    public static void main(String[] args){
        input();
        BFS();
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
