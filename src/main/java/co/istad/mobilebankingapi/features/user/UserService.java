package co.istad.mobilebankingapi.features;

import co.istad.mobilebankingapi.features.dto.UserCreateRequest;

public interface UserService {

    void createNew(UserCreateRequest userCreateRequest);

}

