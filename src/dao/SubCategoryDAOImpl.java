package dao;

import model.SubCategory;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryDAOImpl implements SubCategoryDAO {
    private List<SubCategory> subCategories = new ArrayList<>();

    @Override
    public void addSubCategory(SubCategory subCategory) {
        subCategories.add(subCategory);
    }

    @Override
    public SubCategory getSubCategoryById(int id) {
        return subCategories.stream()
                .filter(subCategory -> subCategory.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<SubCategory> getAllSubCategories() {
        return new ArrayList<>(subCategories);
    }

    @Override
    public void updateSubCategory(SubCategory subCategory) {
        for (int i = 0; i < subCategories.size(); i++) {
            if (subCategories.get(i).getId() == subCategory.getId()) {
                subCategories.set(i, subCategory);
                return;
            }
        }
    }

    @Override
    public void deleteSubCategory(int id) {
        subCategories.removeIf(subCategory -> subCategory.getId() == id);
    }
}
