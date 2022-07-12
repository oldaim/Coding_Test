package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static FastReader reader = new FastReader();
    static int N , M;
    static int[][] miro;
    static boolean[][] visit;

    static class Pair{
        int x;
        int y;
        int dis;

        public Pair(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static void input(){
        N = Integer.parseInt(reader.next());
        M = Integer.parseInt(reader.next());
        miro = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = reader.nextLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = input.charAt(j) -'0';
            }
        }
    }

    static void BFS(Pair loc){
        Queue<Pair> queue = new LinkedList<>();
        int[][] dx = {{1,0}, {0,1}, {0,-1}, {-1,0}};

        visit[loc.x][loc.y] = true;
        queue.add(loc);


       // System.out.printf("%d %d\n",loc.x,loc.y);

        while (!queue.isEmpty()){

            Pair locCurrent = queue.remove();
            if(locCurrent.x == N - 1 && locCurrent.y == M - 1) {
                System.out.println(locCurrent.dis);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = locCurrent.x + dx[i][0];
                int newY = locCurrent.y + dx[i][1];

                if(newX > N -1 || newX < 0 || newY > M - 1 || newY < 0 ) continue;
                if(visit[newX][newY] || miro[newX][newY] == 0) continue;

                visit[newX][newY] = true;
                queue.add(new Pair(newX,newY, locCurrent.dis + 1));
            }
        }
    }

    public static void main(String[] args){
        input();
        BFS(new Pair(0,0,1));
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
