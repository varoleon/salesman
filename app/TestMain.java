package salesman.app;

import java.util.LinkedList;

import salesman.entities.City;
import salesman.entities.Graph;

public class TestMain {
	public static void main(String[] args) {
		Graph gr = new Graph();
		gr.addCity(new City("Athens"));
		gr.addCity(new City("Corinth"));
		gr.addCity(new City("Tripolis"));
		gr.addCity(new City("Sparta"));
		gr.addCity(new City("Kalamata"));
		gr.addCity(new City("Patras"));

		gr.linkCities(0, 1, 80);
		gr.linkCities(1, 2, 79);
		gr.linkCities(1, 5, 132);
		gr.linkCities(2, 3, 50);
		gr.linkCities(2, 4, 82);
		gr.linkCities(2, 5, 169);
		gr.linkCities(3, 4, 60);
		gr.linkCities(4, 5, 216);

		LinkedList<City> path = gr.shortestPathFromTo(0, 4);
		
		int totalDist=0;
		for (int i = 0; i < path.size(); i++) {
			System.out.println((i + 1) + ". " + path.get(i));
			if (i>0) {
				totalDist+=gr.getDistance(path.get(i), path.get(i-1));
			}
		}
		System.out.println("Total distance = "+totalDist);
	}
}
