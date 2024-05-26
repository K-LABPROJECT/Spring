package junior_heart.diet_hub.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    @Column(name = "recipe_name")
    private String recipename;

    @Column(name = "recipe_detail")
    private String recipedetail;
    public Recipe() {
    }

    public Recipe(String recipe_name, String recipe_detail) {
        validateRecipename(recipe_name);
        validateRecipedetail(recipe_detail);
        this.recipename = recipe_name;
    }

    private void validateRecipename(String recipename) {
        if (recipename.isBlank()) {
            throw new IllegalArgumentException("레시피 이름은 공백일 수 없습니다.");
        }
    }

    private void validateRecipedetail(String recipedetail) {
        if (recipendetail.isBlank()) {
            throw new IllegalArgumentException("레시피 내용은 공백일 수 없습니다.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getRecipename() {
        return recipename;
    }

    public String getRecipedetail() {
        return recipedetail;
    }
}
