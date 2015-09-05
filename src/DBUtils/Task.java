package DBUtils;

public class Task {
	
	private String user;
	private String timestamp;
	private String state;
	private String requestcontent;
	private int price;
	private String userlocation;
	private String destination;
	
	
	public Task(){
		
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRequestcontent() {
		return requestcontent;
	}

	public void setRequestcontent(String requestcontent) {
		this.requestcontent = requestcontent;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUserlocation() {
		return userlocation;
	}

	public void setUserlocation(String userlocation) {
		this.userlocation = userlocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	
}
