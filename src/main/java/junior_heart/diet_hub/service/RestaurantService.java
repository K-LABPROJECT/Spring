package junior_heart.diet_hub.service;

import java.util.List;
import junior_heart.diet_hub.domain.Member;
import junior_heart.diet_hub.domain.Recipe;
import junior_heart.diet_hub.domain.Restaurant;
import junior_heart.diet_hub.repository.MemberRepository;
import junior_heart.diet_hub.repository.RecipeRepository;
import junior_heart.diet_hub.repository.RestaurantRepository;
import junior_heart.diet_hub.service.dto.RestaurantInfoResponse;
import junior_heart.diet_hub.service.dto.RestaurantSearchResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;
    private final RecipeRepository recipeRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, MemberRepository memberRepository, RecipeRepository recipeRepository) {
        this.restaurantRepository = restaurantRepository;
        this.memberRepository = memberRepository;
        this.recipeRepository = recipeRepository;
    }

    @Transactional(readOnly = true)
    public RestaurantInfoResponse findRestaurantInfo(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                                                    .orElseThrow(() -> new IllegalArgumentException(
                                                            "해당 id의 레스토랑이 존재하지 않습니다. restaurant id = {}" + restaurantId));
        Member member = memberRepository.findById(restaurant.getMemberId())
                                        .orElseThrow(() -> new IllegalArgumentException(
                                                             "해당 레스토랑의 owner Id에 해당하는 멤버가 존재하지 않습니다. restaurant.memberId={}" + restaurant.getMemberId())
                                                    );
        List<Recipe> recipes = recipeRepository.findAllByRestaurantId(restaurantId);

        return RestaurantInfoResponse.of(restaurant, member, recipes);
    }

    @Transactional(readOnly = true)
    public RestaurantSearchResponse search(String title) {
        Restaurant restaurant = restaurantRepository.findByTitleContaining(title)
                                                    .orElseThrow(() -> new IllegalArgumentException(
                                                            "해당 레스토랑 이름을 가진 레스토랑이 존재하지 않습니다. restaurant title={}" + title));
        return new RestaurantSearchResponse(restaurant.getId());
    }
}
