package salesman.app;

import java.util.*;

import salesman.entities.City;
import salesman.entities.Graph;
import salesman.entities.Road;

public class DijkstraAlgorithm {

	private Set<City> settledNodes;
	private Set<City> unSettledNodes;
	private Map<City, City> predecessors;
	private Map<City, Integer> distance;

	public DijkstraAlgorithm(Graph graph) {
	}

	public void execute(City source) {
		settledNodes = new HashSet<City>();
		unSettledNodes = new HashSet<City>();
		distance = new HashMap<City, Integer>();
		predecessors = new HashMap<City, City>();
		distance.put(source, 0);
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			City node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}

	private void findMinimalDistances(City node) {
		List<City> adjacentNodes = getNeighbors(node);
		for (City target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}

	}

	private int getDistance(City node, City target) {
		for (Road r : node.getRoads()) {
			if (r.getStart().equals(node) && r.getEnd().equals(target)) {
				return r.getDistance();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<City> getNeighbors(City node) {
		List<City> neighbors = new ArrayList<City>();
		for (Road r : node.getRoads()) {
			if (r.getStart().equals(node) && !isSettled(r.getEnd())) {
				neighbors.add(r.getEnd());
			}
		}
		return neighbors;
	}

	private City getMinimum(Set<City> vertexes) {
		City minimum = null;
		for (City city : vertexes) {
			if (minimum == null) {
				minimum = city;
			} else {
				if (getShortestDistance(city) < getShortestDistance(minimum)) {
					minimum = city;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(City City) {
		return settledNodes.contains(City);
	}

	private int getShortestDistance(City destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	public LinkedList<City> getPath(City target) {
		LinkedList<City> path = new LinkedList<City>();
		City step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

}