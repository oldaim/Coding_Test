package FastCampusLecture.Chapter_02_Sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15970 {
    static class period implements Comparable<period>{ // 점의 위치와 색깔을 저장하는 클래스
        int location;
        int color;



        public period(int location, int color) {
            this.location = location;
            this.color = color;
        }

        @Override
        public int compareTo(period o) {
            return location - o.location;
        }
    }

    static int N = 0;
    static int totalDistance = 0;
    static List<period> periodList = new ArrayList<>();

    static void input(){
        FastReader reader = new FastReader();
        N = reader.nextInt();

        for (int i = 0; i < N; i++) {
            int location = Integer.parseInt(reader.next());
            int color  = Integer.parseInt(reader.next());

            periodList.add(new period(location,color));

        }

        Collections.sort(periodList);
    }

    static int calArrow(){

        for (int i = 0; i < N; i++) {

            int location = periodList.get(i).location;
            int color = periodList.get(i).color;
            int distanceBefore = Integer.MAX_VALUE , distanceAfter = Integer.MAX_VALUE;

            for (int j = i - 1; j >= 0 ; j--) {

                if (color == periodList.get(j).color) {
                    distanceBefore = Math.abs(location - periodList.get(j).location);
                    break;
                }
            }

            for (int j = i + 1; j < N; j++) {
                if(color == periodList.get(j).color) {
                    distanceAfter = Math.abs(location - periodList.get(j).location);
                    break;
                }
            }
            totalDistance += Math.min(distanceBefore, distanceAfter);
        }
        return totalDistance;
    }

    public static void main(String[] args) {
        input();
        System.out.println(calArrow());
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
