package dev.devdreamer.NinjasRegister.Ninja.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NinjaUpdateDTO(
        @NotBlank(message = "O nome do ninja é obrigadorio" )
        String name,
        @NotBlank(message = "A idade do ninja é obrigadorio" )
        int age,
        @NotBlank(message = "O rank do ninja é obrigadorio" )
        String rank,
        @NotBlank(message = "O email do ninja é obrigadorio" )
        String email,
        @NotBlank(message = "A imgUrl é obrigadorio" )
        String imgUrl,
        @NotNull(message = "O Id da missão é obrigadorio" )
        Long missionId
) {
}
