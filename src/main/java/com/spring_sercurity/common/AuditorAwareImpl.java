package com.spring_sercurity.common;

import com.spring_sercurity.entity.UserMaster;
import com.spring_sercurity.repo.UserMasterRepo;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditorAware")
public class AuditorAwareImpl implements AuditorAware<UserMaster> {

    private final UserMasterRepo userMasterRepo;

    public AuditorAwareImpl(UserMasterRepo userMasterRepo) {
        this.userMasterRepo = userMasterRepo;
    }

    @Override
    public Optional<UserMaster> getCurrentAuditor() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
            return Optional.empty();
        }

        String username = auth.getName(); // or getPrincipal().getUsername() depending on your implementation
        return userMasterRepo.findByUsername(username);
    }
}
