package model;
import java.io.Serializable;

public class SerchSelect implements Serializable{
	private String keyword;
	public SerchSelect() {}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
