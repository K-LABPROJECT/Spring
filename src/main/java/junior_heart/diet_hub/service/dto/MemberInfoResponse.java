package junior_heart.diet_hub.service.dto;

import java.time.LocalDate;
import junior_heart.diet_hub.domain.Member;
import org.springframework.lang.Nullable;

public record MemberInfoResponse(String username,
                                 @Nullable Double height,
                                 @Nullable Double firstWeight,
                                 @Nullable Double weight,
                                 @Nullable Double targetWeight,
                                 @Nullable Double muscleMass,
                                 @Nullable Double weightLoss,
                                 @Nullable Integer followers,
                                 @Nullable Integer following,
                                 @Nullable Integer characterProfileId,
                                 @Nullable LocalDate createdAt) {

    public static MemberInfoResponse from(Member member) {
        return new MemberInfoResponse(
                member.getUsername(),
                member.getHeight(),
                member.getFirstWeight(),
                member.getWeight(),
                member.getTargetWeight(),
                member.getMuscleMass(),
                member.getWeightLoss(),
                member.getFollowers(),
                member.getFollowing(),
                member.getCharacterProfileId(),
                member.getCreatedAt()
        );
    }
}
