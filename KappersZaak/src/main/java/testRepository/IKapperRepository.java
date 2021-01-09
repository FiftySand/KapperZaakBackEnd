package testRepository;

import logic.Kapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKapperRepository extends JpaRepository<Kapper, Integer> {
}