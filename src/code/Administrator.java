package code;

import java.util.*;

public class Administrator {
	
	public static int id;
	public static ArrayList<Category> categories;

	public Administrator() {
		super();
		Administrator.id++;
	}
	
	public void addCategory(String name) {
		categories.add(new Category(name));
	}
	
	public void addCategories(String... names) {
		for(String name: names) {
			categories.add(new Category(name));
		}
	}
	
	public void editCategory(Category category, String name) {
		category.name = name;
	}
	
	public void removeCategory(Category category) {
		categories.remove(category);
	}
	
	public Category getCategory(String name) {
		for(int i = 0; i <= categories.size(); i++) {
			if(categories.get(i).name == name) {
				return categories.get(i);
			}
		}
		return null;
	}
}
