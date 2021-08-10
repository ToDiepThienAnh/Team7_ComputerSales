package cybersoft.backend.finalproject.ecommerce.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import cybersoft.backend.finalproject.ecommerce.user.utils.UserRole;
import cybersoft.backend.finalproject.ecommerce.user.utils.UserStatus;
import cybersoft.backend.finalproject.ecommerce.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateUserDto {
    @NotBlank(message = "{user.user-id.notblank}")
    private String userId;

    @NotBlank(message = "{user.phone.notblank}")
    private String phone;

    @NotBlank(message = "{user.fullname.notblank}")
    private String fullname;

    @NotBlank(message = "{user.avatar.notblank}")
    private String avatar;

    @JsonFormat(pattern = DateUtils.DATE)
    @NotBlank(message = "{user.birthday.notblank}")
    private LocalDateTime birthday;

    @NotBlank(message = "{user.email.notblank}")
    @Email
    private String email;

    @NotBlank(message = "{user.address.notblank}")
    private String address;

}
