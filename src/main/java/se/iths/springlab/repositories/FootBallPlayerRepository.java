package se.iths.springlab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.springlab.entities.FootballPlayer;

import java.util.List;

@Repository
public interface FootBallPlayerRepository extends JpaRepository<FootballPlayer, Long> {
    List<FootballPlayer> findAllByFirstName(String firstName);
    List<FootballPlayer> findAllByLastName (String firstName);
    List<FootballPlayer> findAllById (Long id);





}
