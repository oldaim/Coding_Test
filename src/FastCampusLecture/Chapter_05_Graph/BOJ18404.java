package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.*;

public class BOJ18404 {
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
    static FastReader reader = new FastReader();
    static boolean[][] isVisited;
    static int[][] chessMap;
    static LinkedHashMap<Pair,Integer> map = new LinkedHashMap<>();

    static StringBuilder sb = new StringBuilder();
    static int R,C;
    static Pair knight;

    static void input(){
        R = Integer.parseInt(reader.next());
        C = Integer.parseInt(reader.next());
        isVisited = new boolean[R][R];
        chessMap = new int[R][R];

        knight = new Pair(Integer.parseInt(reader.next()) - 1,Integer.parseInt(reader.next()) - 1,0);


        for (int i = 0; i < C; i++) {
            int inputF = Integer.parseInt(reader.next()) - 1;
            int inputB = Integer.parseInt(reader.next()) - 1;

            Pair tmp = new Pair(inputF,inputB,0);
            map.put(tmp,0);

            chessMap[inputF][inputB] = 1;

        }


    }

    private static void BFS() {
        Queue<Pair> queue = new LinkedList<>();
        int[][] dx ={{-2,-1},{-1,-2},{-2,1},{-1,2},{1,-2},{2,-1},{1,2},{2,1}};

        isVisited[knight.x][knight.y] = true;
        queue.add(knight);


        while (!queue.isEmpty()){
            Pair curr = queue.remove();

            if(chessMap[curr.x][curr.y] == 1) {
                for(Pair s:map.keySet()){
                    if(s.x == curr.x && s.y == curr.y) map.replace(s,0, curr.dis);
                }

            }

            for (int i = 0; i < 8; i++) {
                int newX = curr.x + dx[i][0];
                int newY = curr.y + dx[i][1];

                if(newY > R -1 || newY < 0 || newX > R - 1 || newX < 0) continue;
                if(isVisited[newX][newY]) continue;

                isVisited[newX][newY] = true;
                queue.add(new Pair(newX,newY, curr.dis + 1));

            }

        }

    }

    static void print(){
        input();
        BFS();
        for (Integer i:map.values()){
            System.out.printf("%d ",i);
        }
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
