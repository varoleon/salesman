package salesman.entities;

import java.util.ArrayList;
import java.util.List;


public class City {
	private static int counter=0;
	private int id;
	private String name;
	List<Road> roads = new ArrayList<Road>();
		
	public City(String name) {
		this.id = ++City.counter;
		this.name = name;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Road> getRoads() {
		return roads;
	}
	public void setRoads(List<Road> roads) {
		this.roads = roads;
	}
	
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}
	
	public void addRoad(Road r) {
		this.roads.add(r);
	}
}
