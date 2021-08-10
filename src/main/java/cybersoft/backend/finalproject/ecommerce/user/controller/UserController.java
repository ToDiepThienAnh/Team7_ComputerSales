package cybersoft.backend.finalproject.ecommerce.user.controller;

import cybersoft.backend.finalproject.ecommerce.commondata.model.ResponseHandler;
import cybersoft.backend.finalproject.ecommerce.user.dto.CreateUserDto;
import cybersoft.backend.finalproject.ecommerce.user.dto.UpdateUserDto;
import cybersoft.backend.finalproject.ecommerce.user.model.User;
import cybersoft.backend.finalproject.ecommerce.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/api/user")
    public ResponseEntity<Object> findAll(){
        List<User> list = userService.findAll();
        if(list.isEmpty())
            return ResponseHandler.getResponse("There is no data", HttpStatus.OK);
        return ResponseHandler.getResponse(list, HttpStatus.OK);
    }

    @PostMapping("/api/user")
    public ResponseEntity<Object> add(@Valid @RequestBody CreateUserDto createUserDto,
                                      BindingResult errors){
        if(errors.hasErrors())
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        User user = userService.save(createUserDto);
        return ResponseHandler.getResponse(user, HttpStatus.CREATED);
    }

    @PutMapping("/api/user/update")
    public ResponseEntity<Object> update(@Valid @RequestBody UpdateUserDto dto,
                                         BindingResult errors,
                                         @RequestParam("username") String username){
        if(username.equals("") || username == null)
            return ResponseHandler.getResponse("username is invalid", HttpStatus.BAD_REQUEST);
        if(errors.hasErrors())
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        User user = userService.update(dto, username);
        if(user == null)
            return ResponseHandler.getResponse("User is invalid", HttpStatus.BAD_REQUEST);
        return ResponseHandler.getResponse(user, HttpStatus.OK);
    }

    @DeleteMapping("/api/user/delete")
    public ResponseEntity<Object> deleteByUsername(@RequestParam("username") String username){
        if(username.equals("") || username == null)
            return ResponseHandler.getResponse("username is invalid", HttpStatus.BAD_REQUEST);
        String result = userService.deleteByUsername(username);
        if(result == null)
            return ResponseHandler.getResponse("User is invalid", HttpStatus.BAD_REQUEST);
        return ResponseHandler.getResponse(result, HttpStatus.OK);
    }
}
