package cybersoft.backend.finalproject.ecommerce.user.service;

import cybersoft.backend.finalproject.ecommerce.commondata.GenericService;
import cybersoft.backend.finalproject.ecommerce.user.dto.CreateUserDto;
import cybersoft.backend.finalproject.ecommerce.user.dto.UpdateUserDto;
import cybersoft.backend.finalproject.ecommerce.user.model.User;
import cybersoft.backend.finalproject.ecommerce.user.repository.UserRepository;
import cybersoft.backend.finalproject.ecommerce.user.utils.UserRole;
import cybersoft.backend.finalproject.ecommerce.user.utils.UserStatus;
import cybersoft.backend.finalproject.ecommerce.utils.MapDtoToModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl extends GenericService<User, Long> implements UserService {
    private UserRepository userRepository;
    private MapDtoToModel<Object, Object> mapper;

    @Override
    public User save(CreateUserDto dto) {
        User user = new User();
        user = (User) mapper.map(dto, user);
        user.setRole(UserRole.EMPLOYEE);
        user.setPassword("123");
        user.setStatus(UserStatus.ACTIVE);
        return userRepository.save(user);
    }

    @Override
    public User update(UpdateUserDto dto, String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty())
            return null;
        user = (Optional<User>) mapper.map(dto, user);
        return userRepository.save(user.get());
    }

    @Override
    public String deleteByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty())
            return null;
        userRepository.deleteById(user.get().getId());
        return "Delete successfully";
    }

    @Override
    public boolean isEmailTaken(String email) {
        return userRepository.countByEmail(email) >= 1;
    }

    @Override
    public boolean isUsernameTaken(String username) {
        return userRepository.countByUsername(username) >= 1;
    }

    @Override
    public boolean isUserIdTaken(String userId) {
        return userRepository.countByUserId(userId) >= 1;
    }
}
