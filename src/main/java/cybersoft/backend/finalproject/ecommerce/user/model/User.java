package cybersoft.backend.finalproject.ecommerce.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import cybersoft.backend.finalproject.ecommerce.commondata.model.AbstractEntity;
import cybersoft.backend.finalproject.ecommerce.user.utils.UserRole;
import cybersoft.backend.finalproject.ecommerce.user.utils.UserStatus;
import cybersoft.backend.finalproject.ecommerce.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "selling_user")
public class User extends AbstractEntity {
    @Column(unique = true)
    @NotBlank(message = "{user.username.notblank}")
    @Size(message = "{user.username.size}", min = 4, max = 8)
    private String username;

    private String userId;

    private String fullname;

    private String password;

    private String avatar;

    @JsonFormat(pattern = DateUtils.DATE)
    private LocalDateTime birthday;

    @Column(unique = true)
    @NotBlank(message = "{user.email.notblank}")
    @Email
    private String email;

    private String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
