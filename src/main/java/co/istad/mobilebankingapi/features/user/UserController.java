package co.istad.mobilebankingapi.features.user;



import co.istad.mobilebankingapi.base.BasedMessage;
import co.istad.mobilebankingapi.features.user.dto.UserCreateRequest;
import co.istad.mobilebankingapi.features.user.dto.UserEditRequest;
import co.istad.mobilebankingapi.features.user.dto.UserPasswordRequest;
import co.istad.mobilebankingapi.features.user.dto.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNew(@Valid @RequestBody UserCreateRequest userCreateRequest){
        userService.createNew(userCreateRequest);
    }

    @PutMapping("/password")
    @ResponseStatus(HttpStatus.OK)
    public void changePassword(@Valid @RequestBody UserPasswordRequest userPasswordRequest){
        userService.changeUserPassword(userPasswordRequest);
    }

    @PatchMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void editUserByUuid(@PathVariable String uuid, @RequestBody UserEditRequest userEditRequest){
        userService.editUserProfile(userEditRequest,uuid);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<UserResponse> findAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "2") int limit
    ){
        return userService.findList(page,limit);
    }

    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse findByUuid(@PathVariable String uuid){
        return userService.findByUuid(uuid);
    }

    @PutMapping("/{uuid}/block")
    @ResponseStatus(HttpStatus.OK)
    public BasedMessage blockByUuid(@PathVariable String uuid){
        return userService.blockByUuid(uuid);
    }

    @DeleteMapping("/{uuid}/delete")
    @ResponseStatus(HttpStatus.OK)
    public BasedMessage deleteByUuid(@PathVariable String uuid){
        return userService.deleteByUuid(uuid);
    }

    @PutMapping("/{uuid}/disable")
    @ResponseStatus(HttpStatus.OK)
    public BasedMessage disableByUuid(@PathVariable String uuid){
        return userService.disableUserByUuid(uuid);
    }

    @PutMapping("/{uuid}/enable")
    @ResponseStatus(HttpStatus.OK)
    public BasedMessage enableByUuid(@PathVariable String uuid){
        return userService.enableUserByUuid(uuid);
    }
    @GetMapping
    Page<UserResponse> findAllUser(
            @RequestParam (required = false, defaultValue = "0") int page,
            @RequestParam (required = false, defaultValue = "2") int size
    ){
        return userService.findAllUser(page, size);
    }

}

