package com.synergy.backend.global.security;

import com.synergy.backend.member.model.entity.Member;
import java.util.ArrayList;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final Member member;

    @Override
    public String getUsername() {
        return member.getEmail();
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority(){
            @Override
            public String getAuthority() {
                return member.getRole();
            }
        });
        return collection;
    }

    public Long getIdx(){
        return member.getIdx();
    }

}
