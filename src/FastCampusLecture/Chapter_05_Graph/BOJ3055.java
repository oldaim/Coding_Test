package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.*;

public class BOJ3055 {
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
    /*
    * 비어있는 칸 . , 물이 차있는 칸 * , 돌은 X , 비버의 굴은 D , 고슴도치는 S
    * 고슴도치도 이동, 물도 영역을 넓힘
    * 고슴도치는 돌, 물 접근 못함
    * 고슴도치가 비버의 굴로 갈 수 있는 최단시간을 구하면 되는 문제
    * 만약 접근불가? "KAKTUS"
    * */
    static int R , C;
    static Pair hogStart =new Pair(0,0,0), floodStart=new Pair(0,0,0), end = new Pair(0,0,0);
    static char[][] forest;
    static int[][] timeOfWater,timeOfHog;
    static boolean[][] visit,flood;
    static void input(){
        R = Integer.parseInt(reader.next());
        C = Integer.parseInt(reader.next());
        forest = new char[R][C];
        timeOfWater = new int[R][C];
        timeOfHog = new int[R][C];
        visit = new boolean[R][C];
        flood = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String inputString = reader.nextLine();
            for (int j = 0; j < C; j++) {

                forest[i][j] = inputString.charAt(j);
                timeOfWater[i][j] = timeOfHog[i][j] = - 1;

                if(forest[i][j] == 'S') {
                    hogStart = new Pair(i,j,0);
                    visit[i][j] = true;
                }

                if(forest[i][j] == '*') {
                    floodStart =  new Pair(i,j,0);
                    flood[i][j] = true;
                }

                if(forest[i][j] == 'D'){
                    end = new Pair(i,j,0);
                }
            }
        }
    }

    static void Water_BFS(){
        Queue<Pair>  floodQueue = new LinkedList<>();
        int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};

        floodQueue.add(floodStart);

        while (!floodQueue.isEmpty()){
            Pair floodLocation = floodQueue.remove();
            timeOfWater[floodLocation.x][floodLocation.y] = floodLocation.dis;
            for (int i = 0; i < 4; i++) {
                int newX = floodLocation.x + move[i][0];
                int newY = floodLocation.y + move[i][1];


                if(newX > R - 1 || newX < 0 || newY > C - 1|| newY < 0) continue;
                if(forest[newX][newY] == 'X' || flood[newX][newY] || forest[newX][newY] == 'D') continue;


                flood[newX][newY] = true;
                floodQueue.add(new Pair(newX,newY,floodLocation.dis + 1));

            }
        }
    }

    static void Hog_BFS() {
        Queue<Pair> queue = new LinkedList<>();
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        queue.add(hogStart);

        while (!queue.isEmpty()) {
            Pair hogLocation = queue.remove();
            timeOfHog[hogLocation.x][hogLocation.y] = hogLocation.dis;
            for (int i = 0; i < 4; i++) {
                int newX = hogLocation.x + move[i][0];
                int newY = hogLocation.y + move[i][1];


                if (newX > R - 1 || newX < 0 || newY > C - 1 || newY < 0) continue;
                if (forest[newX][newY] == 'X' || visit[newX][newY]) continue;
                if (timeOfWater[newX][newY] != -1 && timeOfWater[newX][newY] <=timeOfHog[hogLocation.x][hogLocation.y] + 1) continue;

                visit[newX][newY] = true;
                queue.add(new Pair(newX, newY, hogLocation.dis + 1));

            }
        }
    }

    static void pro(){
        Water_BFS();
        Hog_BFS();

        if(timeOfHog[end.x][end.y] == -1) System.out.println("KAKTUS");
        else System.out.println(timeOfHog[end.x][end.y]);


    }



    public static void main(String[] args){
        input();
        pro();
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
