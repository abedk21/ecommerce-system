package code;

import java.util.ArrayList;

public class CategoryList {
	
	public static ArrayList<Category> categories = new ArrayList<Category>();
	
	public CategoryList() {
		super();
	}
	
	public static Category getCategory(String name) {
		for(int i = 0; i <= categories.size(); i++) {
			if(categories.get(i).name == name) {
				return categories.get(i);
			}
		}
		return null;
	}
}
