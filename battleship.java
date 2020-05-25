import java.util.Scanner; //import Scanner to use it

public class battleship {
    public static String[][] ocean = new String[10][10];
    public static int[] shipno = {1, 2, 3, 4, 5};
    public static int computershipnum=5;
    public static int playershipnum=5;
    public static String emptySpace = " ";
    public static Scanner input = new Scanner(System.in); //Creates a Scanner for you to use

    public static void main(String args[]) {
    gameintro(); //introduction
        oceanmap();
        playership();
        computership();
        battleround();
        gameover();
    }

    /* Game introduction */
    public static void gameintro() {
        System.out.println("Welcome to the battleship game");
        System.out.println("*******************************************************");
        System.out.println("The ocean is empty right now, please deploy your ships.");
    }

    /* Create ocean map using 2D arrays */
    public static void oceanmap() {

        System.out.println("  0123456789");
        for (int row = 0; row < ocean.length; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < ocean[row].length; col++) {
                if (ocean[row][col] == null ) {
                    ocean[row][col]= emptySpace;
                    System.out.print(ocean[row][col]);
                } else if (ocean[row][col]=="o" | ocean[row][col]=="#") {
                    System.out.print(emptySpace);
                } else {
                    System.out.print(ocean[row][col]);
                }
            }

            System.out.println("|" + row);
        }

    }
     public static void playership () {
        /* Ask user to enter in the coordinates for where to place a ship */
        for (int i = 0; i < shipno.length; i++) {
            System.out.print("Enter X coordinate for ship no." + shipno[i] + ": ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for ship no." + shipno[i] + ": ");
            int y = input.nextInt();
            ocean[x][y] = "1";
        }
        System.out.println("Your Placements");
        oceanmap();
    }

    public static void computership(){
        System.out.println("Computer's turn to deploy ships...");
        for (int i=0; i< computershipnum;){
            int x = (int) (Math.random()*10+0); //Math.random()*(max-min+1) +min
            int y = (int) (Math.random()*10+0);
            if (ocean[x][y] != "1"){
                ocean[x][y] = "#";
                i++;
            } i=i;
            }
        System.out.println("Computer deployed 5 ships.");
    }

    public static void battleround() {
        System.out.println ("Let's Begin the Battle!");
        System.out.println ("Guess the coordinates of the ships deplyed by the computer!");
        while (computershipnum > 0 && playershipnum > 0){
            playerturn();
            computerturn();
        }
    }

    public static void playerturn (){
        System.out.println("Your Turn!");
        System.out.print("Enter X coordinates of your guess: ");
        int x = input.nextInt();
        System.out.print("Enter Y coordinates of your guess: ");
        int y = input.nextInt();
        if (ocean[x][y]=="#"){
            System.out.println("Congratulations, you sunk 1 ship!");
            ocean[x][y] = "!";
            computershipnum--;
            } else if (ocean[x][y]=="1"){
                System.out.println("Oh no, you sunk your own ship!");
                ocean[x][y] = "x";
                playershipnum--;
            } else if (emptySpace.equals(ocean[x][y]) | ocean[x][y]=="o" ){
                System.out.println("You missed.");
                ocean[x][y] = "-";
            } else {
            playerturn();
            }
        oceanmap();

    }

    public static void computerturn () {
        System.out.println("Computer's Turn!");
        int x = (int) (Math.random() * 10+0); //Math.random()*(max-min+1) +min
        int y = (int) (Math.random() * 10+0);
        if (ocean[x][y] == "#") {
            System.out.println("The computer sunk one of its own ships.");
            ocean[x][y] = "!";
            computershipnum--;
        } else if (ocean[x][y] == "1") {
            System.out.println("The computer sunk your ship!");
            ocean[x][y] = "x";
            playershipnum--;
        } else if (emptySpace.equals(ocean[x][y])) {
            System.out.println("The computer missed.");
            ocean[x][y] = "o";
        } else {
            computerturn();
        }
    }

    public static void gameover(){
        oceanmap();
        if (playershipnum==0){
            System.out.println(" Computer won!");

        }else {
            System.out.println("Congratulations you won!");
        }
       // System.out.println("Type '1' to play again!");
        //if (input.nextInt()==1){

          //  main(String args[] );
        //}

    }






}



