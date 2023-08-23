package day1.demo2day1.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @NoArgsConstructor @Getter @Setter
@Table(name="spiller")
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="player_name", length = 80, nullable = false)
    String name;
    String country;
    String position;
    public  Player(String name, String country, String position) {
        this.name = name;
        this.country = country;
        this.position = position;
    }
}


