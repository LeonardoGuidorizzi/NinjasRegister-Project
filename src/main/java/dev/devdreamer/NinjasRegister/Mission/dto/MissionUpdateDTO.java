package dev.devdreamer.NinjasRegister.Mission.dto;

import jakarta.validation.constraints.NotBlank;

public record MissionUpdateDTO(
        @NotBlank(message = "O nome da missão é obrigadorio" )
        String name,
        @NotBlank(message = "O level da missão é obrigadorio" )
        String level
) {
}
