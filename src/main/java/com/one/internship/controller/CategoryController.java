package com.one.internship.controller;

import com.one.internship.model.Category;
import com.one.internship.model.Note;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class CategoryController {

    List<Category> categoriesList = new ArrayList<>();

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoriesList;
    }

    @PostMapping("/categories")
    public void addCategories(@RequestBody Category category){
        category.setCategoryId((long) (categoriesList.size() + 1));
        categoriesList.add(category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteUser(@PathVariable("id") Long categoryId) {
        Iterator<Category> categoriesList = getCategories().listIterator();
        while (categoriesList.hasNext()) {
            Category category = categoriesList.next();
            if (category.getCategoryId().equals(categoryId)) {
                categoriesList.remove();
                break;
            }
        }
    }

}
