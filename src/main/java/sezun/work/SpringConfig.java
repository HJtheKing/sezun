package sezun.work;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sezun.work.repository.MemoryQnaRepository;
import sezun.work.repository.QnaRepository;
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
}
