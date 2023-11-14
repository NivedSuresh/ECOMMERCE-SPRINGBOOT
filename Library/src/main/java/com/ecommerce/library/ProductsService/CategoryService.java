package com.ecommerce.library.ProductsService;

import com.ecommerce.library.Dtos.CategoryDto;
import com.ecommerce.library.Model.User.Category;

import java.util.List;

public interface CategoryService {

    void saveCategory(CategoryDto categoryDto);

    List<Category> findAll();

    List<Category> findAllActiveCategories();

    boolean existsById(Long id);

    void softDelete(Long id);

    void enableCategory(Long id);

    void applyDiscountForCategory(Long id, Double offPercentage);

    void resetDiscountForCategory(Long id);
}
