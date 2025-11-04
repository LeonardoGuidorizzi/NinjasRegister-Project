package dev.devdreamer.NinjasRegister.Ninja;

import dev.devdreamer.NinjasRegister.Mission.Mission;
import jakarta.persistence.*;

import java.util.List;

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

    public Ninja() {
    }

    public Ninja(String nome, String email, int age) {
        this.nome = nome;
        this.email = email;
        this.age = age;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
