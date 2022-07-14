package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11403 {
    static FastReader reader = new FastReader();
    static int N;
    static int[][] infoArray , resultArray;
    static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();

    static void input(){

        N = reader.nextInt();
        infoArray = new int[N][N];
        resultArray = new int[N][N];

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            nodeList.add(tmp);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                infoArray[i][j] = reader.nextInt();
                if(infoArray[i][j] == 1) nodeList.get(i).add(j);
            }
        }
    }

    static void findWay(){
        for (int i = 0; i < N; i++) {
            BFS(i);
        }
    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N];

        queue.add(start);

        while (!queue.isEmpty()){
            int curr = queue.remove();
            ArrayList<Integer> nodes = nodeList.get(curr);

            for (Integer i: nodes){
                if(isVisited[i]) continue;
                isVisited[i] = true;
                queue.add(i);
                resultArray[start][i] = 1;
            }
        }

    }

    static void print(){

        input();

        findWay();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%d ",resultArray[i][j]);
            }
            System.out.println();
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
