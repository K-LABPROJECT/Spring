package junior_heart.diet_hub.service.dto;

import org.springframework.lang.Nullable;

public record MemberInfoResponse(String username,
                                 @Nullable Double height,
                                 @Nullable Double firstWeight,
                                 @Nullable Double weight,
                                 @Nullable Double muscleMass,
                                 @Nullable Double targetWeight,
                                 @Nullable Double weightLoss,
                                 @Nullable Integer followers,
                                 @Nullable Integer following,
                                 @Nullable Integer characterProfileId) {

}
