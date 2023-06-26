package com.academy.sosu.model.dto.student;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class StudentNoDTO {

    @NotBlank(message = "StudentNo is mandatory")
    public Long studentNo;

    @Builder
    public StudentNoDTO(Long studentNo) {
        this.studentNo = studentNo;
    }
}
