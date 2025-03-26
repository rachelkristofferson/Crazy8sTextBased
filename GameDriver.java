import java.util.*;
public class GameDriver 
{
	public static void main(String[] args) 
	{
		
			int NumberOfPlayers = 0;
			System.out.println("How many bots?  (Between 0 and 1)");
			Scanner numplays = new Scanner(System.in);
			NumberOfPlayers = numplays.nextInt();
			
			
			if (NumberOfPlayers == 0)
			{
				Player p1 = new Player();
				System.out.println("Pass the computer to player 2");
				Player p2 = new Player();
				DeckOfCards deck = new DeckOfCards(1);
				deck.shuffle();
				deck.dealOut(p1, p2);
				p1.sortHand();
				p2.sortHand();
				deck.playFirst();
////Player 1 turn////
				while ((p1.getHand()[0] != null) && (p2.getHand()[0] != null))
					{
					System.out.println("Pass the computer to " + p1.getName());
					
						System.out.println("Press 1 to show your hand");
						NumberOfPlayers = numplays.nextInt();

						if (NumberOfPlayers == 1)
						{
							System.out.println(p1);
						}
						
					System.out.println("Top card: " + deck.getPile()[deck.getPileNumber() - 1]);
					System.out.println("Do you want to pass or play or draw?  (1 for pass, 2 for play, and 3 for draw)");
					NumberOfPlayers = numplays.nextInt();
					boolean turnover = false;
					while (turnover == false)
					{
						if ((NumberOfPlayers != 1) && (NumberOfPlayers != 2) && (NumberOfPlayers != 3))
						{
							System.out.println(p1);
							System.out.println("Press 1 for pass, 2 for play, and 3 for draw");
							NumberOfPlayers = numplays.nextInt();
						}
						else if (NumberOfPlayers == 3)//If you choose to draw
						{
							if(p1.getNumCards() < p1.getMaxCards()){
								p1.getHand()[p1.getNumCards()] = deck.deal();
								p1.setNumCards(p1.getNumCards() + 1);
								break;
							}
							p1.sortHand();
							System.out.println(p1);
							System.out.println("Press 1 for pass, 2 for play, and 3 for draw");
							NumberOfPlayers = numplays.nextInt();
						}
					
						else if (NumberOfPlayers == 2)//If you choose to play
						{
							while (turnover == false)
							{
							System.out.println("Top card: " + deck.getPile()[deck.getPileNumber()-1]);
							System.out.println(p1);
							System.out.println("Which card do you want to play? (Indexes begin at 1)");
							NumberOfPlayers = numplays.nextInt() - 1;
					
						
						if ((p1.getHand()[NumberOfPlayers].getSuit().equals(deck.getPile()[deck.getPileNumber() -1].getSuit())) || (p1.getHand()[NumberOfPlayers].getValue()==(deck.getPile()[deck.getPileNumber()-1].getValue())) || (p1.getHand()[NumberOfPlayers].getValue()==(8)))
						{
							if (p1.getHand()[NumberOfPlayers].getValue() == 8)
							{
								int save = NumberOfPlayers; 
								System.out.println("Which suit do you want your wild card to be?  (1 for Hearts, 2 for Spades, 3 for Clubs, and 4 for Diamonds)");
								NumberOfPlayers = numplays.nextInt();
								boolean wild = false;
								while(wild == false)
								{
								if (NumberOfPlayers == 1)
								{
									deck.play(p1, save, p1.getHand());
									deck.getPile()[deck.getPileNumber() - 1].setSuit(Suit.Hearts);
									turnover = true;
									wild = true;
									deck.getPile()[deck.getPileNumber() - 1].setValue(8);
								
								}
								else if (NumberOfPlayers == 2)
								{
									deck.play(p1, save, p1.getHand());
									deck.getPile()[deck.getPileNumber() - 1].setSuit(Suit.Spades);	
									turnover = true;
									wild = true;
									deck.getPile()[deck.getPileNumber() - 1].setValue(8);
									
								}
								else if (NumberOfPlayers == 3)	
								{
									deck.play(p1, save, p1.getHand());
									deck.getPile()[deck.getPileNumber() - 1].setSuit(Suit.Clubs);
									turnover = true;
									wild = true;
									deck.getPile()[deck.getPileNumber() - 1].setValue(8);
								
								}
								else if (NumberOfPlayers == 4)	
								{
									deck.play(p1, save, p1.getHand());
									deck.getPile()[deck.getPileNumber() - 1].setSuit(Suit.Diamonds);	
									turnover = true;
									wild = true;
									deck.getPile()[deck.getPileNumber() - 1].setValue(8);
									
								}
								else 
								{
									System.out.println("Which suit do you want your wild card to be?  (1 for Hearts, 2 for Spades, 3 for Clubs, and 4 for Diamonds)");
									NumberOfPlayers = numplays.nextInt();
								}
								}
							}
							if (NumberOfPlayers <= (p1.getNumCards() - 1) && (turnover == false))
							{
							deck.play(p1, NumberOfPlayers, p1.getHand());
							System.out.println("Top card: " + deck.getPile()[deck.getPileNumber() - 1]);
							turnover = true;
							}
							else if (turnover == false)
							{
								System.out.println("That card cannot be played");
							}
						
						}
						else
						{
							System.out.println("That card cannot be played");
						}
							}
						}
						else if (NumberOfPlayers == 1)//If you choose to pass
						{
							turnover = true;
						}
					}
////Player 2 turn////
					if (p1.getHand()[0] != null)
					{
					turnover = false;
					{
						System.out.println("Pass the computer to " + p2.getName());
						
							System.out.println("Press 1 to show your hand");
							NumberOfPlayers = numplays.nextInt();
							if (NumberOfPlayers == 1)
							{
								System.out.println(p2);
							}
							
						System.out.println("Top card: " + deck.getPile()[deck.getPileNumber() - 1]);
						System.out.println("Do you want to pass or play or draw?  (1 for pass, 2 for play, and 3 for draw)");
						NumberOfPlayers = numplays.nextInt();
						while (turnover == false)
						{
							if ((NumberOfPlayers != 1) && (NumberOfPlayers != 2) && (NumberOfPlayers != 3))
							{
								System.out.println(p2);
								System.out.println("Press 1 for pass, 2 for play, and 3 for draw");
								NumberOfPlayers = numplays.nextInt();
							}
							else if (NumberOfPlayers == 3)//If you choose to draw
							{
								if(p2.getNumCards() < p2.getMaxCards()){
									p2.getHand()[p2.getNumCards()] = deck.deal();
									p2.setNumCards(p2.getNumCards() + 1);
									break;
								}
								p2.sortHand();
								System.out.println(p2);
								System.out.println("Press 1 for pass, 2 for play, and 3 for draw");
								NumberOfPlayers = numplays.nextInt();
							}
						
							else if (NumberOfPlayers == 2)//If you choose to play
							{
								while (turnover == false)
								{
								System.out.println("Top card: " + deck.getPile()[deck.getPileNumber()-1]);
								System.out.println(p2);
								System.out.println("Which card do you want to play? (Indexes begin at 1)");
								NumberOfPlayers = numplays.nextInt() - 1;
						
							
							if ((p2.getHand()[NumberOfPlayers].getSuit().equals(deck.getPile()[deck.getPileNumber() -1].getSuit())) || (p2.getHand()[NumberOfPlayers].getValue()==(deck.getPile()[deck.getPileNumber()-1].getValue())) || (p2.getHand()[NumberOfPlayers].getValue()==(8)))
							{
								if (p2.getHand()[NumberOfPlayers].getValue() == 8)
								{
									int save = NumberOfPlayers; 
									System.out.println("Which suit do you want your wild card to be?  (1 for Hearts, 2 for Spades, 3 for Clubs, and 4 for Diamonds)");
									NumberOfPlayers = numplays.nextInt();
									boolean wild = false;
									while(wild == false)
									{
									if (NumberOfPlayers == 1)
									{
										deck.play(p2, save, p2.getHand());
										deck.getPile()[deck.getPileNumber() - 1].setSuit(Suit.Hearts);
										turnover = true;
										wild = true;
										deck.getPile()[deck.getPileNumber() - 1].setValue(8);
									
									}
									else if (NumberOfPlayers == 2)
									{
										deck.play(p2, save, p2.getHand());
										deck.getPile()[deck.getPileNumber() - 1].setSuit(Suit.Spades);	
										turnover = true;
										wild = true;
										deck.getPile()[deck.getPileNumber() - 1].setValue(8);
										
									}
									else if (NumberOfPlayers == 3)	
									{
										deck.play(p2, save, p2.getHand());
										deck.getPile()[deck.getPileNumber() - 1].setSuit(Suit.Clubs);
										turnover = true;
										wild = true;
										deck.getPile()[deck.getPileNumber() - 1].setValue(8);
									
									}
									else if (NumberOfPlayers == 4)	
									{
										deck.play(p2, save, p2.getHand());
										deck.getPile()[deck.getPileNumber() - 1].setSuit(Suit.Diamonds);	
										turnover = true;
										wild = true;
										deck.getPile()[deck.getPileNumber() - 1].setValue(8);
	
									}
									else 
									{
										System.out.println("Which suit do you want your wild card to be?  (1 for Hearts, 2 for Spades, 3 for Clubs, and 4 for Diamonds)");
										NumberOfPlayers = numplays.nextInt();
									}
									}
								}
								if (NumberOfPlayers <= (p2.getNumCards() - 1) && (turnover == false))
								{
								deck.play(p2, NumberOfPlayers, p2.getHand());
								System.out.println("Top card:" + deck.getPile()[deck.getPileNumber() - 1]);
								turnover = true;
								}
								else if (turnover == false)
								{
									System.out.println("That card cannot be played");
								}
							
							}
							else
							{
								System.out.println("That card cannot be played");
							}
							}
							}
							else if (NumberOfPlayers == 1)//If you choose to pass
							{
								turnover = true;
							}
							
						}
						turnover = false;
					}
					}
					}
			if (p1.getHand()[0] == null)
			{
				System.out.println(p1.getName() + " wins! \n" + p2.getName() + " had " + p2.getNumCards() + " cards left");		
			}
			else
			{
			System.out.println(p2.getName() + " wins! \n" + p1.getName() + " had " + p1.getNumCards() + " cards left");	
			}
			}
////////// Two Player with Bot //////////
			else if (NumberOfPlayers == 1)
			{
				Player p1 = new Player();
				Bot b1 = new Bot();
				DeckOfCards deck = new DeckOfCards();
				deck.dealOut(p1, b1);
				p1.sortHand();
				b1.sortHand();
				deck.playFirst();
				while ((p1.getHand()[0] != null) && (b1.getHand()[0] != null))
				{
				
							System.out.println("Press 1 to show your hand");
							NumberOfPlayers = numplays.nextInt();

							if (NumberOfPlayers == 1)
							{
								System.out.println(p1);
							}
							
						System.out.println("Top card: " + deck.getPile()[deck.getPileNumber() - 1]);
						System.out.println("Do you want to pass or play or draw?  (1 for pass, 2 for play, and 3 for draw)");
						NumberOfPlayers = numplays.nextInt();
						boolean turnover = false;
						while (turnover == false)
						{
							if ((NumberOfPlayers != 1) && (NumberOfPlayers != 2) && (NumberOfPlayers != 3))
							{
								System.out.println(p1);
								System.out.println("Press 1 for pass, 2 for play, and 3 for draw");
								NumberOfPlayers = numplays.nextInt();
							}
							else if (NumberOfPlayers == 3)//If you choose to draw
							{
								if(p1.getNumCards() < p1.getMaxCards()){
									p1.getHand()[p1.getNumCards()] = deck.deal();
									p1.setNumCards(p1.getNumCards() + 1);
									break;
								}
								p1.sortHand();
								System.out.println(p1);
								System.out.println("Press 1 for pass, 2 for play, and 3 for draw");
								NumberOfPlayers = numplays.nextInt();
							}
						
							else if (NumberOfPlayers == 2)//If you choose to play
							{
								while (turnover == false)
								{
								System.out.println("Top card: " + deck.getPile()[deck.getPileNumber()-1]);
								System.out.println(p1);
								System.out.println("Which card do you want to play? (Indexes begin at 1)");
								NumberOfPlayers = numplays.nextInt() - 1;
						
							
							if ((p1.getHand()[NumberOfPlayers].getSuit().equals(deck.getPile()[deck.getPileNumber() -1].getSuit())) || (p1.getHand()[NumberOfPlayers].getValue()==(deck.getPile()[deck.getPileNumber()-1].getValue())) || (p1.getHand()[NumberOfPlayers].getValue()==(8)))
							{
								if (p1.getHand()[NumberOfPlayers].getValue() == 8)
								{
									int save = NumberOfPlayers; 
									System.out.println("Which suit do you want your wild card to be?  (1 for Hearts, 2 for Spades, 3 for Clubs, and 4 for Diamonds)");
									NumberOfPlayers = numplays.nextInt();
									boolean wild = false;
									while(wild == false)
									{
									if (NumberOfPlayers == 1)
									{
										deck.play(p1, save, p1.getHand());
										deck.getPile()[deck.getPileNumber() - 1].setSuit(Suit.Hearts);
										turnover = true;
										wild = true;
										deck.getPile()[deck.getPileNumber() - 1].setValue(8);
									
									}
									else if (NumberOfPlayers == 2)
									{
										deck.play(p1, save, p1.getHand());
										deck.getPile()[deck.getPileNumber() - 1].setSuit(Suit.Spades);	
										turnover = true;
										wild = true;
										deck.getPile()[deck.getPileNumber() - 1].setValue(8);
										
									}
									else if (NumberOfPlayers == 3)	
									{
										deck.play(p1, save, p1.getHand());
										deck.getPile()[deck.getPileNumber() - 1].setSuit(Suit.Clubs);
										turnover = true;
										wild = true;
										deck.getPile()[deck.getPileNumber() - 1].setValue(8);
									
									}
									else if (NumberOfPlayers == 4)	
									{
										deck.play(p1, save, p1.getHand());
										deck.getPile()[deck.getPileNumber() - 1].setSuit(Suit.Diamonds);	
										turnover = true;
										wild = true;
										deck.getPile()[deck.getPileNumber() - 1].setValue(8);
										
									}
									else 
									{
										System.out.println("Which suit do you want your wild card to be?  (1 for Hearts, 2 for Spades, 3 for Clubs, and 4 for Diamonds)");
										NumberOfPlayers = numplays.nextInt();
									}
									}
								}
								if (NumberOfPlayers <= (p1.getNumCards() - 1) && (turnover == false))
								{
								deck.play(p1, NumberOfPlayers, p1.getHand());
								System.out.println("Top card:" + deck.getPile()[deck.getPileNumber() - 1]);
								turnover = true;
								}
								else if (turnover == false)
								{
									System.out.println("That card cannot be played");
								}
							
							}
							else
							{
								System.out.println("That card cannot be played");
							}
								}
							}
							else if (NumberOfPlayers == 1)//If you choose to pass
							{
								turnover = true;
							}
							/////////bot's turn/////////
							turnover = false;
							while (turnover == false) 
					{
							if (b1.botPlay(deck) == 14)
							{
								if (b1.getNumCards() <= 12)
								{
								b1.getHand()[b1.getNumCards()] = deck.deal();
								b1.setNumCards(b1.getNumCards() + 1);
								turnover = true;
								}
								else turnover = true;
							}
							else if (b1.getHand()[b1.botPlay(deck)].getValue() == 8)
							{
								deck.play(b1, b1.botPlay(deck), b1.getHand());
								deck.getPile()[deck.getPileNumber() - 1].setSuit(b1.prefered());
								turnover = true;
							}
							else if (b1.botPlay(deck) < 14)
							{
								deck.play(b1, b1.botPlay(deck), b1.getHand());
								turnover = true;
							}
							}
							}				
						}
			
				if (p1.getHand()[0] == null)
				{
					System.out.println( p1.getName() + " wins! \nBot had " + b1.getNumCards() + " cards left");		
				}
				else
				{
				System.out.println(b1.getName() + " (Bot) wins!");	
				}
				
			}
		
				
}//end main	
}//end class


