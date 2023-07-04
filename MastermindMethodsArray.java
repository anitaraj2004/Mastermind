package Arrays;

import java.util.Random;

import TurtleGraphics.KeyboardReader;

public class MastermindMethodsArray 
{
	public void MastermindGame(int numpegs, int numcolors)
	{
		Random generator = new Random();
		KeyboardReader reader= new KeyboardReader();

		int pegscorrect=0;
		int colorscorrect=0;
		int repeatcolorindex=0;
		int validguess;
		int correctguesses=0;
		
		int pegsanswer[] = new int[numpegs];
		int guess[] = new int[numpegs];
		int repeatingcolors[] = new int [10];
		int repeatcounter=0;
		int guesscounter=0;

		// generate secret code
		for (int i=0; i<numpegs; i++)
		{
			pegsanswer[i]=generator.nextInt(numcolors)+1;
		}

		// as long as user does not guess all the pegs correctly
		while(pegscorrect!=numpegs) 
		{
			// reset variable for each run
			pegscorrect=0;
			colorscorrect=0;
			repeatcolorindex=0;
			repeatcounter=0;
			
			// print out the secret code for testing purposes
			for (int i=0; i<numpegs; i++)
			{
				System.out.println(pegsanswer[i]);
			}

			// create a temporary array
			int store[] = new int[numpegs];
			// store the secret code in the temporary array
			// fill the array of repeating colors with zeroes (empty sets)
			for (int i=0; i<numpegs; i++) 
			{
				store[i]=pegsanswer[i];
				repeatingcolors[i]=0;
			}

			// collect user guesses
			for (int i=0; i<numpegs; i++) 
			{
				System.out.println("Peg #"+(i+1)+" Guess: ");
				validguess=reader.readInt();

				while((validguess<1) || (validguess>numcolors)) 
				{
					System.out.println("Invalid color guessed, enter another color (1-"+numcolors+")");
					validguess=reader.readInt();
				}

				guess[i]=validguess;
			}

			// increase user attempts
			guesscounter++;

			// if user guess matches secret code with position
			for (int i=0; i<numpegs; i++) 
			{
				if(guess[i]==pegsanswer[i]) 
				{
					pegscorrect++;
					colorscorrect++;
					guess[i]=-1;
					store[i]=0;
				}
			}

			for (int i=0; i<numpegs; i++) 
			{
				int tmpColor=0;

				// go through store array
				for(int y=0; y<numpegs; y++) 
				{
					// check for repeating colors
					if(guess[i]==store[y]) 
					{
						tmpColor=1;
						store[y]=0;
					}
				}

				// determine the total colors correct
				colorscorrect+=tmpColor;
			}

			// if user wins game
			if(pegscorrect==numpegs) 
			{
				System.out.println("Correct! You guessed the secret code! It took you "+guesscounter+" guess(es)");
				System.out.println();
			}

			// if user loses this attempt
			else
			{
				System.out.println("You have "+pegscorrect+" correct peg(s) and "+colorscorrect+" correct color(s).");
				System.out.println();
			}
		}
	}
}