import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Satellite {
    @Id
    private long id;
    private String name;
    private double latitude;
    private double longitude;
}
//annotate with JPA annotations (@Entity, @Id, @GeneratedValue)
