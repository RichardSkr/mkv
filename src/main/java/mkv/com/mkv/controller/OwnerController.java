package mkv.com.mkv.controller;

import mkv.com.mkv.DTO.OwnerDTO;
import mkv.com.mkv.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class OwnerController {

  private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("create/owner")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO ownerDTO){
        return new ResponseEntity<>(ownerService.createOwner(ownerDTO), HttpStatus.CREATED);
    }

    @GetMapping("get/all/owners")
    public ResponseEntity<List<OwnerDTO>> getAll(){
      return new ResponseEntity<>(ownerService.getAllOwners(),HttpStatus.OK);
    }

    @GetMapping("get/{id}/owner")
    public ResponseEntity<OwnerDTO> getById(@PathVariable ("id") long id){
      return ResponseEntity.ok(ownerService.getOwnerById(id));
    }

    @PutMapping("update/{id}/owner")
    public ResponseEntity<OwnerDTO> updateById(@PathVariable ("id") long id, @RequestBody OwnerDTO ownerDTO){
      OwnerDTO response = ownerService.updateOwner(ownerDTO,id);
      return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}/owner")
    public ResponseEntity<String> deleteById(@PathVariable ("id") long id){
      ownerService.deleteOwnerById(id);
      return new ResponseEntity<>("Owner deleted successfuly", HttpStatus.OK);
    }
}
