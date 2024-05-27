package junior_heart.diet_hub.service;

import junior_heart.diet_hub.domain.Member;
import junior_heart.diet_hub.domain.Restaurant;
import junior_heart.diet_hub.repository.MemberRepository;
import junior_heart.diet_hub.repository.RestaurantRepository;
import junior_heart.diet_hub.service.dto.MemberSignResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;

    public MemberService(MemberRepository memberRepository, RestaurantRepository restaurantRepository) {
        this.memberRepository = memberRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public MemberSignResponse signUp(String username) {
        Member member = memberRepository.save(new Member(username));
        restaurantRepository.save(new Restaurant("temporaryTitle", member.getId()));
        return new MemberSignResponse(member.getId());
    }
}
