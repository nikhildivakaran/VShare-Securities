package com.virtusaproject.vsharesecurities.server;

import com.virtusaproject.vsharesecurities.services.UsersService;
import com.virtusaproject.vsharesecurities.dto.UserDto;
import com.virtusaproject.vsharesecurities.exceptions.UserAlreadyExistException;
import com.virtusaproject.vsharesecurities.dto.ErrorDto;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
public class VShareController extends AbstractErrorController {

    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;

    public VShareController(UsersService usersService, ErrorAttributes errorAttributes, PasswordEncoder passwordEncoder) {
        super(errorAttributes);
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/error")
    public Object getErrorPage(HttpServletRequest request) {

        HttpStatus status = getStatus(request);
        if (status == HttpStatus.NO_CONTENT) {
            return new ResponseEntity<>(status);
        }

        switch (RequestMethod.valueOf(request.getMethod())) {
            case GET:
            case HEAD:
                return new ModelAndView("/jsp/errorpage.jsp","error", ErrorDto.resolve(status));
            default:
                Map<String, Object> body = getErrorAttributes(request, false);
                System.out.println(body);
                return new ResponseEntity<>(body, status);
        }

    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("/html/loginpage.html");
    }

    @GetMapping("/register")
    public ModelAndView getSignUpPage() {
        return new ModelAndView("/html/registration.html");
    }

    @GetMapping("/dashboard")
    public ModelAndView getDashboard() {
        return new ModelAndView("Hi");
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public ResponseEntity<?> processUser(@ModelAttribute @Valid UserDto userDto, HttpServletRequest request){
        System.out.println(userDto);

        try {
            usersService.addUser(userDto.toUser(passwordEncoder));
        } catch (UserAlreadyExistException uaeEx) {
            Map<String, Object> body = getErrorAttributes(request, false);
            System.out.println(body);
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
