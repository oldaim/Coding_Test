package FastCampusLecture.programus;

import java.util.*;

public class problem2 {

    static List<Integer> lakeList = new ArrayList<>();
    static int count = 0;
    class Pair{
        Integer y;
        Integer x;
        Integer dis;
        public Pair(Integer y, Integer x, Integer dis) {
            this.y = y;
            this.x = x;
            this.dis = dis;
        }

        public Pair(Integer y, Integer x) {
            this.y = y;
            this.x = x;

        }
    }

    public int[] solution(int rows, int columns, int[][] lands) {
        int[] answer = new int[2];
        int[][] isVisited = new int[rows][columns];

        // 1은 땅 2는 바다
        for (int[] land : lands) {
            for (int j = 0; j < 2; j++) {
                isVisited[land[0]][land[1]] = 1;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(i == 0 || i == rows -1 || j == 0 || j == columns - 1) isVisited[i][j] = 2;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(isVisited[i][j] != 1 && isVisited[i][j] != 2) {
                    isVisited[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(isVisited[i][j] == 3) {
                    BFS(new Pair(rows, columns), isVisited, rows, columns);
                    lakeList.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(lakeList);
        answer[0] = lakeList.get(0);
        answer[1] = lakeList.get(lakeList.size() - 1);
        return answer;
    }

    void BFS(Pair virus, int[][] lab, int rows, int columns) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] dx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue.add(virus);
        while (!queue.isEmpty()) {
            Pair location = queue.remove();
            for (int k = 0; k < 4; k++) {
                int newY = location.y + dx[k][0];
                int newX = location.x + dx[k][1];
                if (newY <= 0 || newX <= 0 || newY > rows || newX > columns) continue;
                if (lab[newY][newX] == 1 ) continue;
                if (lab[newY][newX] == 2) {
                    count = 0;
                    break;
                }

                lab[newY][newX] = 1;
                count++;
                queue.add(new Pair(newY, newX));


            }

        }


    }
}
