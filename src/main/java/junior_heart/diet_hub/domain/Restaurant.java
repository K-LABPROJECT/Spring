package junior_heart.diet_hub.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "member_id")
    private Long memberId;

    public Restaurant() {
    }

    public Restaurant(String title, Long memberId) {
        this.title = title;
        this.memberId = memberId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
