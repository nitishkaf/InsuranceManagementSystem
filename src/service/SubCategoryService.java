package service;

import dao.SubCategoryDAO;
import model.SubCategory;
import java.util.List;

public class SubCategoryService {
    private SubCategoryDAO subCategoryDAO;

    public SubCategoryService(SubCategoryDAO subCategoryDAO) {
        this.subCategoryDAO = subCategoryDAO;
    }

    public void addSubCategory(SubCategory subCategory) {
        subCategoryDAO.addSubCategory(subCategory);
    }

    public SubCategory getSubCategoryById(int id) {
        return subCategoryDAO.getSubCategoryById(id);
    }

    public List<SubCategory> getAllSubCategories() {
        return subCategoryDAO.getAllSubCategories();
    }

    public void updateSubCategory(SubCategory subCategory) {
        subCategoryDAO.updateSubCategory(subCategory);
    }

    public void deleteSubCategory(int id) {
        subCategoryDAO.deleteSubCategory(id);
    }
}
