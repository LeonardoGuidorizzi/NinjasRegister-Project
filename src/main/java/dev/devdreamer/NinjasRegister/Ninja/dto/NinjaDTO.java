package dev.devdreamer.NinjasRegister.Ninja.dto;
import dev.devdreamer.NinjasRegister.Mission.Mission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO{
    //dto = abstração, um clone da nossa entidade sem deixar brechas de segurança
    private Long id;
    private String name;
    private int age;
    private String rank;
    private String email;
    private String imgUrl;
    private Long missionId;

}
