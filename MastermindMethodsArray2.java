package Arrays;

import java.util.Arrays;

import java.util.Random;

import TurtleGraphics.KeyboardReader;

public class MastermindMethodsArray2 
{
	public void MastermindGame(int numpegs, int numcolors)
	{
		Random generator = new Random();
		
		int[] pegsarray = new int [10];
		int index, pegposition;
		
		// generate colors and place them in the peg positions
		for(index=0; index<numpegs; index++)
		{
			pegposition=generator.nextInt(numcolors)+1;
			pegsarray[index]=pegposition;
		}
		
		// check the secret code
		for(index=0; index<numpegs; index++)
		{
			System.out.println(pegsarray[index]);
		}

		ComparePegColors(pegsarray, numpegs);
	}
	
	public void ComparePegColors(int[] pegsarray, int numpegs)
	{
		KeyboardReader reader = new KeyboardReader();
		char correct='f';
		int index=0, userguess, guesscounter=0, ordercounter=0, comparecounter=0;
		int[] guessarray = new int [numpegs];
		int[] comparisonarray = new int [numpegs];
		int[] displayarray = new int [numpegs];
		int[] temp = new int [numpegs];
		
		//loop will run as long as all pegs are not guessed correctly
		while(correct=='f')
		{
			// have user enter all guesses for pegs
			index=0;
			for(int i=1; i<(numpegs+1); i++)
			{
				System.out.println("Peg "+i+" Guess: ");
				userguess=reader.readInt();
				
				guessarray[index]=userguess;
				index++;
			}
			
			guesscounter++;
			
			// compare guesses to secret code to see how much matches
			for(index=0; index<numpegs; index++)
			{
				if(pegsarray[index]==guessarray[index])
				{
					ordercounter++;
				}
			}
			
			// compare guesses to answer to see how many are similar
			int compareindex=0;
			for(index=0; index<numpegs; index++)
			{
				for(int x=0; x<numpegs; x++)
				{
					if(pegsarray[x]==guessarray[index])
					{
						comparisonarray[compareindex]=guessarray[index];
					}
				}
				
				compareindex++;
			}
			
			// sort comparison array into numerical order
			Arrays.sort(comparisonarray);
		
			// print to check comparison array after sorting
			//for(int j=0; j<numpegs; j++)
			//{
				//System.out.println(comparisonarray[j]);
			//}
					
			// create new array to store correct unique numbers (eliminate repeats)
			for(index=0; index<numpegs; index++)
			{
				if(comparisonarray[index]!=0)
				{
					displayarray[0]=comparisonarray[index];
					break;
				}
			}
			
			// add unique numbers to new array
			index=1;
			for(int x=0; x<(numpegs-1); x++)
			{
				if(comparisonarray[x]!=comparisonarray[x+1])
				{
					displayarray[index]=comparisonarray[x];
				}
				
				index++;
			}
			
			// count how many non-zero numbers are in unique correct numbers array
			for(int f=0; f<numpegs; f++)
			{
				if(displayarray[f]!=0)
				{
					comparecounter++;
				}
			}
			
			// tell user how many pegs they got correct
			System.out.println("You guessed "+ordercounter+" peg(s) correctly.");
			
			// if guess is completely correct, end game
			if(ordercounter==numpegs)
			{
				System.out.println("You have guessed the secret code correctly!");
				correct='t';
			}
			else
			{
				// tell user how many colors they got correct
				System.out.println("You guessed "+comparecounter+" color(s) correctly.");
			}
			
			// reset unique numbers array
			ordercounter=0;
			comparecounter=0;
			for(int k=0; k<numpegs; k++)
			{
				displayarray[k]=0;
			}
		}
		
		//state how many guesses this took
		System.out.println("You have broken the code in "+guesscounter+" guess(es).");
	}

}