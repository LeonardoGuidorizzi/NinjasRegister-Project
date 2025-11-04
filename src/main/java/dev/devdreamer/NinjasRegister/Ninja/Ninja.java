package dev.devdreamer.NinjasRegister.Ninja;

import dev.devdreamer.NinjasRegister.Mission.Mission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_ninja")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int age;
    //Um ninja pode ter apenas uma missão(muitos ninjas vai ter uma missão)
    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

}
