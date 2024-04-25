package co.istad.mobilebankingapi.security;

import co.istad.mobilebankingapi.domain.User;
import co.istad.mobilebankingapi.features.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByPhoneNumber(username);

        CustomUserDetails customUserDetail = new CustomUserDetails();
        customUserDetail.setUser(user);

        return customUserDetail;
    }
}
