package mkv.com.mkv.service.serviceIMPL;

import mkv.com.mkv.DTO.OwnerDTO;
import mkv.com.mkv.exceptions.NotFoundException;
import mkv.com.mkv.model.Owner;
import mkv.com.mkv.repository.OwnerRepository;
import mkv.com.mkv.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OwnerServiceImpl implements OwnerService {
    OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerDTO createOwner(OwnerDTO ownerDTO) {
        Owner owner = toEntity(ownerDTO);
        Owner savedOwner = ownerRepository.save(owner);
        return toDTO(savedOwner);
    }

    @Override
    public List<OwnerDTO> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();

        return owners.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerDTO getOwnerById(long id) {
        Owner owner = ownerRepository.findById(id).orElseThrow(()-> new NotFoundException("Owner not found."));
        return toDTO(owner);
    }

    @Override
    public OwnerDTO updateOwner(OwnerDTO ownerDTO, long id) {
        Owner owner = ownerRepository.findById(id).orElseThrow(()-> new NotFoundException("Owner not found."));
        owner = toEntity(ownerDTO);
        Owner newOwner = ownerRepository.save(owner);

        return toDTO(newOwner);
    }

    @Override
    public void deleteOwnerById(long id) {
        ownerRepository.deleteById(id);
    }


    private Owner toEntity(OwnerDTO ownerDTO) {
        Owner owner = new Owner();

        owner.setId(ownerDTO.getId());
        owner.setFirstName(ownerDTO.getFirstName());
        owner.setLastName(ownerDTO.getLastName());
        owner.setAddress(ownerDTO.getAddress());

        owner.setEmail(ownerDTO.getEmail());
        owner.setPhoneNumber(ownerDTO.getPhoneNumber());

        owner.setCin(ownerDTO.getCin());
        owner.setTin(ownerDTO.getTin());

        return owner;
    }

    private OwnerDTO toDTO(Owner owner){
        OwnerDTO ownerDTO = new OwnerDTO();

        ownerDTO.setId(owner.getId());
        ownerDTO.setFirstName(owner.getFirstName());
        ownerDTO.setLastName(owner.getLastName());
        ownerDTO.setAddress(owner.getAddress());

        ownerDTO.setEmail(owner.getEmail());
        ownerDTO.setPhoneNumber(owner.getPhoneNumber());

        ownerDTO.setCin(owner.getCin());
        ownerDTO.setTin(owner.getTin());

        return ownerDTO;
    }
}

