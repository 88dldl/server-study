package umc.spring.converter;

import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

public class MemberMissionConverter{
    public static MemberMission toGetMission(MemberRequestDTO.MemberMissionDTO request){
        MissionStatus missionStatus = null;
        switch (request.getStatus()){
            case 1:
                missionStatus=MissionStatus.COMPLETE;
                break;
            case 2:
                missionStatus=MissionStatus.CHALLENGING;
                break;
        }
        return MemberMission.builder()
                .status(missionStatus)
                .build();
    }
    public static MemberResponseDTO.MissionDTO toMissionResult(MemberMission memberMission){
        return MemberResponseDTO.MissionDTO.builder()
                .missionId(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
}
