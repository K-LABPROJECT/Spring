package junior_heart.diet_hub.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "muscle_mass")
    private Double muscleMass;

    @Column(name = "weight_loss")
    private Double weightLoss;

    public Member() {
    }

    public Member(String username) {
        this(username, null, null, null, null);
    }

    public Member(String username, Double height, Double weight, Double muscleMass, Double weightLoss) {
        validateName(username);
        this.username = username;
        this.height = height;
        this.weight = weight;
        this.muscleMass = muscleMass;
        this.weightLoss = weightLoss;
    }

    private void validateName(String username) {
        if (username.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getMuscleMass() {
        return muscleMass;
    }

    public Double getWeightLoss() {
        return weightLoss;
    }
}
