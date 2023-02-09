package sezun.work.service;

import sezun.work.domain.Admin;
import sezun.work.repository.AdminRepository;


public class AdminService {
    private final AdminRepository adminRepository;
    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public Long register(Admin admin){
        adminRepository.save(admin);
        return admin.getId();
    }

}
