package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {
    static class Pair{
        int x;
        int y;
        int dis;

        public Pair(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        public boolean isSame(Pair p){
            return x == p.x && y == p.y;
        }
    }
    static FastReader reader = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static Pair start,goal;
    static int T , N;
    static int[][] chessMap;
    static boolean[][] isVisited;
    /*
     * 나이트의 이동 반경 {-2,-1},{-1,-2},{-2,1},{-1,2},{1,-2},{2,-1},{1,2},{2,1}
     */
    static void testCase(){
        T = reader.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            BFS();
        }
        System.out.println(sb.toString());
    }

    static void input(){
        N = reader.nextInt();
        chessMap = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < 2; i++) {
            int inputF = Integer.parseInt(reader.next());
            int inputB = Integer.parseInt(reader.next());
            Pair tmp  = new Pair(inputF,inputB,0);
            if(i == 0) start = tmp;
            else goal = tmp;
        }


    }

    static void BFS(){
        int[][] dx ={{-2,-1},{-1,-2},{-2,1},{-1,2},{1,-2},{2,-1},{1,2},{2,1}};
        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start.x][start.y] = true;

        while (!queue.isEmpty()){
            Pair curr = queue.remove();
            if(curr.isSame(goal)){
                sb.append(curr.dis).append('\n');
                break;
            }
            for (int i = 0; i < 8; i++) {
                int newX = curr.x + dx[i][0];
                int newY = curr.y + dx[i][1];

                if(newY > N -1 || newY < 0 || newX > N - 1 || newX < 0) continue;
                if(isVisited[newX][newY]) continue;

                isVisited[newX][newY] = true;
                queue.add(new Pair(newX,newY, curr.dis + 1));

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
