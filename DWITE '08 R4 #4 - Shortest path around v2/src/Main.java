import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static char[][] map;
    static int[][] dp;

    static class Cords{
        int row, col;
        public Cords(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private static void findPath(int row, int col, int count){
        if(row >= 0 && row < 8 && col >= 0 && col < 8 && count < dp[row][col] && map[row][col] != '#'){
            dp[row][col] = count;
            findPath(row + 1, col, count + 1);
            findPath(row - 1, col, count + 1);
            findPath(row, col + 1, count + 1);
            findPath(row, col - 1, count + 1);
            findPath(row + 1, col + 1, count + 1);
            findPath(row - 1, col + 1, count + 1);
            findPath(row + 1, col - 1, count + 1);
            findPath(row - 1, col - 1, count + 1);
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z = 0 ;z  < 5 ; z++){
            map = new char[8][8];
            dp = new int[8][8];
            Cords[] spots = new Cords[2];
            for(int i = 0 ; i < 8; i++){
                map[i] = next().toCharArray();
                for(int a = 0; a < 8 ;a++){
                    dp[i][a] = 99999;
                    if(map[i][a] == 'A'){
                        spots[0] = new Cords(i, a);
                    }
                    else if(map[i][a] == 'B'){
                        spots[1] = new Cords(i, a);
                    }
                }
            }
            findPath(spots[0].row, spots[0].col, 0);
            out.println(dp[spots[1].row][spots[1].col]);
        }



        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}