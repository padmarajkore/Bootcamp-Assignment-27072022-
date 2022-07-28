package Mankatha;

import java.util.*;
public class PlayTheGame {
	public static void main(String[] args) {
		Deck d = new Deck();
//		System.out.println(d.orderedListOfCards());
//		System.out.println(d.shuffleTheDeck());
		Scanner s = new Scanner(System.in);	
		System.out.println("Welcome to the Mankatha Game ");
		System.out.println("Enter number of players ");
		int numberOfPlayers = s.nextInt();
		Random random = new Random();
		int host = random.nextInt(1,numberOfPlayers);
		boolean canMoveForward = true;
		
		while(canMoveForward) {
			Map<Integer,Player> playerDetails = new LinkedHashMap<Integer,Player>();
			double sumOfAllBets = 0;
			System.out.println("Player "+host+" Is Host ");
			
			for(int i=1;i<=numberOfPlayers;i++) {
				if(host==i) {
					playerDetails.put(i, null);
				}else {
					System.out.println("Player "+i+" Enter your card as Rank And Suit with space separated (1-13 and 1-4)");
					int rank = s.nextInt();int suit = s.nextInt();
					Card c = new Card(rank,suit);
					System.out.println("Player "+i+" Enter Bet Value");
					double bet = s.nextDouble();
					System.out.println("Player "+i+" Enter In Or Out ");
					String chosenOrientation = s.next();
					Player p = new Player(i,bet,c,chosenOrientation);
					playerDetails.put(i, p);
					sumOfAllBets += p.getBetValue();
				}
			}
			
			System.out.println("Player "+d.deal(playerDetails)+" Is The Winner Here is Your Bet Money "+sumOfAllBets);
			System.out.println("You Are The New Host ");
			System.out.println("To Continue Enter yes   To Stop The Game Enter No");
			host = d.deal(playerDetails);
			if(!s.next().equalsIgnoreCase("YES")) {
				canMoveForward = false;
				System.out.println("Thank You For Playing");
			}	
		}
	}
}