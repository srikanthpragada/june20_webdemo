package rs;

public class Job {
	private String id, title;
	private int minSal, maxSal;

	public Job() {
		super();
	}

	public Job(String id, String title, int minSal, int maxSal) {
		super();
		this.id = id;
		this.title = title;
		this.minSal = minSal;
		this.maxSal = maxSal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinSal() {
		return minSal;
	}

	public void setMinSal(int minSal) {
		this.minSal = minSal;
	}

	public int getMaxSal() {
		return maxSal;
	}

	public void setMaxSal(int maxSal) {
		this.maxSal = maxSal;
	}

}
