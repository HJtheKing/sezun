package sezun.work;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sezun.work.repository.*;
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
        return new MemoryQnaRepository();
    }



    @Bean
    public AdminRepository adminRepository(){
        return new JpaAdminRepository(em);
    }

    @Bean
    public AdminService adminService(){

        return new AdminService(adminRepository());
    }
}
