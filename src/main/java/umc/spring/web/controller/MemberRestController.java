package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistMission;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    /*
    @PostMapping("/{memberId}/missions")
    public ApiResponse<MemberResponseDTO.MissionDTO> createMission(@RequestBody @Valid MemberRequestDTO.MemberMissionDTO request,
                                                                       @ExistMember @PathVariable(name = "memberId") Long memberId,
                                                                       @ExistMission @RequestParam(name = "missionId") Long missionId){
        MemberMission membermission = memberCommandService.createMission(memberId,missionId,request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMissionResult(membermission));
    }
    */

}
