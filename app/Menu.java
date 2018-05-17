package salesman.app;

import java.util.LinkedList;
import java.util.Scanner;

import salesman.entities.City;
import salesman.entities.Graph;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Graph gr = new Graph();

	public void start() {
		String c = "";
		while (true) {
			if (c.equals("5"))
				break;
			System.out.println("***Menu***");
			System.out.println("1. Add new city");
			System.out.println("2. Link cities");
			System.out.println("3. Display cities");
			System.out.println("4. Create route");
			System.out.println("5. Exit");
			System.out.println("Enter>");

			c = sc.nextLine();

			switch (c) {
			case "1":
				insertCity();
				break;
			case "2":
				linkCity();
				break;
			case "3":
				gr.printCities();
				break;
			case "4":
				calculateRoute();
				break;
			case "5":
				System.out.println("GoodBye");
				sc.close();
				break;

			default:
				System.out.println("Unknown");
				break;
			}
		}
	}

	private void insertCity() {
		System.out.print("City name: ");
		String cname = sc.nextLine();
		City city = new City(cname);
		System.out.println(city);
		gr.addCity(city);
	}

	private void linkCity() {
		try {
			System.out.print("First City id: ");
			int c1 = Integer.parseInt(sc.nextLine()) - 1;
			System.out.print("Second City id: ");
			int c2 = Integer.parseInt(sc.nextLine()) - 1;
			System.out.print("Distance: ");
			int d = Integer.parseInt(sc.nextLine());

			gr.linkCities(c1, c2, d);
			
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
		
	}

	private void calculateRoute() {
		try {
			System.out.print("Source City id: ");
			int c1 = Integer.parseInt(sc.nextLine()) - 1;
			System.out.print("Dest City id: ");
			int c2 = Integer.parseInt(sc.nextLine()) - 1;

			LinkedList<City> path = gr.shortestPathFromTo(c1, c2);

			int totalDist = 0;
			for (int i = 0; i < path.size(); i++) {
				System.out.println((i + 1) + ". " + path.get(i));
				if (i > 0) {
					totalDist += gr.getDistance(path.get(i), path.get(i - 1));
				}
			}
			System.out.println("Total distance = " + totalDist);
			
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
		
	}
}
