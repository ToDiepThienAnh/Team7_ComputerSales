package cybersoft.backend.finalproject.ecommerce.user.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterDto {
    @NotBlank(message = "{user.username.notblank}")
    @Size(message = "{user.username.size}", min = 4, max = 8)
    private String username;

    @NotBlank(message = "{user.password.notblank}")
    private String password;

    @NotBlank(message = "{user.confirm-password.notblank}")
    private String confirmPassword;
}
