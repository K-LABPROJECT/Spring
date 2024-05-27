package junior_heart.diet_hub.service;

import junior_heart.diet_hub.domain.Restaurant;
import junior_heart.diet_hub.repository.RestaurantRepository;
import junior_heart.diet_hub.service.dto.RestaurantSearchResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional(readOnly = true)
    public RestaurantSearchResponse search(String title) {
        Restaurant restaurant = restaurantRepository.findByTitle(title)
                                                    .orElseThrow(() -> new IllegalArgumentException(
                                                            "해당 레스토랑 이름을 가진 레스토랑이 존재하지 않습니다. restaurant title={}" + title));
        return new RestaurantSearchResponse(restaurant.getId());
    }
}
