package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012 {

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;

        }

    }
    static FastReader reader = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int R , C , larva;
    static int[][] area;
    static boolean[][] visit;

    static void testCase(){
        int N = reader.nextInt();
        for (int i = 0; i < N; i++) {
            input();
            findArea();
        }
        System.out.println(sb.toString());
    }

    static void input(){
        R = Integer.parseInt(reader.next());
        C = Integer.parseInt(reader.next());
        larva = Integer.parseInt(reader.next());

        area = new int[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < larva ; i++) {
            int inputR = Integer.parseInt(reader.next());
            int inputC = Integer.parseInt(reader.next());
            area[inputR][inputC] = 1;
        }
    }

    static void findArea(){
        int count = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(area[i][j] == 1 && !visit[i][j]) {
                    BFS(new Pair(i,j));
                    count++;
                }
            }
        }

        sb.append(count).append('\n');
    }

    static void BFS(Pair loc){
        Queue<Pair> queue = new LinkedList<>();
        int[][] dx = {{1,0}, {0,1}, {0,-1}, {-1,0}};

        visit[loc.x][loc.y] = true;
        queue.add(loc);


        // System.out.printf("%d %d\n",loc.x,loc.y);

        while (!queue.isEmpty()){

            Pair locCurrent = queue.remove();

            for (int i = 0; i < 4; i++) {
                int newX = locCurrent.x + dx[i][0];
                int newY = locCurrent.y + dx[i][1];

                if(newX > R -1 || newX < 0 || newY > C - 1 || newY < 0 ) continue;
                if(visit[newX][newY] || area[newX][newY] == 0) continue;

                visit[newX][newY] = true;
                queue.add(new Pair(newX,newY));
            }
        }
    }

    public static void main(String[] args){
        testCase();
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
