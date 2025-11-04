package dev.devdreamer.NinjasRegister.Mission;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> { //o jpa ajuda nós fazermos queries no banco
}
