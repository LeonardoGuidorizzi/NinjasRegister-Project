package dev.devdreamer.NinjasRegister.Ninja.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NinjaCreateDTO(
        @NotBlank(message = "O nome do ninja é obrigatorio")
        String name,

        @NotNull(message = "A idade do ninja é obrigatoria")
        Integer age,

        @NotBlank(message = "O rank do ninja é obrigatorio")
        String rank,

        @NotBlank(message = "O email do ninja é obrigatorio")
        String email,

        @NotBlank(message = "A imgUrl é obrigatoria")
        String imgUrl,

        @NotNull(message = "O Id da missão é obrigatorio")
        Long missionId
) {}
