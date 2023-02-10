package sezun.work.service;

import org.springframework.transaction.annotation.Transactional;
import sezun.work.domain.Admin;
import sezun.work.repository.Admin.AdminRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Transactional
public class AdminService {
    private final AdminRepository adminRepository;
    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public Long join(Admin admin){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
        return admin.getId();
    }

    public Admin findOne(Long id){
        return adminRepository.findById(id).get();
    }
}
