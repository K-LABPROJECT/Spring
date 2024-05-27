package junior_heart.diet_hub.service;

import junior_heart.diet_hub.domain.Recipe;
import junior_heart.diet_hub.repository.RecipeRepository;
import junior_heart.diet_hub.service.dto.RecipeFindResponse;
import junior_heart.diet_hub.service.dto.RecipeRegisterResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Transactional
    public RecipeRegisterResponse register(String recipeName, String recipeDetail, Long restaurantId) {
        Recipe recipe = recipeRepository.save(new Recipe(recipeName, recipeDetail, restaurantId));
        return new RecipeRegisterResponse(recipe.getId());
    }

    @Transactional(readOnly = true)
    public RecipeFindResponse findRecipe(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                                        .orElseThrow(() -> new IllegalStateException("해당 id의 레시피가 존재하지 않습니다. recipeId = {}" + recipeId));
        return new RecipeFindResponse(recipe.getId(), recipe.getRecipeName(), recipe.getRecipeDetail());
    }
}
