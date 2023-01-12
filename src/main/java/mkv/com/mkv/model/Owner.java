package mkv.com.mkv.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Owner {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long id;
    private String firstName;
    private String lastName;
    private String address;

    private String email;
    private Long phoneNumber;

    private Long cin;
    private Long tin;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Elevator> elevators = new ArrayList<>();
}
