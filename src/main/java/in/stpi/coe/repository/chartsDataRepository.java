package in.stpi.coe.repository;

import in.stpi.coe.entity.chartsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface chartsDataRepository extends JpaRepository<chartsData, Integer> {
}
