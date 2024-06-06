
import java.util.*;

class tic {
    static char[][] board;

    public tic() {
        board = new char[3][3];
        initBoard();
    }

    static void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void dispBoard() {
        System.out.println("------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("------------");


        }


    }

    static void pm(int row, int col, char mark) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {

            board[row][col] = mark;
        } else {
            System.out.println("invalid position");
        }
    }

    static boolean checkColWin() {
        for (int j = 0; j <= 2; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }

        }
        return false;

    }

    static boolean checkRowWin() {
        for (int i = 0; i <= 2; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;

            }
        }
        return false;
    }

    static boolean boardDig() {
        if (board[1][1] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[1][1] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;

        }
        return false;
    }

}
    class HumanPlayer {
        String name;
        char mark;
        HumanPlayer(String name ,char mark){
            this.name=name;
            this.mark=mark;
        }
       public  void makeMove(){
            Scanner sc= new Scanner(System.in);
            int row ;
            int col;
           do{
               System.out.print("inter the row and col");
               row =sc.nextInt();
                col =sc.nextInt();

           }while(!isValidMove(row,col)); {
                tic.pm(row, col, mark);
            }
        }
        boolean isValidMove (int row ,int col ){
            if (row >=0 && row<=2 && col>=0 && col<=2){
                if (tic.board[row][col]==' ')
                {
                    return true;
                }
            }
            return false;
        }
    }



    public class QticTacToe {
       public static void main(String[] args) {
           tic t = new tic();
          HumanPlayer p1= new HumanPlayer("shivam ",'x');
           HumanPlayer p2=new HumanPlayer("shubham",'O');
           HumanPlayer cp;
           cp = p1;
           while(true) {
               System.out.println(cp.name+ " turn  :   ");
               cp.makeMove();
               tic.dispBoard();
               if (tic.checkColWin()||tic.checkRowWin()||tic.boardDig()){
                   System.out.println(cp.name+"has name");
                   break;
               }
               else{
                   if (cp==p1){
                       cp=p2;
                   }else {
                       cp=p1;
                   }

               }
           }
       }
    }
