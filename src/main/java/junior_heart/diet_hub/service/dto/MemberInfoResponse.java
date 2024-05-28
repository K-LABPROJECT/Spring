package junior_heart.diet_hub.service.dto;

import org.springframework.lang.Nullable;

public record MemberInfoResponse(String username,
                                @Nullable Double height,
                                @Nullable Double weight,
                                @Nullable Double muscleMass,
                                @Nullable Double weightLoss) {

}
