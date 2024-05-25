package junior_heart.diet_hub.service;

import junior_heart.diet_hub.domain.Member;
import junior_heart.diet_hub.repository.MemberRepository;
import junior_heart.diet_hub.service.dto.MemberSignResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberSignResponse signUp(String username) {
        Member member = memberRepository.save(new Member(username));
        return new MemberSignResponse(member.getId());
    }
}
