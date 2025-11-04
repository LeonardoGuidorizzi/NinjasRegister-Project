package dev.devdreamer.NinjasRegister.Mission;

import dev.devdreamer.NinjasRegister.Ninja.Ninja;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String level;
    //uma missão pode ter varios ninjas(uma missão vai ter varios ninjas)
    @OneToMany(mappedBy = "mission")
    private List<Ninja> ninjas;

    public Mission() {
    }

    public Mission(Long id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return level;
    }

    public void setRank(String level) {
        this.level = level;
    }
}
