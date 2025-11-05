package dev.devdreamer.NinjasRegister.Mission;

import dev.devdreamer.NinjasRegister.Ninja.Ninja;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "level")
    private String level;
    //uma missão pode ter varios ninjas(uma missão vai ter varios ninjas)
    @OneToMany(mappedBy = "mission")
    private List<Ninja> ninjas;
}
