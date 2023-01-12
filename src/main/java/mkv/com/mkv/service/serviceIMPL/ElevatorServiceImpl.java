package mkv.com.mkv.service.serviceIMPL;

import mkv.com.mkv.DTO.ElevatorDTO;
import mkv.com.mkv.exceptions.NotFoundException;
import mkv.com.mkv.model.Elevator;
import mkv.com.mkv.model.Owner;
import mkv.com.mkv.repository.ElevatorRepository;
import mkv.com.mkv.repository.OwnerRepository;
import mkv.com.mkv.service.ElevatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ElevatorServiceImpl implements ElevatorService {

    ElevatorRepository elevatorRepository;
    OwnerRepository ownerRepository;

    @Autowired
    public ElevatorServiceImpl(ElevatorRepository elevatorRepository, OwnerRepository ownerRepository) {
        this.elevatorRepository = elevatorRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public ElevatorDTO createElevator(long ownerId, ElevatorDTO elevatorDTO) {
        Elevator elevator = toEntity(elevatorDTO);
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(()-> new NotFoundException("Owner not found."));

        elevator.setOwner(owner);

        Elevator newElevator = elevatorRepository.save(elevator);
        return toDTO(newElevator);
    }

    @Override
    public List<ElevatorDTO> getElevatorByOwnerId(long elevatorId) {
        List<Elevator> elevators = elevatorRepository.findByOwnerId(elevatorId);

        return elevators.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ElevatorDTO getElevatorById(long ownerId, long elevatorId) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(()-> new NotFoundException("There is no owner of this ID"));
        Elevator elevator = elevatorRepository.findById(elevatorId).orElseThrow(()-> new NotFoundException("There is no elevator with this ID"));

        if(!Objects.equals(elevator.getOwner().getId(), owner.getId())){
            throw new NotFoundException("Elevator not found.");
        }
        return toDTO(elevator);
    }

    @Override
    public ElevatorDTO updateElevator(long ownerId, long elevatorId, ElevatorDTO elevatorDTO) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(()-> new NotFoundException("There is no owner of this ID"));
        Elevator elevator = elevatorRepository.findById(elevatorId).orElseThrow(()-> new NotFoundException("There is no elevator with this ID"));

        if(!Objects.equals(elevator.getOwner().getId(), owner.getId())){
            throw new NotFoundException("Elevator not found.");
        }
        elevator.setElevatorType(elevatorDTO.getElevatorType());
        elevator.setFloors(elevatorDTO.getFloors());
        elevator.setStroke(elevatorDTO.getStroke());
        elevator.setControlRoom(elevatorDTO.isControlRoom());
        elevator.setLoadCapacity(elevatorDTO.getLoadCapacity());
        elevator.setDateOfCommissioning(elevatorDTO.getDateOfCommissioning());

        Elevator updatedElevator = elevatorRepository.save(elevator);
        return toDTO(updatedElevator);
    }

    @Override
    public void deleteElevatorById(long ownerId, long elevatorId) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(()-> new NotFoundException("There is no owner of this ID"));
        Elevator elevator = elevatorRepository.findById(elevatorId).orElseThrow(()-> new NotFoundException("There is no elevator with this ID"));

        if(!Objects.equals(elevator.getOwner().getId(), owner.getId())){
            throw new NotFoundException("Elevator not found.");
        }
        elevatorRepository.delete(elevator);
    }

    private Elevator toEntity(ElevatorDTO elevatorDTO){
        Elevator elevator = new Elevator();

        elevator.setId(elevatorDTO.getId());
        elevator.setElevatorType(elevatorDTO.getElevatorType());
        elevator.setFloors(elevatorDTO.getFloors());
        elevator.setStroke(elevatorDTO.getStroke());
        elevator.setControlRoom(elevatorDTO.isControlRoom());
        elevator.setLoadCapacity(elevatorDTO.getLoadCapacity());
        elevator.setDateOfCommissioning(elevatorDTO.getDateOfCommissioning());

        return elevator;
    }

    private ElevatorDTO toDTO(Elevator elevator) {
        ElevatorDTO elevatorDTO = new ElevatorDTO();

        elevatorDTO.setId(elevator.getId());
        elevatorDTO.setElevatorType(elevator.getElevatorType());
        elevatorDTO.setFloors(elevator.getFloors());
        elevatorDTO.setStroke(elevator.getStroke());
        elevatorDTO.setControlRoom(elevator.isControlRoom());
        elevatorDTO.setLoadCapacity(elevator.getLoadCapacity());
        elevatorDTO.setDateOfCommissioning(elevator.getDateOfCommissioning());

        return elevatorDTO;
    }
}
