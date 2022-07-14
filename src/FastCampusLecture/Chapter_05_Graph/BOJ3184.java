package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3184 {
    // 서로가 찾아갈수 있으면 영역 만들수 있음
    // 양의 영역의 수가 많아야만 늑대를 쫒아 낼수 있음
    static class Pair{
        int x;
        int y;


        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static FastReader reader = new FastReader();
    static int R,C,numOfSheep = 0,numOfWolf = 0;
    static char[][] farm;
    static boolean[][] isVisited;

    static void input(){
        R = Integer.parseInt(reader.next());
        C = Integer.parseInt(reader.next());

        farm = new char[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String inputString = reader.nextLine();
            for (int j = 0; j < C; j++) {
                farm[i][j] = inputString.charAt(j);
            }
        }

    }

    static void findArea(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(farm[i][j] != '#' && !isVisited[i][j]) BFS(new Pair(i,j));
            }
        }
    }

    private static void BFS(Pair pair) {
        int sheep = 0;
        int wolf = 0;
        int[][] dx = {
                {0,1},{0,-1},{1,0},{-1,0}
        };

        Queue<Pair> queue = new LinkedList<>();
        isVisited[pair.x][pair.y] = true;
        queue.add(pair);

        while (!queue.isEmpty()){
            Pair location = queue.remove();
            if(farm[location.x][location.y] != '.'){
                if ((farm[location.x][location.y] == 'v')) {
                    wolf++;
                } else {
                    sheep++;
                }
            }

            for (int i = 0; i < 4; i++) {
                int x = location.x + dx[i][0];
                int y = location.y + dx[i][1];

                if(x > R - 1 || x < 0 || y > C - 1 || y < 0 ) continue;
                if(isVisited[x][y] || farm[x][y] == '#') continue;

                isVisited[x][y] = true;
                queue.add(new Pair(x,y));
            }


        }

        if(sheep > wolf) numOfSheep += sheep;
        else numOfWolf += wolf;

    }

    static void print(){
        input();
        findArea();

        System.out.printf("%d %d",numOfSheep,numOfWolf);
    }
    public static void main(String[] args){
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
