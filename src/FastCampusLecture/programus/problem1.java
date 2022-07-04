package FastCampusLecture.programus;

import java.util.Arrays;

public class problem1 {
    public static int[][] solution(int n, boolean horizontal) {
        int[][] answer = new int[n][n];
        int height = 0 , width =0 , number = 1 , max = 0, limit = n*n;
        answer[height][width] = number;


        while (true){
            if (number >= limit) break;
            else if(horizontal) {
                width =  max + 1;
                max = width;

                for (int i = 0; i < max; i++) {
                    number++;
                    answer[i][max] = number;
                }

                for (int i = max; i >= 0 ; i--) {
                    number++;
                    answer[max][i] = number;
                }





                horizontal = false;

            }
            else {
                height = max + 1;
                max = height;

                for (int i = 0; i < max; i++) {
                    number++;
                    answer[max][i] = number;
                }

                for (int i = max; i >= 0 ; i--) {
                    number++;
                    answer[i][max] = number;
                }

                horizontal = true;
            }
            System.out.println(Arrays.deepToString(answer));




        }



        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(5, true)));
    }
}
