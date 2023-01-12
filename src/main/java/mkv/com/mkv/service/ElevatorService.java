package mkv.com.mkv.service;

import mkv.com.mkv.DTO.ElevatorDTO;

import java.util.List;

public interface ElevatorService {

    ElevatorDTO createElevator(long ownerId, ElevatorDTO elevatorDTO);
    List<ElevatorDTO> getElevatorByOwnerId(long elevatorId);
    ElevatorDTO getElevatorById(long ownerId, long elevatorId);
    ElevatorDTO updateElevator(long ownerId, long elevatorId, ElevatorDTO elevatorDTO);
    void deleteElevatorById(long ownerId, long elevatorId);

}
