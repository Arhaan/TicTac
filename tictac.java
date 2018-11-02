import java.util.*;

public class tictac{
    int arr[][] = new int[3][3];
    tictac(){
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3; j++){
                arr[i][j] = 0;
            }
        }
    }
    public char printing(int a){
        if(a == 0){return '_';}
        if(a == 1){return 'X';}
        return 'O';
    }
    public void makeScreen(){
        System.out.println("\t \t1   2   3");
        for(int i = 0; i<3; i++){
            System.out.println("\t"+(i+1)+"\t"+printing(arr[i][0]) +" | "+printing(arr[i][1]) + " | " + printing(arr[i][2]));
        }
    }//prints the current status of gameboard
    public int gameStatus(){
        for(int i =0; i<3; i++){
            if(arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2])return arr[i][0];

            if(arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i])return arr[0][i];
        }

        if(arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2])return arr[1][1];

        if(arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0])return arr[1][1];
        
        return 0; //not finished
    } // return 0 if game is not over

    public void computerPlay(){
        int x = (int)Math.round(Math.random() * 2);
        int y = (int)Math.round(Math.random() * 2);
        if(arr[x][y] != 0) computerPlay();
        else{
            arr[x][y] = 2;
        }
    }
    public static void main(String[] args){
        tictac obj = new tictac();
        Scanner sc = new Scanner(System.in);
        obj.makeScreen();
        while(obj.gameStatus() == 0){
            while(true){
                System.out.println("Enter cordinates of move");
                System.out.println("x(1 -3) y(1- 3)");
                int x = sc.nextInt();
                int y = sc.nextInt();
                x--;y--;
                if(x<=2 && x >=0&& y>=0 && y<=2){
                    obj.arr[x][y] = 1;
                    break;}
                if(obj.arr[x][y] != 0){
                    System.out.println("Coordinate is already occupied!");
                    continue;
                }
                System.out.println("Invalid coordinates!");
            } //Input the coordinates in x and y. Zero Indexed

            
            obj.makeScreen();

            if(obj.gameStatus()!=0)break;
            System.out.print("Computer is thinking");

            for(int i = 0; i<1000000000; i++){
                if(i%300000000 == 0){System.out.print(".");}
            } //create a pause
            System.out.println();

            obj.computerPlay();

            obj.makeScreen();
        }

        if(obj.gameStatus() ==1){
            System.out.println("X won!!");
        }
        else{
            System.out.println("O won! Better luck next time!");
        }
        sc.close();
    }
}