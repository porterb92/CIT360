package porter.collections;

public class Orders {
	
	private int TableNum;
	private String items;
	
	public Orders(int TableNum, String items) {
		this.TableNum = TableNum;
		this.items = items;
	}
	
	public String toString() {
		return "Table: " + TableNum + "  Items: " + items;
	}
}
