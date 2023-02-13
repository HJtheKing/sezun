package sezun.work.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sezun.work.domain.Admin;
import sezun.work.repository.Admin.AdminRepository;

@SpringBootTest
@Transactional
public class AdminServiceIntegrationTest {
    @Autowired
    AdminService adminService;
    @Autowired
    AdminRepository adminRepository;
    @Test
    public void 회원가입() throws Exception{
        Admin admin = new Admin();
        admin.setUserName("hello");
        admin.setPassword("123");

        Long saveId = adminService.join(admin);

        Admin findAdmin = adminRepository.findById(saveId).get();
        Assertions.assertEquals(findAdmin.getUserName(), admin.getUserName());

    }
    @Test
    public void 회원찾기() throws Exception{
        Admin admin = new Admin();
        admin.setUserName("hi");
        admin.setPassword("123");

        Long savId = adminService.join(admin);

        Admin findAdmin = adminRepository.findByName("hi").get();
        Assertions.assertEquals(findAdmin.getUserName(), admin.getUserName());
    }
}
