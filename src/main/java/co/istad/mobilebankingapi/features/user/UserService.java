package co.istad.mobilebankingapi.features.user;


import co.istad.mobilebankingapi.base.BasedMessage;
import co.istad.mobilebankingapi.features.user.dto.UserCreateRequest;
import co.istad.mobilebankingapi.features.user.dto.UserEditRequest;
import co.istad.mobilebankingapi.features.user.dto.UserPasswordRequest;
import co.istad.mobilebankingapi.features.user.dto.UserResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    void createNew(UserCreateRequest userCreateRequest);

    void changeUserPassword(UserPasswordRequest userPasswordRequest);

    UserResponse editUserProfile(UserEditRequest userEditRequest, String uuid);

    List<UserResponse> findAll();

    UserResponse findByUuid(String uuid);

    BasedMessage blockByUuid(String uuid);

    BasedMessage deleteByUuid(String uuid);

    BasedMessage disableUserByUuid(String uuid);

    BasedMessage enableUserByUuid(String uuid);

    Page<UserResponse> findList(int page, int limit);
}
