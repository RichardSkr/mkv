package mkv.com.mkv.controller;

import mkv.com.mkv.DTO.ElevatorDTO;
import mkv.com.mkv.service.ElevatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ElevatorController {
    private ElevatorService elevatorService;
    @Autowired
    public ElevatorController(ElevatorService elevatorService) {
        this.elevatorService = elevatorService;
    }

    @PostMapping("create/owner/{ownerId}/elevator")
    public ResponseEntity<ElevatorDTO> createElevator(@PathVariable(value = "ownerId") long ownerId,
                                                      @RequestBody ElevatorDTO elevatorDTO){
        return new ResponseEntity<>(elevatorService.createElevator(ownerId, elevatorDTO), HttpStatus.CREATED);
    }

    @GetMapping("get/owner/{ownerId}/elevator")
    public List<ElevatorDTO> getElevatorByOwnerId(@PathVariable(value = "ownerId") long ownerId) {
        return elevatorService.getElevatorByOwnerId(ownerId);
    }

    @GetMapping("get/owner/{ownerId}/elevator/{elevatorId}")
    public ResponseEntity<ElevatorDTO> getElevatorByItsId(@PathVariable(value = "ownerId") long ownerId,
                                                          @PathVariable(value = "elevatorId") long elevatorId){
        return new ResponseEntity<>(elevatorService.getElevatorById(ownerId, elevatorId), HttpStatus.OK);
    }

    @PutMapping("update/owner/{ownerId}/elevator/{elevatorId}")
    public ResponseEntity<ElevatorDTO> updateELevator(@PathVariable(value = "ownerId") long ownerId,
                                                      @PathVariable(value = "elevatorId") long elevatorId,
                                                      @RequestBody ElevatorDTO elevatorDTO){
        return new ResponseEntity<>(elevatorService.updateElevator(ownerId,elevatorId,elevatorDTO),HttpStatus.OK);
    }
}
