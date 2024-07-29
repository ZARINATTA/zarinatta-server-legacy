package oauth.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Map<String, String>> saveUser(UserInputDto userInputDto) {
        String userId = userService.save(userInputDto);

        return ResponseEntity.ok(Map.of("userId", userId));
    }

    @PostMapping("/users/update")
    public ResponseEntity<Void> savePhoneNumber(String userId, UserUpdateDto userUpdateDto) {
        userService.update(userId, userUpdateDto);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}