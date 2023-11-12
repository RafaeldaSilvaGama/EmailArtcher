package com.ms.email.dtos;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDto {

    @NotBlank
    private String usuario;

    @NotBlank
    @Email
    private String email;

}
