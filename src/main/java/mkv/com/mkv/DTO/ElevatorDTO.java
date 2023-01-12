package mkv.com.mkv.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ElevatorDTO {
    private Long id;

    private String elevatorType;

    private Date dateOfCommissioning;

    private double loadCapacity;

    private double stroke;

    private boolean controlRoom;

    private int floors;
}
