package co.istad.mobilebankingapi.mapper;


import co.istad.mobilebankingapi.domain.User;
import co.istad.mobilebankingapi.features.user.dto.UserCreateRequest;
import co.istad.mobilebankingapi.features.user.dto.UserDetailsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // SourceType = UserCreateRequest (Parameter)
    // TargetType = User (ReturnType)
    User fromUserCreateRequest(UserCreateRequest userCreateRequest);

    void fromUserCreateRequest2(@MappingTarget User user, UserCreateRequest userCreateRequest);

    UserDetailsResponse toUserDetailsResponse(User user);

}

