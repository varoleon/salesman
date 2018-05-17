package salesman.entities;


public class Road {
	private City start;
	private City end;
	private int distance;
	
	public Road(City start, City end, int distance) {
		super();
		this.start = start;
		this.end = end;
		this.distance = distance;
	}
	

	public City getStart() {
		return start;
	}


	public void setStart(City start) {
		this.start = start;
	}


	public City getEnd() {
		return end;
	}


	public void setEnd(City end) {
		this.end = end;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	@Override
	public String toString() {
		return "Road [start=" + start.getName() + ", end=" + end.getName() + ", distance=" + distance + "]";
	}
	
	
}
