package junior_heart.diet_hub.service;

import junior_heart.diet_hub.controller.dto.MemberSignRequest;
import junior_heart.diet_hub.domain.Member;
import junior_heart.diet_hub.domain.Restaurant;
import junior_heart.diet_hub.repository.MemberRepository;
import junior_heart.diet_hub.repository.RestaurantRepository;
import junior_heart.diet_hub.service.dto.MemberInfoResponse;
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
    public MemberSignResponse signUp(MemberSignRequest request) {
        Member member = memberRepository.save(new Member(
                request.username(),
                request.height(),
                request.weight(),
                request.muscleMass(),
                request.weightLoss()
        ));
        restaurantRepository.save(new Restaurant(request.username() + "가게", member.getId()));
        return new MemberSignResponse(member.getId());
    }

    @Transactional(readOnly = true)
    public MemberInfoResponse findInfo(Long memberId) {
        Member member = memberRepository.findById(memberId)
                                        .orElseThrow(() -> new IllegalArgumentException("해당 memberId 회원이 존재하지 않습니다. memberId={}" + memberId));
        return new MemberInfoResponse(
                member.getUsername(),
                member.getHeight(),
                member.getWeight(),
                member.getMuscleMass(),
                member.getWeightLoss()
        );
    }
}
