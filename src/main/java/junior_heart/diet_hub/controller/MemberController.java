package junior_heart.diet_hub.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import junior_heart.diet_hub.controller.dto.MemberSignRequest;
import junior_heart.diet_hub.service.MemberService;
import junior_heart.diet_hub.service.dto.MemberSignResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Members", description = "회원")
@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Operation(summary = "회원가입")
    @Deprecated
    @PostMapping
    public ResponseEntity<MemberSignResponse> signUp(@RequestBody MemberSignRequest request) {
        MemberSignResponse response = memberService.signUp(request.username());
        return ResponseEntity.ok(response);
    }
}
