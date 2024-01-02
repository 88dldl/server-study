package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class ReviewDTO{
        @NotBlank
        String title;
        @NotNull
        Float score;
        @NotNull
        String body;
    }
    @Getter
    public static class JoinDTO{
        @NotBlank
        String title;
        @NotNull
        Long regionId;
        @Size(min=5,max=12)
        String address;
        @Size(min=5,max=12)
        String specAdderss;
    }
    @Getter
    public static class MissionDTO{
        @NotNull
        int reward;
        @NotNull
        String mission_spec;
        LocalDate deadline;
    }
}
