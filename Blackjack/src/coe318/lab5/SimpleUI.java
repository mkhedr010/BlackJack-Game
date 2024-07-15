package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackJackGame game;
    private Scanner user = new Scanner(System.in);

//  @Override
  
    public void setGame(BlackJackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("*************\n");
        System.out.println(  "House Cards: " + "\n" + game.getHouseCards());        
        System.out.println( "Your Cards: " + "\n" + game.getYourCards());
    }

  @Override
    public boolean hitMe() {
                System.out.println("do you want another card? no/yes");  
                String resp = user.nextLine();
                while (!resp.equals("yes") && !resp.equals("no"))
                {                  System.out.println("Error: Answer with no/yes");  

                    resp = user.nextLine();}
if (resp.equals("yes") )
{
    return true;
}
else 
    return false;

    }

  @Override
    public void gameOver() {
        System.out.println("$$$*************$$$\n");

    System.out.println("Game Over!");
    System.out.println("House Cards: " + "\n"+ game.getHouseCards());
    System.out.println("Your Cards: "+ "\n" + game.getYourCards());
    int houseScore = game.score(game.getHouseCards());
    int yourScore = game.score(game.getYourCards());
    System.out.println("House Score: " + houseScore);
    System.out.println("Your Score: " + yourScore);

    if (yourScore > 21) {
        System.out.println(" bust! House wins!");
    } else if (houseScore > 21 || yourScore > houseScore) {
        System.out.println("You win!");
    } else if (houseScore > yourScore) {
        System.out.println("House wins!");
    } else {
        System.out.println("It's a tie!");
    }       
        
//FIX THIS
    }

}