package junior_heart.diet_hub.controller;

import junior_heart.diet_hub.controller.dto.MemberSignRequest;
import junior_heart.diet_hub.service.MemberService;
import junior_heart.diet_hub.service.dto.MemberSignResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberSignResponse> signUp(@RequestBody MemberSignRequest request) {
        MemberSignResponse response = memberService.signUp(request.username());
        return ResponseEntity.ok(response);
    }
}
