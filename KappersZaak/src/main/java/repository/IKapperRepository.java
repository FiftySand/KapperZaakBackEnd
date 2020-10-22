package repository;

import logic.Kapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IKapperRepository extends JpaRepository<Kapper, Integer> {
}