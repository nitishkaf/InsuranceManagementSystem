package service;

import dao.CategoryDAO;
import model.Category;
import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }

    public Category getCategoryById(int id) {
        return categoryDAO.getCategoryById(id);
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    public void deleteCategory(int id) {
        categoryDAO.deleteCategory(id);
    }
}
