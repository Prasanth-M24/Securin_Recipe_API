package com.example.recipe.controller;

import com.example.recipe.entity.Recipe;
import com.example.recipe.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("")
public class RecipeController {

    @Autowired
    private RecipeRepo repo;

    @PostMapping("/upload")
    public String uploadRecipe(@RequestParam("file") MultipartFile file) {
        try {

            ObjectMapper mapper = new ObjectMapper();

            Map<String, Recipe> recipeMap = mapper.readValue(
                    file.getInputStream(),
                    new TypeReference<Map<String, Recipe>>() {}
            );

            for (Recipe recipe : recipeMap.values()) {

                if (recipe.getPrep_time() != null && recipe.getCook_time() != null) {
                    recipe.setTotal_time(
                            recipe.getPrep_time() + recipe.getCook_time()
                    );
                }

                repo.save(recipe);
            }

            return "File uploaded successfully";

        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to upload file";
        }
    }

    @PostMapping("/recipe")
    public String addRecipe(@RequestBody Recipe recipe) {

        try {

            if (recipe.getPrep_time() != null && recipe.getCook_time() != null) {
                recipe.setTotal_time(
                        recipe.getPrep_time() + recipe.getCook_time()
                );
            }

            repo.save(recipe);

            return "Recipe added successfully";

        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to add recipe";
        }
    }

    @GetMapping("/recipes/top")
    public List<Recipe> getTopRecipes(@RequestParam(value = "limit") int limit){
        Pageable pageable = PageRequest.of(0, limit, Sort.by("rating").descending());
        return repo.findAll(pageable).getContent();
    }
}
