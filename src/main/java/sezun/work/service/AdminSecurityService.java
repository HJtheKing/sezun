package sezun.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sezun.work.domain.Admin;
import sezun.work.domain.AdminRole;
import sezun.work.repository.Admin.AdminRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AdminSecurityService implements UserDetailsService {
    private final AdminRepository adminRepository;

    public AdminSecurityService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> _admin = this.adminRepository.findByName(username);
        if(_admin.isEmpty()){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        Admin admin = _admin.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if("admin".equals(username)){
            authorities.add(new SimpleGrantedAuthority(AdminRole.ADMIN.getValue()));
        }else{
            authorities.add(new SimpleGrantedAuthority(AdminRole.USER.getValue()));
        }

        return new User(admin.getUserName(), admin.getPassword(), authorities);
    }
}
