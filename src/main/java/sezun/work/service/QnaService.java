package sezun.work.service;

import sezun.work.domain.Qna;
import sezun.work.repository.MemoryQnaRepository;
import sezun.work.repository.QnaRepository;

import java.util.List;
import java.util.Optional;

public class QnaService {

    private final QnaRepository qnaRepository;

    public QnaService(QnaRepository qnaRepository){
        this.qnaRepository = qnaRepository;
    }

    public Long register(Qna qna){
        qnaRepository.save(qna);
        return qna.getId();
    }

    public List<Qna> findQna(){
        return qnaRepository.findAll();
    }

    public Optional<Qna> findOne(Long id){
        return qnaRepository.findById(id);
    }
}
