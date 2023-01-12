package mkv.com.mkv.repository;

import mkv.com.mkv.model.Elevator;
import mkv.com.mkv.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElevatorRepository extends JpaRepository<Elevator, Long> {
    public List<Elevator> findByOwnerId(long id);
}
