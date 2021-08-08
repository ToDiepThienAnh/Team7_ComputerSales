package cybersoft.backend.finalproject.ecommerce.security.controller;

import cybersoft.backend.finalproject.ecommerce.commondata.model.ResponseHandler;
import cybersoft.backend.finalproject.ecommerce.security.dto.JwtDto;
import cybersoft.backend.finalproject.ecommerce.security.dto.LoginDto;
import cybersoft.backend.finalproject.ecommerce.security.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class AuthController {
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDto dto,
                                        BindingResult errors){
        Authentication authentication = null;

        try {
            // authenticate
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword()));

            // set authentication into SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwtToken = jwtUtils.generateJwtToken(authentication);
            return ResponseHandler.getResponse(new JwtDto().jwt(jwtToken), HttpStatus.OK);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        return ResponseHandler.getResponse("Username or password is invalid.", HttpStatus.BAD_REQUEST);
    }
}
