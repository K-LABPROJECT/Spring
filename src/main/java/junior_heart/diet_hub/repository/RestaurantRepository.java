package junior_heart.diet_hub.repository;

import java.util.Optional;
import junior_heart.diet_hub.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByTitleContaining(String title);
}
