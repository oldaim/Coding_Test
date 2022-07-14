package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963 {
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
    static int[][] map;
    static boolean[][] isIsland;

    static void testCase(){
        while (true){
            int width  = reader.nextInt();
            int height = reader.nextInt();

            if(width == 0 && height == 0) break;

            input(height,width);
            findIsland(height,width);
        }

        System.out.println(sb.toString());
    }

    static void input(int height, int width){

        map = new int[height][width];
        isIsland = new boolean[height][width];

        for (int i = 0; i < height; i++) {


            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(reader.next());
            }
        }
    }

    static void findIsland(int height,int width){
        // 1은 땅 0은 바다
        int numOfIsland = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(map[i][j] == 1 && !isIsland[i][j]) {
                    BFS(new Pair(i,j),height,width);
                    numOfIsland++;
                }
            }
        }

        sb.append(numOfIsland).append('\n');
    }

    private static void BFS(Pair start,int height,int width){
        Queue<Pair> queue = new LinkedList<>();
        int[][] dx = {
                {0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}
        };

        queue.add(start);
        isIsland[start.x][start.y] = true;
        while (!queue.isEmpty()){

            Pair cL = queue.remove();

            for (int i = 0; i < 8; i++) {
                int x = cL.x + dx[i][0];
                int y = cL.y + dx[i][1];

                if(x > height - 1 || x < 0 || y > width - 1 || y < 0 ) continue;
                if(isIsland[x][y] || map[x][y] == 0) continue;

                isIsland[x][y] = true;
                queue.add(new Pair(x,y));



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
