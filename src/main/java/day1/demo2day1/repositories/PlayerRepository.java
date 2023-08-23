package day1.demo2day1.repositories;

import day1.demo2day1.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    Player findByName(String player);
    Player findByNameLike(String player);

}
