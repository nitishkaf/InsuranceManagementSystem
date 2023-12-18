package dao;

import model.SubCategory;
import java.util.List;

public interface SubCategoryDAO {
    void addSubCategory(SubCategory subCategory);
    SubCategory getSubCategoryById(int id);
    List<SubCategory> getAllSubCategories();
    void updateSubCategory(SubCategory subCategory);
    void deleteSubCategory(int id);
}
