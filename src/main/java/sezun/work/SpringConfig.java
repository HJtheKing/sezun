package sezun.work;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sezun.work.repository.AdminRepository;
import sezun.work.repository.MemoryAdminRepository;
import sezun.work.repository.MemoryQnaRepository;
import sezun.work.repository.QnaRepository;
import sezun.work.service.AdminService;
import sezun.work.service.QnaService;

@Configuration
public class SpringConfig {
    @Bean
    public QnaService qnaService(){
        return new QnaService(qnaRepository());
    }

    @Bean
    public QnaRepository qnaRepository(){
        return new MemoryQnaRepository();
    }

    @Bean
    public AdminRepository adminRepository(){
        return new MemoryAdminRepository();
    }

    @Bean
    public AdminService adminService(){
        return new AdminService(adminRepository());
    }
}
