package mkv.com.mkv.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;

    private String email;
    private Long phoneNumber;

    private Long cin;
    private Long tin;
}
