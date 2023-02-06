package sezun.work.repository;

import sezun.work.domain.Qna;

import java.util.List;
import java.util.Optional;

public interface QnaRepository {
    Qna save(Qna qna);
    Optional<Qna> findById(Long id);
    List<Qna> findByName(String name);
    List<Qna> findByCorpName(String corpName);
    List<Qna> findByEmail(String email);
    List<Qna> findByContactNum(String contactNum);
    List<Qna> findAll();
}
