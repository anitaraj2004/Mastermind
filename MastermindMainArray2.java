package Arrays;

import TurtleGraphics.KeyboardReader;

public class MastermindMainArray2 
{

	public static void main(String[] args) 
	{
		KeyboardReader reader = new KeyboardReader();
		MastermindMethodsArray2 object = new MastermindMethodsArray2();
		int numpegs, numcolors, validnum=0;
		
		// ask to play and number of pegs to play with
		System.out.println("Welcome to Mastermind! How many pegs would you like to play with (1-10)? ");
		numpegs=reader.readInt();
		
		// if pegs is not between 1 and 10, enter a different number of pegs
		while(validnum==0)
		{
			if((numpegs<1)||(numpegs>10))
			{
				System.out.println("That is an invalid number. Please enter a different one. ");
				numpegs=reader.readInt();
			}
			else
			{
				validnum++;
			}
		}
		
		validnum=0;
		
		// ask how many colors to play with 
		System.out.println("How many colors would you like to play with (1-9)? ");
		numcolors=reader.readInt();
		
		// if color is not between 1 and 9, enter a different number of colors
		while(validnum==0)
		{
			if((numcolors<1)||(numcolors>9))
			{
				System.out.println("That is an invalid number. Please enter a different one. ");
				numcolors=reader.readInt();
			}
			else
			{
				validnum++;
			}
		}
		
		object.MastermindGame(numpegs, numcolors);
	}

}