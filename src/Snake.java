import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Snake {
    private char[][] snakeBoard;
    Queue<Node> queue=new LinkedList<>();
    int count;
    public Snake(int row, int col) {
        this.snakeBoard=new char[row][col];
        this.snakeBoard[3][5]='*';
        this.snakeBoard[5][8]='*';
        this.snakeBoard[8][7]='*';
        this.snakeBoard[4][3]='*';
       this. queue.add(new Node(0,0));
        this.count=4;
    }

    public void gameOn(int row, int col) {
        if(row<0||col<0||row>=snakeBoard.length||col>=snakeBoard[0].length||snakeBoard[row][col]=='X'){
            System.out.println("GAME OVER");
            System.exit(0);
        }

        else{

            if(snakeBoard[row][col]!='*'){
                Node n=queue.poll();
                System.out.println(n.getRow()+" "+n.getCol());
                snakeBoard[n.getRow()][n.getCol()]='\0';
            }
            if(snakeBoard[row][col]=='*'){
               count--;
            }
            queue.add(new Node(row,col));
            snakeBoard[row][col]='X';
            while(!queue.isEmpty()){
                printBoard(snakeBoard);
                Scanner scn=new Scanner(System.in);
                if(count==0){
                    System.out.println("YOU WON");
                    System.exit(0);
                }
                System.out.println("Enter a direction : ");
                char ch=scn.next().charAt(0);
                if(ch=='U'){
                    gameOn(--row,col);
                }
                if(ch=='D'){
                    gameOn(++row,col);
                }
                if(ch=='R'){
                    gameOn(row,++col);
                }
                if(ch=='L'){
                    gameOn(row,--col);
                }
            }
        }

    }

    private void printBoard(char[][] snakeBoard) {
        for(int i=0;i<snakeBoard.length;i++){
            for(int j=0;j<snakeBoard[0].length;j++){
                if(snakeBoard[i][j]=='*'||snakeBoard[i][j]=='X'){
                    System.out.print(snakeBoard[i][j]+" ");
                }
                else{
                    System.out.print("."+" ");
                }
            }
            System.out.println();
        }
    }
}
