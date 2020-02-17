package pl.sda.medicalpassport.config;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.medicalpassport.infrastructure.user.entity.LoginData;
import pl.sda.medicalpassport.infrastructure.user.entity.Role;

import pl.sda.medicalpassport.infrastructure.user.repozitory.LoginDataRepository;

import java.util.Collections;

@Service
@RequiredArgsConstructor

public class SecurityLoginDataService implements UserDetailsService {

    private final LoginDataRepository loginDataRepository;

    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        LoginData user = loginDataRepository.findLoginDataByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("Username with login "
                    + login + " not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + Role.PATIENT)));
    }
}
