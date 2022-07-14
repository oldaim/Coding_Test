package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502  {
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static FastReader reader = new FastReader();
    static boolean[][] virus;
    static int N , M, MAX = Integer.MIN_VALUE;
    static int[][] labo;

    static void input(){
        N = Integer.parseInt(reader.next());
        M = Integer.parseInt(reader.next());
        virus = new boolean[N][M];
        labo = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                labo[i][j] = Integer.parseInt(reader.next());

            }
        }

    }

    static void createWall(boolean[][] map, int[][] lab){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {


                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < M; l++) {


                                for (int m = 0; m < N; m++) {
                                    for (int n = 0; n < M; n++) {
                                        if((i == k && j == l) || (m == i && n == j) || ( m == k && n == l)) continue;
                                        if (lab[m][n] == 0 && lab[k][l] == 0 && lab[i][j] == 0) {

                                            int[][] copyArray = new int[N][M];
                                            boolean[][] Map = new boolean[N][M];

                                            lab[i][j] = lab[m][n] = lab[k][l] = 1;

                                            for (int o = 0; o < N; o++) {
                                                for (int p = 0; p < M; p++) {
                                                  copyArray[o][p] =  lab[o][p];
                                                }
                                            }
                                            int result = BFS(Map,copyArray);

                                            MAX = Math.max(MAX,result);

                                            lab[i][j] = lab[m][n] = lab[k][l] = 0;
                                        }
                                    }
                                }

                        }
                    }

            }
        }

        System.out.println(MAX);
    }

    private static int BFS(boolean[][] map, int[][] lab) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] dx = {
                {0,1}, {0,-1}, {1,0}, {-1,0}
        };

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(lab[i][j] == 2){
                    queue.add(new Pair(i,j));
                    while (!queue.isEmpty()){

                        Pair cL = queue.remove();

                        for (int k = 0; k < 4; k++) {
                            int x = cL.x + dx[k][0];
                            int y = cL.y + dx[k][1];

                            if(x > N - 1 || x < 0 || y > M - 1|| y < 0 ) continue;
                            if(map[x][y] || lab[x][y] != 0) continue;

                            map[x][y] = true;
                            lab[x][y] = 2;
                            queue.add(new Pair(x,y));
                        }

                    }



                }
            }
        }


        return count(lab);

    }

    private static int count(int[][] lab) {
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) safe++;
            }
        }
        return safe;
    }

    public static void main(String[] args){
        input();
        createWall(virus,labo);
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
