package cybersoft.backend.finalproject.ecommerce.user.dto;

import cybersoft.backend.finalproject.ecommerce.user.annotation.CheckNumber;
import cybersoft.backend.finalproject.ecommerce.user.annotation.CheckUserIdLength;
import cybersoft.backend.finalproject.ecommerce.user.annotation.ExistsEmail;
import cybersoft.backend.finalproject.ecommerce.user.annotation.ExistsUsername;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateUserDto {
    @NotBlank(message = "{user.username.notblank}")
    @Size(message = "{user.username.size}", min = 4, max = 8)
    @ExistsUsername
    private String username;

    @NotBlank(message = "user.user-id.notblank}")
    @CheckNumber(message = "{user.user-id.number}")
    @CheckUserIdLength
    private String userId;

    @NotBlank(message = "{user.phone.notblank}")
    @CheckNumber(message = "{user.phone.number}")
    @Size(min = 10, max = 11, message = "{user.phone.size}")
    private String phone;

    @NotBlank(message = "{user.fullname.notblank}")
    private String fullname;

    @NotBlank(message = "{user.email.notblank}")
    @Email
    @ExistsEmail
    private String email;

    @NotBlank(message = "{user.address.notblank}")
    private String address;

}
