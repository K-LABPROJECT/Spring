package junior_heart.diet_hub.service.dto;

import junior_heart.diet_hub.domain.Restaurant;

public record RestaurantSearchResponse(Long restaurantId, String title, Long ownerId) {

    public static RestaurantSearchResponse from(Restaurant restaurant) {
        return new RestaurantSearchResponse(restaurant.getId(), restaurant.getTitle(), restaurant.getMemberId());
    }
}
