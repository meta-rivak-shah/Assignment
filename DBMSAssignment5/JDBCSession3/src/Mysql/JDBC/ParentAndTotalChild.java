package Mysql.JDBC;

public class ParentAndTotalChild {
	private int Total_Child;
	private String Parent;
	public ParentAndTotalChild(int total_Child, String parent) {
		this.Total_Child = total_Child;
		this.Parent = parent;
	}
	
	public int getTotal_Child() {
		return Total_Child;
	}
	
	public String getParent() {
		return Parent;
	}
}
	
