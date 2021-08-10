package cybersoft.backend.finalproject.ecommerce.user.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateUserDto {
    @NotBlank(message = "{user.username.notblank}")
    @Size(message = "{user.username.size}", min = 4, max = 8)
    private String username;

    @NotBlank(message = "user.user-id.notblank}")
    private String userId;

    @NotBlank(message = "{user.phone.notblank}")
    private String phone;

    @NotBlank(message = "{user.fullname.notblank}")
    private String fullname;

    @NotBlank(message = "{user.email.notblank}")
    @Email
    private String email;

    @NotBlank(message = "{user.address.notblank}")
    private String address;

}
