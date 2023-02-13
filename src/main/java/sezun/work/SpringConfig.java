package sezun.work;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sezun.work.repository.Admin.AdminRepository;
import sezun.work.repository.Admin.JpaAdminRepository;
import sezun.work.repository.Qna.JpaQnaRepository;
import sezun.work.repository.Qna.MemoryQnaRepository;
import sezun.work.repository.Qna.QnaRepository;
import sezun.work.service.AdminSecurityService;
import sezun.work.service.AdminService;
import sezun.work.service.QnaService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em){
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public QnaService qnaService(){
        return new QnaService(qnaRepository());
    }

    @Bean
    public QnaRepository qnaRepository(){
        return new JpaQnaRepository(em);
    }



    @Bean
    public AdminRepository adminRepository(){
        return new JpaAdminRepository(em);
    }

    @Bean
    public AdminService adminService(){

        return new AdminService(adminRepository());
    }
    @Bean
    public AdminSecurityService adminSecurityService(){
        return new AdminSecurityService(adminRepository());
    }
}
