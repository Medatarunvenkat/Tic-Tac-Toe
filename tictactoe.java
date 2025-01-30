import java.util.Scanner;
class tictactoe
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Player 1");
        String p1=sc.next();
        System.out.println("Player 2");
        String p2=sc.next();
        //creating a board
        char board[][]=new char[3][3];
        //fill the board with dashes
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]='-';
            }
        }
         draw(board);
         boolean player1=true;
         char symbol=' ';
         while(true)
         {
         if(player1)
         {
             symbol='x';
             System.out.println(p1+ "(x) Turn");
         }
         else
         {
             symbol='o';
             System.out.println("p2+ (o) Turn");
         }
         int row=0,col=0;
         while(true)
         {
         System.out.println("Enter a row 0,1 or 2:");
         row=sc.nextInt();
         System.out.println("Enter a col 0,1 or 2:");
         col=sc.nextInt();
         if(row<0 || col<0 || row>2 || col>2)
         {
             System.out.println("Row and Column are out of bound");
         }
         else if(board[row][col]!='-')
         {
             System.out.println("Already occupied");
         }
         else
         {
             break;
         }
         }
         board[row][col]=symbol;
         draw(board);
         if(won(board)=='x')
         {
             System.out.println(p1+" has won!");
         }
         else if(won(board)=='o')
         {
             System.out.println(p2+" has won!");
         }
         else if(tied(board))
         {
                 System.out.println("Its a draw match");
                 break;
         }
         player1=!player1;
    }
}
        //printing
          public static void draw(char[][] board)
        {
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
        }
        public static char won(char[][] board)
        {
            for(int i=0;i<3;i++)
            {
                if(board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][0]!='-')
                {
                    return board[i][0];
                }
            }
            for(int j=0;j<3;j++)
            {
                if(board[0][j]==board[1][j] && board[1][j]==board[2][j] && board[0][j]!='-')
                {
                    return board[0][j];
                }
            }
            if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0]!='-')
            {
                return board[0][0];
            }
            if(board[2][0]==board[1][1] && board[1][1]==board[0][2] && board[2][0]!='-')
            {
                return board[2][0];
            }
            return '-';
        }
        public static boolean tied(char[][] board)
        {
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(board[i][j]=='-')
                    {
                        return false;
                    }
                }
            }
            return true;
        }
}