package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.*;

public class BOJ2667 {

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int [][] graph;
    static boolean [][] isVisited;
    static int N = 0, houseCount = 0;
    static FastReader reader = new FastReader();

    static void input(){

        N = reader.nextInt();
        graph = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1][N + 1];


        for (int i = 1; i <= N; i++) {
            String s = reader.nextLine();
            for (int j = 1; j <= N ; j++) {
                graph[i][j] = s.charAt(j - 1) - '0';
            }
        }

    }

    static void findHouse(){
        List<Integer> asList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                if(graph[i][j] == 1 && !isVisited[i][j]) {
                    int result = BFS(new Pair(i,j));
                    asList.add(result);
                    houseCount++;
                }
            }
        }

        System.out.println(houseCount);
        Collections.sort(asList);
        for (Integer integer : asList) {
            System.out.println(integer);
        }
    }

    private static int BFS(Pair start){
        Queue<Pair> queue = new LinkedList<>();
        int[][] dx = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };
        int houseNum = 1;

        queue.add(start);
        isVisited[start.x][start.y] = true;

        while (!queue.isEmpty()){

            Pair cL = queue.remove();

            for (int i = 0; i < 4; i++) {
                int x = cL.x + dx[i][0];
                int y = cL.y + dx[i][1];

                if(x > N || x < 1 || y > N || y < 1 ) continue;
                if(isVisited[x][y] || graph[x][y] != 1) continue;

                isVisited[x][y] = true;
                queue.add(new Pair(x,y));
                houseNum++;


            }

        }

        return houseNum;
    }

    public static void main(String[] args){
        input();
        findHouse();
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
