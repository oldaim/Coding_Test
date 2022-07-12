package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    static FastReader reader = new FastReader();
    static int[][] graph;
    static boolean[] isVisited;
    static int N, M, startPoint;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();

    static void input(){
        N = Integer.parseInt(reader.next()); // 정점의 개수
        M = Integer.parseInt(reader.next()); // 간선의 개수
        startPoint = Integer.parseInt(reader.next()); // 시작점

        graph = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            int inputN = Integer.parseInt(reader.next());
            int inputM = Integer.parseInt(reader.next());
            graph[inputN][inputM] = 1;
            graph[inputM][inputN] = 1;

        }

    }

    static void DFS(int start){


        sb.append(start).append(' ');
        isVisited[start] = true;

        for (int i = 1; i <= N; i++) {

            if(graph[start][i] == 1 && !isVisited[i]) {
                isVisited[i] = true;
                DFS(i);
            }


        }

    }

    static void BFS(int start){

        sb.append(start).append(' ');
        isVisited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){

            int cL = queue.poll();

            for (int i = 1; i <= N ; i++) {

                if (graph[cL][i] == 1 && !isVisited[i]){
                    isVisited[i] = true;
                    queue.add(i);
                    sb.append(i).append(' ');
                }

            }
        }

    }

    public static void main(String[] args){
        input();
        DFS(startPoint);

        sb.append('\n');
        isVisited = new boolean[N + 1];

        BFS(startPoint);

        System.out.println(sb);

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
