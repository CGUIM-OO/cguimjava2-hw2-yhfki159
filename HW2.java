
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * @author TODO: B0544108 ¨®¬R§»
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
		sc.close();
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards
	 * @param nDeck 
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank,checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: set the deck 1~4(suit) to 0~3 and the 1~13(rank) to 0~12
 */
class Deck{
	private ArrayList<Card> cards =new ArrayList<Card>();
	int nnum;
	//TODO: Please implement the constructor (30 points)
	
    public Deck(int nDeck){
        cards = new ArrayList<Card>();
        for (int a=0; a<=3; a++)
        {
            for (int b=0; b<=12; b++)
             {
               cards.add( new Card(a,b) );
             }
        }
        nnum=nDeck;
    }  
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end 

		
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		while(true){
			for (int a=0; a<=3; a++)
			{
				for (int b=0; b<=12; b++){
	        		System.out.println(new Card(a,b));
				}
	    	}
			nnum --;
			if (nnum==0)
				break;
		}
    }

	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: suit = 1~4 ; rank 1~13
 */
class Card{
	private int suit; 
	//Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; 
	//1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	private String[] cardSuit = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private String[] cardRank = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	public String toString()
    {
        String finalCard = cardSuit[suit] + "," + cardRank[rank];

        return finalCard;
    }
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		for (int a=0; a<=3; a++)
		{
			for (int b=0; b<=12; b++){
        		System.out.println(new Card(a,b));
			}
    	}
	}
	
	public int getSuit(){	
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
