package codility;

public class Solution {


    public int solution(int[] X, int[] A){
        int answer = 0;
        int N = X.length;

        int[][][] tab = new int[N][N][2];

        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                for(int z = 0; z < 2; z++){
                    tab[x][y][z] = -1;
                }
            }
        }
        for(int x = 0; x < N; x++){
            tab[x][x][0] = tab[x][x][1] = A[x];
        }


        for(int d = 0; d + 1 < N; d++){

            for(int i = 0; i < N - d; i++){

                int j = d + i;


                //przypadek 1
                if(i != 0 && tab[i][j][0] >= X[i] - X[i-1]){
                    if( (tab[i][j][0] + A[i-1]) - (X[i] - X[i-1]) >tab[i-1][j][0]){
                        tab[i-1][j][0] = (tab[i][j][0] + A[i-1]) - (X[i] - X[i-1]);
                    }
                }
                //przypadek 2
                if(j+1 < N && tab[i][j][0] >= X[j+1] - X[i]){
                    if( (tab[i][j][0] + A[j+1]) - (X[j+1] - X[i]) > tab[i][j+1][1]){
                        tab[i][j+1][1] = (tab[i][j][0] + A[j+1]) - (X[j+1] - X[i]);
                    }
                }
                //przypadek 3
                if(i != 0 && tab[i][j][1] >= X[j] - X[i-1]){
                    if( (tab[i][j][1] + A[i-1]) - (X[j] - X[i-1]) >tab[i-1][j][0]){
                        tab[i-1][j][0] = (tab[i][j][1] + A[i-1]) - (X[j] - X[i-1]);
                    }
                }
                //przypadek 4
                if(j+1 < N && tab[i][j][1] >= X[j+1] - X[j]){
                    if( (tab[i][j][1] + A[j+1]) - (X[j+1] - X[j]) >tab[i][j+1][1]){
                        tab[i][j+1][1] = (tab[i][j][1] + A[j+1]) - (X[j+1] - X[j]);
                    }
                }



            }
        }

        for(int d = N - 1; d >= 0; d--){
            for(int i = 0; i < N - d; i++){
                int j = d + i;
                if(tab[i][j][0] >= 0 || tab[i][j][1] >= 0){
                    answer = j-i+1;
                    return answer;
                }

            }
        }


        return answer;
    }


}
