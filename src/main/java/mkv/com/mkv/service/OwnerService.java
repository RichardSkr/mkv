package mkv.com.mkv.service;

import mkv.com.mkv.DTO.OwnerDTO;

import java.util.List;

public interface OwnerService {
    OwnerDTO createOwner(OwnerDTO ownerDTO);
    List<OwnerDTO> getAllOwners();
    OwnerDTO getOwnerById(long id);
    OwnerDTO updateOwner(OwnerDTO ownerDTO, long id);

    void deleteOwnerById(long id);
}
