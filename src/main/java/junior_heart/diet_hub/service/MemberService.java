package junior_heart.diet_hub.service;

import junior_heart.diet_hub.controller.dto.MemberInfoUpdateRequest;
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
                request.firstWeight(),
                request.weight(),
                request.targetWeight(),
                request.muscleMass(),
                request.weightLoss(),
                request.characterProfileId()
        ));
        restaurantRepository.save(new Restaurant(request.username() + "가게", member.getId()));
        return new MemberSignResponse(member.getId());
    }

    @Transactional(readOnly = true)
    public MemberInfoResponse findInfo(Long memberId) {
        Member member = memberRepository.findById(memberId)
                                        .orElseThrow(() -> new IllegalArgumentException("해당 memberId 회원이 존재하지 않습니다. memberId={}" + memberId));
        return MemberInfoResponse.from(member);
    }

    @Transactional
    public void updateInfo(Long memberId, MemberInfoUpdateRequest request) {
        Member member = memberRepository.findById(memberId)
                                        .orElseThrow(() -> new IllegalArgumentException("해당 memberId 회원이 존재하지 않습니다. memberId={}" + memberId));
        member.updateInfo(request.height(),
                          request.firstWeight(),
                          request.weight(),
                          request.targetWeight(),
                          request.muscleMass(),
                          request.weightLoss(),
                          request.characterProfileId());
    }
}
