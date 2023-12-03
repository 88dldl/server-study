package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer age;
        @NotNull
        Integer birthdayYear;
        @NotNull
        Integer birthdayMonth;
        @NotNull
        Integer birthdayDay;
        @Size(min=5,max=12)
        String address;
        @Size(min=5,max=12)
        String specAdderss;
        @ExistCategories
        List<Long> preferCategory;
    }
    @Getter
    public static class MemberMissionDTO{
        int status;
    }

}
