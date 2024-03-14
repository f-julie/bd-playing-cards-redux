package com.frank;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class ItalianPlayingCard extends PlayingCard {
	
	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "Joker";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 0;

	private static Map<String,  String> suitMap  = new HashMap<String , String>();
	private static Map<Integer, String> valueMap = new TreeMap<Integer, String>();
	
	static {
		initializeMaps();
	}
	
	public ItalianPlayingCard() 
	{
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);
	} 

	public ItalianPlayingCard(int value, String suit) {
		super(value,                                                        // Call super ctor with value passed
			  suitMap.containsKey(suit) ? suit : DEFAULTSUIT,               // If valid suit passed, use it otherwise use DEFAULTSUIT
			  suitMap.get(suit) != null ? suitMap.get(suit) : DEFAULTCOLOR);// If valid suit passed, use color for suit otherwise use DEFAULTCOLOR  
			
		if (value > MAXVALUE) {
			setValue(MAXVALUE);
		}
		if (value < MINVALUE) {
			setValue(MINVALUE);
		}
		if (value > 7 && value < 10) {   // Italian Playing cards have no 8 or 9
			setValue(MINVALUE);
		}
		
	}
		
	static private void initializeMaps() {
		suitMap.put("COINS"    , "YELLOW");
		suitMap.put("CUPS"     , "BLUE");
		suitMap.put("SWORDS"   , "RED");
		suitMap.put("BATONS"   , "BLACK");
		suitMap.put(DEFAULTSUIT, DEFAULTCOLOR);
		
		valueMap.put(0,"Joker");
		valueMap.put(1,"One");
		valueMap.put(2,"Two");
		valueMap.put(3,"Three");
		valueMap.put(4,"Four");
		valueMap.put(5,"Five");
		valueMap.put(6,"Six");
		valueMap.put(7,"Seven");
		valueMap.put(10,"Ten");
		valueMap.put(11,"Fante");
		valueMap.put(12,"Cavallo");
		valueMap.put(13,"Re");
	}
	
	@Override
	public String toString() {
		return "ItalianPlayingCard: " 
	          +"Value: "    + valueMap.get(getValue())
	          +" - Color: " + suitMap.get(getSuit()) 
			  +" - Suit: "  + getSuit()
			  +" - super.toString()=" + super.toString() + "\n";
	}

    // this. reference the object used to invoke the method (this.toString() - this class's toString()
	public void showCard() {
		System.out.println(this.toString());
	}

	// generate a random PlayingCard (super class for all our Playing cards iun this application)
	// because this method is static we can use the class name to invoke or an object of the class
	public static PlayingCard pickACard() {
		Random aRandomObject = new Random();

		// Convert the suitMap to an array so we can pick a suit with a random index
		String[] suits =  suitMap.keySet().toArray(new String[suitMap.size()]);

		int newCardVaue = (aRandomObject.nextInt(13 - 1 + 1) + 1);

//      Display suit to see if code actuall generated a random suit
//		System.out.println("Suit picked: " + aRandomObject.nextInt((((suits.length-1)+1)-1)));

		// Pick a suit form the array created above using a random index
		//                        RandomClassObj.nextInt( (max-min)+1) - min
		String newCardSuit = suits[aRandomObject.nextInt(((suits.length-1)+1))]; //  (since smallest index is 0, no need to +1 and - min
		return new ItalianPlayingCard(newCardVaue, newCardSuit );
	}
}

