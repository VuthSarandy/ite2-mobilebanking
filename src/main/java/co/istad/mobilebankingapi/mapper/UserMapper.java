package co.istad.mobilebankingapi.mapper;


import co.istad.mobilebankingapi.domain.User;
import co.istad.mobilebankingapi.domain.UserAccount;
import co.istad.mobilebankingapi.features.user.dto.UserCreateRequest;
import co.istad.mobilebankingapi.features.user.dto.UserDetailsResponse;
import co.istad.mobilebankingapi.features.user.dto.UserEditRequest;
import co.istad.mobilebankingapi.features.user.dto.UserResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromUserCreateRequest(UserCreateRequest request);

    //    void fromUserCreateRequest2(@MappingTarget User user, UserCreateRequest request);
    UserDetailsResponse toUserDetailResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUserEditRequest(UserEditRequest userEditRequest, @MappingTarget User user);

    UserResponse toUserResponse(User user);
    List<UserDetailsResponse> toUserDetailResponseList(List<User> users);
    @Named("mapUserDetailResponse")
    default UserDetailsResponse mapUserDetailResponse(List<UserAccount> userAccountList){
        return toUserDetailResponse(userAccountList.get(0).getUser());
    }

}



