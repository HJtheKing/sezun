package sezun.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sezun.work.domain.Admin;
import sezun.work.repository.Admin.AdminRepository;
import sezun.work.role.AdminRole;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminSecurityService implements UserDetailsService {
    private final AdminRepository adminRepository;

    public AdminSecurityService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("1111111111111111");
        Optional<Admin> _admin = this.adminRepository.findByName("admin");
        System.out.println("2222222222222222");
        if(_admin.isEmpty()){
            System.out.println("333333333333333");
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        System.out.println("444444444444444");
        Admin admin = _admin.get();

        System.out.println("5555555555555555");
        List<GrantedAuthority> authorities = new ArrayList<>();
        if("admin".equals(username)){
            authorities.add(new SimpleGrantedAuthority(AdminRole.ADMIN.getValue()));
        }else{
            authorities.add(new SimpleGrantedAuthority(AdminRole.USER.getValue()));
        }
        System.out.println("ok");
        return new User(admin.getUserName(), admin.getPassword(), authorities);
    }
}
