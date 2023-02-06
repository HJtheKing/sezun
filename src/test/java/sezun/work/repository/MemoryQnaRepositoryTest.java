package sezun.work.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import sezun.work.domain.Qna;

public class MemoryQnaRepositoryTest {
    MemoryQnaRepository repository = new MemoryQnaRepository();

    @AfterEach
    public void AfterEach(){repository.clearStore();}

    @Test
    public void 질문등록(){
        //given
        Qna qna = new Qna();
        qna.setCategory("견적");
        qna.setName("김덕배");
        qna.setContactNum("010-0000-0001");
        qna.setEmail("email1@email.com");
        qna.setSubject("제목01");
        qna.setObject("내용01");
        qna.setCorpName("상호명01");
        //when
        repository.save(qna);
        //then
        Qna result = repository.findById(qna.getId()).get();
        Assertions.assertThat(result).isEqualTo(qna);
    }


}
