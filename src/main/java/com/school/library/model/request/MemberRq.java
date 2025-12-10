package com.school.library.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRq {
    @NotNull
    @Size(max = 100)
    private String name;

    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(max = 100)
    private String phone;

    @Size(max = 500)
    private String address;

    private Date joinDate;
}
