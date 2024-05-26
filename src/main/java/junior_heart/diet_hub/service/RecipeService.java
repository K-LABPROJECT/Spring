package junior_heart.diet_hub.service;

import junior_heart.diet_hub.domain.Recipe;
import junior_heart.diet_hub.repository.RecipeRepository;
import junior_heart.diet_hub.service.dto.RecipeRegResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeService {

    private final RecipeRepository memberRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Transactional
    public RecipeRegResponse Register(String recipename, String recipedetail) {
        Recipe recipe = recipeRepository.save(new Recipe(recipename, recipedetail));
        return new RecipeRegResponse(member.getId());
    }
}
