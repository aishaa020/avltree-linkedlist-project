package application;

public class TawjeheRecords implements Comparable<TawjeheRecords> {
	
	private int seatnum;
	private String branch;
	private double average;
	

	
	
	 public TawjeheRecords() {
		
	
		
	}


	public TawjeheRecords(int seatnum, String branch, double average) {
		super();
		this.seatnum = seatnum;
		this.branch = branch;
		this.average = average;
	}


	


	public int getSeatnum() {
		
		return seatnum;
	}





	public void setSeatnum(int seatnum) {
		this.seatnum = seatnum;
	}





	public String getBranch() {
		return branch;
	}





	public void setBranch(String branch) {
		this.branch = branch;
	}





	public double getAverage() {
		return average;
	}





	public void setAverage(double average) {
		this.average = average;
	}




	

	@Override
	public String toString() {
		return  " "+seatnum +" " + branch +" "+ average;
	}





	@Override
	public int compareTo(TawjeheRecords o) {
		if (this.getAverage() > o.getAverage())
	    {
	        return 1;
	    }
	    if (this.getAverage() < o.getAverage())
	    {
	        return -1;
	    }
	    else
	    {
	        return 0;
	    }
	}
	
	

}
