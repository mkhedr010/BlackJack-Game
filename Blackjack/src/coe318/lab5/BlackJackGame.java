package coe318.lab5;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class BlackJackGame {

  private CardPile deck;
  private CardPile houseCards;
  private CardPile yourCards;
  private boolean houseDone;
  private boolean playerDone;
  private UserInterface ui;

  public BlackJackGame(UserInterface ui) {
    this.ui = ui;
    ui.setGame(this);
    deck = new CardPile();
    for (int i = 2; i < 15; i++) {
      for (int j = 0; j < 4; j++) {
        deck.add(new Card(i, j, true));
      }
    }
    houseCards = new CardPile();
    yourCards = new CardPile();
    houseDone = false;
    playerDone = false;
  }

  public void start() {
    Card c;
    c = deck.removeRandom();
    c.setFaceUp(false);
    getHouseCards().add(c);
    getHouseCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    ui.display();
  }

  public void play() {
    while (!houseDone || !playerDone) {
         ui.display();
      if (!houseDone) {
        if (score(getHouseCards()) <= 17) {
          getHouseCards().add(deck.removeRandom());
        //  ui.display();
        } else {
          houseDone = true;
        }
      }
      if (!playerDone) {
        if (ui.hitMe()) {
          getYourCards().add(deck.removeRandom());
        // ui.display();
        } else {
          playerDone = true;
        }
      }
    }
  }

  public void end() {
    getHouseCards().getCards().get(0).setFaceUp(true);
    ui.gameOver();
  }

  /**
   * Determine the score of a pile of cards.
   *
   * @param p
   * @return the score
   */
  public int score(CardPile p) {
      int scr = 0;
    for (int i = 0 ; i < p.getCards().size(); i++)
    {  if (p.getCards().get(i).getRank()< 11 )
    {   scr = scr + p.getCards().get(i).getRank();}
    else if (p.getCards().get(i).getRank()< 14) 
    {scr = scr +10;}
    else {scr = scr +1;}
        }
             
    //FIX THIS
    return scr;
  }

  /**
   * @return the houseCards
   */
  public CardPile getHouseCards() {
    return houseCards;
  }

  /**
   * @return the yourCards
   */
  public CardPile getYourCards() {
    return yourCards;
  }
  
  public static void main(String[] args) {
    BlackJackGame game = new BlackJackGame(new SimpleUI());
    game.start();
    game.play();
    game.end();
  }
}