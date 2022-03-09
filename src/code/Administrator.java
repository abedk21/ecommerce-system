package code;

import java.util.*;

public class Administrator {
	
	public static int id;

	public Administrator() {
		super();
		Administrator.id++;
	}
	
	public void addCategory(String name) {
		CategoryList.categories.add(new Category(name));
	}
	
	public void addCategories(String... names) {
		for(String name: names) {
			CategoryList.categories.add(new Category(name));
		}
	}
	
	public void removeCategory(Category category) {
		CategoryList.categories.remove(category);
	}
	
}
