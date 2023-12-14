package dao;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private List<Category> categories = new ArrayList<>();
    @Override
    public void addCategory(Category category){
        categories.add(category);
    }
    @Override
    public Category getCategoryById(int id) {
        return categories.stream()
                .filter(category -> category.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>(categories);
    }
    @Override
    public void updateCategory(Category category) {
        // Find the category with the same ID and update it
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == category.getId()) {
                categories.set(i, category);
                return;
            }
        }
    }
    @Override
    public void deleteCategory(int id) {
        categories.removeIf(category -> category.getId() == id);
    }
}
