package dev.devdreamer.NinjasRegister.Ninja.dto;

public record NinjaPatchDTO(
        String name,
        int age,
        String rank,
        String email,
        String imgUrl,
        Long missionId
) {}
