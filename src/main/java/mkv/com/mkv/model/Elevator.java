package mkv.com.mkv.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Elevator {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long id;
    private String elevatorType;
    private Date dateOfCommissioning;

    private double loadCapacity;
    private double stroke;
    private boolean controlRoom;
    private int floors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    Owner owner;
}
