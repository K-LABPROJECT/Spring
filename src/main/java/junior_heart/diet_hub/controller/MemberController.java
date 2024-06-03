package junior_heart.diet_hub.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import junior_heart.diet_hub.controller.dto.MemberInfoUpdateRequest;
import junior_heart.diet_hub.controller.dto.MemberSignRequest;
import junior_heart.diet_hub.service.MemberService;
import junior_heart.diet_hub.service.dto.MemberInfoResponse;
import junior_heart.diet_hub.service.dto.MemberSignResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        MemberSignResponse response = memberService.signUp(request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "마이페이지 정보 조회")
    @GetMapping("/{memberId}/info")
    public ResponseEntity<MemberInfoResponse> findInfo(@PathVariable Long memberId) {
        MemberInfoResponse response = memberService.findInfo(memberId);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "마이페이지 정보 수정")
    @PutMapping("/{memberId}/info")
    public ResponseEntity<Void> findInfo(@PathVariable Long memberId, @RequestBody MemberInfoUpdateRequest request) {
        memberService.updateInfo(memberId, request);
        return ResponseEntity.noContent().build();
    }
}
