package junior_heart.diet_hub.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MemberTest {

    @Test
    @DisplayName("회원 이름은 한 글자 이상이어야 한다")
    void validateName() {
        String name = "";

        assertThatThrownBy(() -> new Member(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
