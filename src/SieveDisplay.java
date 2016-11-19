import java.awt.Color;
import java.awt.Font;
import java.util .Scanner;
import javax.swing.JOptionPane;

public class SieveDisplay {

	public static final Color  RED     		  = new Color(255,0,0);
	public static final Color  GREEN     	  = new Color(0,255,0);
	public static final Color  BLUE     	  = new Color(0,0,255);
	public static final Color  YELLOW     	  = new Color(252,252,3);
	public static final Color  CYAN           = new Color(3,252,246);
	public static final Color  ORANGE         = new Color(252,124,3);
	public static final Color  LIGHT_RED      = new Color(245,101,111);
	public static final Color  LIGHT_GREEN    = new Color(129,245,162);
	public static final Color  LIGHT_BLUE     = new Color(129,154,245);
	public static final Color  LIGHT_YELLOW   = new Color(245,241,129);
	public static final Color  PRIME_PINK     = new Color(231,96,250);
	public static final Color  LIGHT_CYAN     = new Color(96,250,218);
	public static final Color  LIGHT_ORANGE   = new Color(250,171,96);
	public static final Color  LIGHT_GRAY 	  = Color.LIGHT_GRAY;
	public static final Color  BLACK          = new Color(0);
	public static final int	   SCREEN_WIDTH   = 400;
	public static final double BOX_WIDTH 	  = .03;
	public static final double AMOUNT_OF_SCREEN_FOR_BOXES = .7;
	public static final double PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO = 10;

	
	public static double determineHalfBoxHeight(int number)
	{
		double halfBoxHeight = .3;
		if(number>10){halfBoxHeight = .2;}
		if(number>20){halfBoxHeight = .13;}
		if(number>30){halfBoxHeight = .1;}
		if(number>40){halfBoxHeight = .08;}
		if(number>50){halfBoxHeight = .065;}
		if(number>60){halfBoxHeight = .055;}
		if(number>70){halfBoxHeight = .05;}
		if(number>80){halfBoxHeight = .045;}
		if(number>90){halfBoxHeight = .04;}
		if(number>100){halfBoxHeight = .035;}
		if(number>120){halfBoxHeight = .03;}
		if(number>150){halfBoxHeight = .025;}
		if(number>160){halfBoxHeight = .02;}
		if(number>230){halfBoxHeight = .01;}
		if(number>400){halfBoxHeight = .005;}
		return halfBoxHeight;
	}
	
	public static void printNumbers(int[] numbersList)
	{
		int numberPositionFromTop = 1;
		int positionOfNumberInRow = 1; 
		double halfBoxHeight = determineHalfBoxHeight(numbersList.length);
		for(int i=0; i < numbersList.length; i++)
		{
			if (numbersList[i] != 0)
			{
				StdDraw.show(600);
				StdDraw.setPenColor(PRIME_PINK);
				StdDraw.filledRectangle(AMOUNT_OF_SCREEN_FOR_BOXES*(i%10+.5)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO,
						1-(i/10+.5)/((numbersList.length+9)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO),BOX_WIDTH,halfBoxHeight);
				StdDraw.setPenColor(BLACK);
				StdDraw.text(AMOUNT_OF_SCREEN_FOR_BOXES*(i%10+.5)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO,
						1-(i/10+.5)/((numbersList.length+9)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO),  "" + numbersList[i] );
				StdDraw.text(AMOUNT_OF_SCREEN_FOR_BOXES*(positionOfNumberInRow+9.5)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO,
						1-(numberPositionFromTop+.5)/((numbersList.length+9)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO), "" + numbersList[i] );
				positionOfNumberInRow += 1;
				if(positionOfNumberInRow >= 6)
				{
					positionOfNumberInRow = 1;
					numberPositionFromTop += 1;
				}
			}
		}
		StdDraw.show(0);
	}

	public static void markOffMultiples(int[] list, int number)
	{
		double halfBoxHeight = determineHalfBoxHeight(list.length);
		for(int i =number+number; number*number < list.length+1 && i-1 < list.length; i=i+number)
		{
			switch (number)
			{
			case 2:
				StdDraw.setPenColor(RED);
				break;
			case 3:
				StdDraw.setPenColor(GREEN);
				break;
			case 5:
				StdDraw.setPenColor(BLUE);
				break;
			case 7:
				StdDraw.setPenColor(YELLOW);
				break;
			case 11:
				StdDraw.setPenColor(CYAN);
				break;
			default:
				StdDraw.setPenColor(ORANGE);
				break;
			}
			StdDraw.filledRectangle(AMOUNT_OF_SCREEN_FOR_BOXES*(number%10-.5)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO,
					1-(number/10+.5)/((list.length+9)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO),BOX_WIDTH,halfBoxHeight);
			StdDraw.setPenColor(BLACK);
			StdDraw.text(AMOUNT_OF_SCREEN_FOR_BOXES*(number%10-.5)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO,
					1-(number/10+.5)/((list.length +9)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO),  "" + number );
	
			list[i-1] = 0;
			switch (number)
			{
			case 2:
				StdDraw.setPenColor(LIGHT_RED);
				break;
			case 3:
				StdDraw.setPenColor(LIGHT_GREEN);
				break;
			case 5:
				StdDraw.setPenColor(LIGHT_BLUE);
				break;
			case 7:
				StdDraw.setPenColor(LIGHT_YELLOW);
				break;
			case 11:
				StdDraw.setPenColor(LIGHT_CYAN);
				break;
			default:
				StdDraw.setPenColor(LIGHT_ORANGE);
				break;
			}
			StdDraw.show(100);
			if(i%10 !=0)
			{
				StdDraw.filledRectangle(AMOUNT_OF_SCREEN_FOR_BOXES*(i%10-.5)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO,
						1-(i/10+.5)/((list.length+9)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO),BOX_WIDTH,halfBoxHeight);
				StdDraw.setPenColor(BLACK);
				StdDraw.text(AMOUNT_OF_SCREEN_FOR_BOXES*(i%10-.5)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO,
						1-(i/10+.5)/((list.length +9)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO),  "" + i );
			}
			else
			{
				StdDraw.filledRectangle(AMOUNT_OF_SCREEN_FOR_BOXES*(((i-1)%10)+.5)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO,
						1-((i/10-.5)/((list.length+9)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO)),BOX_WIDTH,halfBoxHeight);
				StdDraw.setPenColor(BLACK);
				StdDraw.text(AMOUNT_OF_SCREEN_FOR_BOXES*(((i-1)%10)+.5)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO,
						1-((i/10-.5)/((list.length+9)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO)),  "" + i );
			}
		}
	}

	public static void findPrimes(int[] list)
	{
		for(int i=0; i < list.length; i++)
		{
			if(list[i] != 0)
			{
				markOffMultiples(list, list[i]);
			}
		}
		//The list now only contains Primes and Zeros.
	}
	
	public static void main(String[] args) 
	{
		try
		{
			//GETTING INPUT
			boolean oneNumberInputted = false;
			int number = 0;
			do
			{
				String numberInput = JOptionPane.showInputDialog("What number would you like the prime numbers up to?");
				Scanner numberScanner = new Scanner(numberInput);
				if (numberScanner.hasNextInt())
				{
					number = numberScanner.nextInt();
					if(numberScanner.hasNextInt())
					{
						JOptionPane.showMessageDialog(null, "Please only enter one number.");
					}
					else
					{
						oneNumberInputted = true;
						numberScanner.close();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No number was entered.");
				}
			}while (oneNumberInputted != true);
			
			//MAKING ARRAY OF NUMBERS BELOW INPUT
			int[] numberList = new int[number];
			for(int k=1;k<number+1;k++)
			{
				numberList[k-1] = k;
			}
			numberList[0] = 0;

			//SETTING UP CANVAS
			int screenY = (number+9)/10*33;			
			StdDraw.setCanvasSize(SCREEN_WIDTH, screenY);
			Font textFont = new Font("SansSerif", Font.PLAIN, 10);
			StdDraw.setFont(textFont);
			StdDraw.setPenColor(BLACK);
			StdDraw.text(0.826,  1-.5/((number+9)/10), "Prime Numbers:" );
			
			//DRAWING NUMBERS+BOXES
			double halfBoxHeight = determineHalfBoxHeight(number);
			String numberString;
			int numberToDisplay = 0;
			for(int j=0; j < (number+10)/10; j+= 1)
			{
				for(int i=0; i < 10; i+= 1)
				{
					if(numberToDisplay<numberList.length)
					{
						numberString ="" + (numberList[numberToDisplay]);
						if(numberList[numberToDisplay] != 0)
						{
							StdDraw.setPenColor(LIGHT_GRAY);
							StdDraw.filledRectangle(AMOUNT_OF_SCREEN_FOR_BOXES*(i+.5)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO,
									1-(j+.5)/((number+9)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO),BOX_WIDTH, halfBoxHeight);
							StdDraw.setPenColor(BLACK);
							StdDraw.text(AMOUNT_OF_SCREEN_FOR_BOXES*(i+.5)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO,
									1-(j+.5)/((number+9)/PARTS_BOX_SIDE_H_AND_W_TO_BE_DIVIDED_INTO), numberString );
						}
						numberToDisplay +=1;
					}
				}
			}
			findPrimes(numberList);
			printNumbers(numberList);
		}
		catch(java.lang.NullPointerException exception)
		{
		}
	}
}
