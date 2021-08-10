package cybersoft.backend.finalproject.ecommerce.user.service;

import cybersoft.backend.finalproject.ecommerce.commondata.IGenericService;
import cybersoft.backend.finalproject.ecommerce.user.dto.CreateUserDto;
import cybersoft.backend.finalproject.ecommerce.user.dto.UpdateUserDto;
import cybersoft.backend.finalproject.ecommerce.user.model.User;

public interface UserService extends IGenericService<User, Long> {
    public User save(CreateUserDto dto);

    public User update(UpdateUserDto dto, String username);

    public String deleteByUsername(String username);
}
