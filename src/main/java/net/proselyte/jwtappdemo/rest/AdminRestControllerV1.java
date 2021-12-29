package net.proselyte.jwtappdemo.rest;


import net.proselyte.jwtappdemo.dto.AdminUserDto;
import net.proselyte.jwtappdemo.dto.UserDto;
import net.proselyte.jwtappdemo.model.User;
import net.proselyte.jwtappdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminRestControllerV1 {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{usetId}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable Long usetId){
        User user = userService.findById(usetId);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto result = AdminUserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
