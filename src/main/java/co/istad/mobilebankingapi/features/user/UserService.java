package co.istad.mobilebankingapi.features.user;


import co.istad.mobilebankingapi.features.user.dto.UserCreateRequest;
import co.istad.mobilebankingapi.features.user.dto.UserEditRequest;
import co.istad.mobilebankingapi.features.user.dto.UserPasswordRequest;

public interface UserService {
    void createNew(UserCreateRequest userCreateRequest);

    void changeUserPassword(UserPasswordRequest userPasswordRequest);

    void editUserProfile(UserEditRequest userEditRequest, String uuid);
}

