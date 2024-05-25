package junior_heart.diet_hub.repository;

import junior_heart.diet_hub.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
