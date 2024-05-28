package junior_heart.diet_hub.repository;

import java.util.List;
import junior_heart.diet_hub.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByRestaurantId(Long restaurantId);
}
