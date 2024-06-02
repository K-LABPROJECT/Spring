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
    private String recipeName;

    @Column(name = "recipe_detail", length = 3000)
    private String recipeDetail;

    @Column(name = "recipe_ingredient", length = 1000)
    private String recipeIngredient;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    public Recipe() {
    }

    public Recipe(String recipeName, String recipeDetail, String recipeIngredient) {
        this(recipeName, recipeDetail, recipeIngredient,null);
    }

    public Recipe(String recipeName, String recipeDetail, String recipeIngredient,Long restaurantId) {
        validateRecipename(recipeName);
        validateRecipedetail(recipeDetail);
        validateRecipeingredient(recipeIngredient);
        this.recipeName = recipeName;
        this.recipeDetail = recipeDetail;
        this.recipeIngredient = recipeIngredient;
        this.restaurantId = restaurantId;
    }

    private void validateRecipename(String recipeName) {
        if (recipeName.isBlank()) {
            throw new IllegalArgumentException("레시피 이름은 공백일 수 없습니다.");
        }
    }

    private void validateRecipedetail(String recipeDetail) {
        if (recipeDetail.isBlank()) {
            throw new IllegalArgumentException("레시피 내용은 공백일 수 없습니다.");
        }
    }

    private void validateRecipeingredient(String recipeingredient) {
        if(recipeingredient.isBlank()) {
            throw new IllegalArgumentException("레시피 재료는 공란일 수 없습니다.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeIngredient() {return recipeIngredient; }

    public String getRecipeDetail() {
        return recipeDetail;
    }

}
