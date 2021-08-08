package cybersoft.backend.finalproject.ecommerce.security.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LoginDto {
    @NotBlank(message = "{user.username.notblank}")
    @Size(message = "{user.username.size")
    private String username;

    @NotBlank(message = "{user.password.notblank")
    private String password;
}
