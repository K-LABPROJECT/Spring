package junior_heart.diet_hub.controller.dto;

import org.springframework.lang.Nullable;

public record MemberSignRequest(String username,
                                @Nullable Double height,
                                @Nullable Double firstWeight,
                                @Nullable Double targetWeight,
                                @Nullable Double weight,
                                @Nullable Double muscleMass,
                                @Nullable Double weightLoss,
                                @Nullable Integer characterProfileId) {

}
