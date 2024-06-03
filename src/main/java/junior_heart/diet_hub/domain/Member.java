package junior_heart.diet_hub.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

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

    @Column(name = "first_weight")
    private Double firstWeight;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "target_weight")
    private Double targetWeight;

    @Column(name = "muscle_mass")
    private Double muscleMass;

    @Column(name = "weight_loss")
    private Double weightLoss;

    @Column(name = "followers")
    private Integer followers;

    @Column(name = "following")
    private Integer following;

    @Column(name = "character_profile_id")
    private Integer characterProfileId;

    @Column(name = "created_at")
    private LocalDate createdAt;

    public Member() {
    }

    public Member(String username) {
        this(username, null, null, null, null, null, null, null);
    }

    public Member(String username, Double height, Double firstWeight, Double weight, Double targetWeight, Double muscleMass, Double weightLoss,
                  Integer characterProfileId) {
        validateName(username);
        this.username = username;
        this.height = height;
        this.firstWeight = firstWeight;
        this.weight = weight;
        this.targetWeight = targetWeight;
        this.muscleMass = muscleMass;
        this.weightLoss = weightLoss;
        this.followers = 0;
        this.following = 0;
        this.characterProfileId = characterProfileId;
        this.createdAt = LocalDate.now();
    }

    private void validateName(String username) {
        if (username.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    public void updateInfo(Double height, Double firstWeight, Double weight, Double targetWeight, Double muscleMass, Double weightLoss,
                           Integer characterProfileId) {
        this.height = height;
        this.firstWeight = firstWeight;
        this.weight = weight;
        this.targetWeight = targetWeight;
        this.muscleMass = muscleMass;
        this.weightLoss = weightLoss;
        this.characterProfileId = characterProfileId;
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

    public Double getFirstWeight() {
        return firstWeight;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getTargetWeight() {
        return targetWeight;
    }

    public Double getMuscleMass() {
        return muscleMass;
    }

    public Double getWeightLoss() {
        return weightLoss;
    }

    public Integer getFollowers() {
        return followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public Integer getCharacterProfileId() {
        return characterProfileId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
