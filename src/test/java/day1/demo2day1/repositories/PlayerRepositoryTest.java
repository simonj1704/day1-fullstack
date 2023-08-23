package day1.demo2day1.repositories;

import day1.demo2day1.Entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Controller;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlayerRepositoryTest {
    @Autowired
    PlayerRepository playerRepository;
    boolean isInitialized = false;

    @BeforeEach
    void setUp() {
        if(!isInitialized){
            playerRepository.deleteAll();
            playerRepository.save(new Player("Lionel Messi","C1","P1"));
            playerRepository.save(new Player("P2","C2","P2"));
            isInitialized = true;
        }
    }

    @Test
    void findByName() {
        Player p1 = playerRepository.findByName("P2");
        assertEquals("P2", p1.getName());

    }


    @Test
    void findByNameLike() {
        Player p1 = playerRepository.findByNameLike("%Lionel%");
        assertEquals("Lionel Messi", p1.getName());
    }


    @Test
    public void deleteAll(){
        playerRepository.deleteAll();
        Long count = playerRepository.count();
        assertEquals(0,count);
    }

    @Test
    public void testAll(){
        Long count = playerRepository.count();
        assertEquals(2,count);
    }


}