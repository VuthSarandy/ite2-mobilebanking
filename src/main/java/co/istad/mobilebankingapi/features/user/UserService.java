package co.istad.mobilebankingapi.features.user;


import co.istad.mobilebankingapi.base.BasedMessage;
import co.istad.mobilebankingapi.features.user.dto.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    void createNew(UserCreateRequest userCreateRequest);

    void changeUserPassword(UserPasswordRequest userPasswordRequest);

    UserResponse editUserProfile(UserEditRequest userEditRequest, String uuid);

    List<UserDetailsResponse> findAll();

    UserResponse findByUuid(String uuid);

    BasedMessage blockByUuid(String uuid);

    BasedMessage deleteByUuid(String uuid);

    BasedMessage disableUserByUuid(String uuid);

    BasedMessage enableUserByUuid(String uuid);

    Page<UserResponse> findList(int page, int limit);

    Page<UserResponse> findAllUser(int page, int size);
    String updateProfileImage(String uuid,String mediaName);

}
