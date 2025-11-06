package dev.devdreamer.NinjasRegister.Ninja;

import dev.devdreamer.NinjasRegister.Mission.Mission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_ninja")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name ="name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "rank")
    private String rank;
    @Column(unique = true)
    private String email;
    @Column(name = "img_url")
    private String imgUrl;
    //Um ninja pode ter apenas uma missão(muitos ninjas vai ter uma missão)
    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

}
