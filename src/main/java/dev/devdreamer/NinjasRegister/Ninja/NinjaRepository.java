package dev.devdreamer.NinjasRegister.Ninja;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<Ninja, Long> { //orm um tipo de scanner que cria atravès de classes uma tabela no banco
}
