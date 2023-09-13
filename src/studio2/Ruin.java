package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Starting amount: $");
		double startAmount = scan.nextDouble();
		System.out.print("Win Chance (ie. 0.05 = 5%): ");
		double winChance = scan.nextDouble();
		System.out.print("Win Limit: $");
		double winLimit = scan.nextDouble();
		System.out.print("How many days will you be playing for? ");
		int totalSimulations = scan.nextInt();
		int plays = 0;
		double money = startAmount;
	
		for (int count = 1; count <= totalSimulations; count++) {
			money = startAmount;
			plays = 0;
			while (money > 0 && money < winLimit) {
				if (Math.random() < winChance) {
					// within winning range
					money++;
					plays++;
				}
				else {
					// within losing range
					money--;
					plays++;
				}
			}
			if (money == 0) {
				System.out.println("RUIN! It is day number " + count + " and you have played " + plays + " times today!");
			}
			else {
					System.out.println("WIN! It is day number " + count + " and you have played " + plays + " times today!");
			}
		}
		
		if (winChance == 0.5) {
			double ruinRate = 1-(startAmount/winLimit);
			System.out.print("Expected ruin rate: " + ruinRate*100 + "%");
		}
		else {
			double a = (1-winChance)/winChance;
			double ruinRate = ((Math.pow(a, startAmount)-(Math.pow(a, winLimit))/(1-(Math.pow(a, winLimit)))));
			System.out.print("Expected ruin rate: " + ruinRate*100 + "%");
		}
	}
}
