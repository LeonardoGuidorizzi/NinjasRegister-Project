package dev.devdreamer.NinjasRegister.Ninja.dto;

import jakarta.validation.constraints.NotBlank;

public record NinjaResponseDTO(
        String name,
        int age,
        String rank,
        String email,
        String imgUrl,
        Long missionId
) {}
