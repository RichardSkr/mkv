package mkv.com.mkv.model;

import jakarta.persistence.*;
import lombok.Data;
import mkv.com.mkv.DTO.ElevatorDTO;

@Data
@Entity
public class User {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "elevator_id")
    Elevator elevator;
}
