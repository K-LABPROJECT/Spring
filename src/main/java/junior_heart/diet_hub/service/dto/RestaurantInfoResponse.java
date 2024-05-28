package junior_heart.diet_hub.service.dto;

import java.util.List;
import java.util.stream.Collectors;
import junior_heart.diet_hub.domain.Member;
import junior_heart.diet_hub.domain.Recipe;
import junior_heart.diet_hub.domain.Restaurant;

public record RestaurantInfoResponse(Long restaurantId, String title, Long ownerId, String ownerUsername, List<RecipeSimpleInfoResponse> menus) {

    public static RestaurantInfoResponse of(Restaurant restaurant, Member member, List<Recipe> recipes) {
        return new RestaurantInfoResponse(
                restaurant.getId(),
                restaurant.getTitle(),
                member.getId(),
                member.getUsername(),
                recipes.stream().map(recipe -> new RecipeSimpleInfoResponse(recipe.getId(), recipe.getRecipeName())).collect(Collectors.toList())
        );
    }

    public record RecipeSimpleInfoResponse(Long recipeId, String recipeName) {

    }
}
