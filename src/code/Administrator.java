package code;

import java.util.*;

public class Administrator {
	
	private int id;
	ArrayList<Category> categories;

	public Administrator(int id) {
		super();
		this.id = id;
	}
	
	public void addCategory(String name) {
		categories.add(new Category(name));
	}
	
	public void editCategory(Category category, String name) {
		category.name = name;
	}
	
	public void removeCategory(Category category) {
		categories.remove(category);
	}
}
