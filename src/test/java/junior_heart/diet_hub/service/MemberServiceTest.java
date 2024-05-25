package junior_heart.diet_hub.service;

import junior_heart.diet_hub.domain.Member;
import junior_heart.diet_hub.repository.MemberRepository;
import junior_heart.diet_hub.service.dto.MemberSignResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입을 진행한다")
    void signUp() {
        // given
        String username = "kth990303";

        // when
        MemberSignResponse response = memberService.signUp(username);

        // then
        Member member = memberRepository.findById(response.id())
                                        .orElseThrow();
        assertThat(member).isNotNull();
    }
}