package sezun.work.service;

import sezun.work.domain.Qna;
import sezun.work.repository.Qna.QnaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
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

    public void deleteById(Long id){
        qnaRepository.deleteById(id);
    }
    public void deleteAll(){
        qnaRepository.deleteAll();
    }
}
