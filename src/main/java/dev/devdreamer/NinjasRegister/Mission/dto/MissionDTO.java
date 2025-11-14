package dev.devdreamer.NinjasRegister.Mission.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionDTO {
    private Long id;
    private String name;
    private String level;
}
