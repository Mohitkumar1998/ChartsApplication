package in.stpi.coe.repository;

import in.stpi.coe.entity.coe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface coeRepository extends JpaRepository<coe, Integer> {
    Optional<coe> findByCoeId(int coeId);
}
