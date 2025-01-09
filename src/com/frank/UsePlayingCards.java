package com.frank;

import java.util.ArrayList;
import static java.lang.System.out;   // Explicit static import of System.out object
import static com.frank.AmericanPlayingCard.pickACard; // Static import, so we don't need class name to invoke

public class UsePlayingCards {
// This is our application program which will instantiate object and use their methods to manipulate them
// We know this is the application program because it has the main() method
// main() is always static - there can only be only main() in an application
	public static void main(String[] args) {

		AmericanPlayingCard aUSACard = new AmericanPlayingCard(1, "HEARTS");
//       class.object - out is a static object in the class System
		System.out.println("aUSACard is :");
		aUSACard.showCard();  // runs the AmericanPlayingCard showCard()

		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES");
// Because System out object was statically imported, the System. (classname) is optional
		out.println("aUSACard2 is :");
		aUSACard2.showCard();

		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES");
		System.out.println("aUSACard3 is :");
		aUSACard3.showCard();

		AmericanPlayingCard aUSACard4 = new AmericanPlayingCard(11, "John");
		System.out.println("aUSACard4 is :");
		aUSACard4.showCard();

		ItalianPlayingCard anItalianCard1 = new ItalianPlayingCard(13, "SWORDS");
		System.out.println("anItalianCard1 is :");
		anItalianCard1.showCard();  // Runs the ItalianPlayingCard showCard()

		ItalianPlayingCard anItalianCard2 = new ItalianPlayingCard(9, "COINS");
		System.out.println("anItalianCard2 is :");
		anItalianCard2.showCard();

		ItalianPlayingCard anItalianCard3 = new ItalianPlayingCard(11, "Daniel");
		System.out.println("anItalianCard3 is :");
		anItalianCard3.showCard();

		SwissPlayingCard aSwissCard1 = new SwissPlayingCard(13, "ROSES");
		System.out.println("aSwissCard1 is :");
		aSwissCard1.showCard();  // Runs the SwissPlayingCard showCard()

		SwissPlayingCard aSwissCard2 = new SwissPlayingCard(1, "SHIELDS");
		System.out.println("aSwissCard2 is :");
		aSwissCard2.showCard();

		SwissPlayingCard aSwissCard3 = new SwissPlayingCard(10, "ACORNS");
		System.out.println("anSwissCard3 is :");
		aSwissCard3.showCard();

		SwissPlayingCard aSwissCard4 = new SwissPlayingCard(11, "John");
		System.out.println("anSwissCard4 is :");
		aSwissCard4.showCard();

		System.out.println("\n--------- Polymorphism examples start here ---------------------------");

		PlayingCard aCard; // Define a reference to an object of the super class

		aCard = aUSACard;  // Assign a sub class object to the super class object
		aCard.showCard();  // Use the super class to invoke a method - run the showCard() method of the object IN aCard

		aCard = anItalianCard1;  // Assign a subclass object to the super class object
		aCard.showCard();        // Use the super class to invoke a method - run the showCard() method of the object IN aCard

		aCard = aSwissCard1;  // Assign a sub class object to the super class object
		aCard.showCard();     // Use the super class to invoke a method - run the showCard() method of the object IN aCard

ArrayList<PlayingCard> myCards = new ArrayList();  // Defined an ArrayList of super class objects

		myCards.add(anItalianCard1);  // add sub class object to my ArrayList of super class objects
		myCards.add(aUSACard);        // add sub class object to my ArrayList of super class objects
		myCards.add(aSwissCard1);     // add sub class object to my ArrayList of super class objects
		myCards.add(aUSACard2);       // add sub class object to my ArrayList of super class objects

		System.out.println("\n ---- Here come the elements from ArrayList ------\n");

// Display all the objects in my ArrayList - Polymorphism will cause the correct showCard() for the element to be run
        for(PlayingCard theCard : myCards) { // Define a super class object as element in the for each
        	theCard.showCard();              // Use the element in the for each to invoke the methos
		}

		System.out.println("\n ---- Using a function to display a card ------\n");
        displayCard(aSwissCard3);      // call the function to display our card
        displayCard(anItalianCard2);   // call the function to display our card

		System.out.println("\n---------Call static pickACard() method  ---------------------------");
		displayCard(AmericanPlayingCard.pickACard());  // use the class name to call a static method in the class

		// If an object of a class is used to call a non-static method, the data in the object IS used by the method
		// If an object of a class is used to call a static method, the data in the object is NOT used by the method
		displayCard(aUSACard2.pickACard());            // Use an object of the class to call a static method in the class
		displayCard(ItalianPlayingCard.pickACard());   // Use the class name to call a static method in the class
		displayCard(pickACard());                      // Only need the method name if static import is used for the method

	}  // End of main()

	// Helper methods are coded after the method/process they're helping
	// This must be static because what calls it is static
	static void displayCard(PlayingCard cardyMcCardCard) {  // a function receives a super class object
		cardyMcCardCard.showCard();  // use the super class object to run a method - Polymorphism will run the correct method
	}

}  // End of class that holds main()
