package salesman.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import salesman.app.DijkstraAlgorithm;


public class Graph {
	private List<City> cities = new ArrayList<City>();
	

	public Graph() {
	}
	
	public List<City> getCities(){
		return cities;
	}

	public void addCity(City c) {
		cities.add(c);
	}

	public void printCities() {
		for (City c : cities) {
			System.out.println(c.getId() + " " + c.getName() + " road:" + c.getRoads());
		}
	}

	@Override
	public String toString() {
		return "Graph [cities=" + cities + "]";
	}

	public void linkCities(int id1, int id2, int distance) {
		City c1 = cities.get(id1);
		City c2 = cities.get(id2);
		Road r1 = new Road(c1, c2, distance);
		Road r2 = new Road(c2, c1, distance);
		c1.addRoad(r1);
		c2.addRoad(r2);
	}

	public LinkedList<City> shortestPathFromTo(int sourceId, int destId) {
		// TODO Auto-generated method stub
		City source = cities.get(sourceId);
		City dest = cities.get(destId);
		
		DijkstraAlgorithm da= new DijkstraAlgorithm(this);
		da.execute(source);
		
		return da.getPath(dest);
		
	}
	
	public int getDistance(City node, City target) {
		for (Road r : node.getRoads()) {
			if (r.getStart().equals(node) && r.getEnd().equals(target)) {
				return r.getDistance();
			}
		}
		throw new RuntimeException("Should not happen");
	}

}
