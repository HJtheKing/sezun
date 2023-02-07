package sezun.work.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sezun.work.domain.Qna;
import sezun.work.repository.MemoryQnaRepository;

public class QnaServiceTest {
    QnaService qnaService;
    MemoryQnaRepository qnaRepository;

    @BeforeEach
    public void BeforeEach(){
        qnaRepository = new MemoryQnaRepository();
        qnaService = new QnaService(qnaRepository);
    }

    @AfterEach
    public void AfterEach(){
        qnaRepository.clearStore();
    }

    @Test
    public void 질문등록() throws Exception{
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
        Long saveId = qnaService.register(qna);
        //then
        Qna findQna = qnaRepository.findById(saveId).get();
        Assertions.assertEquals(qna.getName(), findQna.getName());
    }
}
