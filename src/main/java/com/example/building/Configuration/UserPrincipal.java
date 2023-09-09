package com.example.building.Configuration;

import com.example.building.Entity.ClientOfBuilding;
import com.example.building.Enums.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
@Component
@RequiredArgsConstructor
public class UserPrincipal implements UserDetails {
    private Integer id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private LocalDate birthDate;
    private RoleName name;
    public UserPrincipal(ClientOfBuilding clientOfBuilding){
        this.id = clientOfBuilding.getUser_id();
        this.firstname = clientOfBuilding.getFirstname();
        this.lastname = clientOfBuilding.getLastname();
        this.email = clientOfBuilding.getEmail();
        this.password = clientOfBuilding.getPassword();
        this.birthDate = clientOfBuilding.getBirthDate();
        this.name = clientOfBuilding.getName();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(name.name()));
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
