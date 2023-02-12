package sezun.work.repository.Qna;

import sezun.work.domain.Qna;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaQnaRepository implements QnaRepository{
    private final EntityManager em;

    public JpaQnaRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Qna save(Qna qna) {
        em.persist(qna);
        return qna;
    }

    @Override
    public Optional<Qna> findById(Long id) {
        Qna qna = em.find(Qna.class, id);
        return Optional.ofNullable(qna);
    }

    @Override
    public List<Qna> findByName(String name) {
        return em.createQuery("select q from Qna q where q.name = :name", Qna.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<Qna> findByCorpName(String corpName) {
        return em.createQuery("select q from Qna q where q.corpName = :corpName", Qna.class)
                .setParameter("corpName", corpName)
                .getResultList();
    }

    @Override
    public List<Qna> findByEmail(String email) {
        return em.createQuery("select q from Qna q where q.email = :email", Qna.class)
                .setParameter("email", email)
                .getResultList();
    }

    @Override
    public List<Qna> findByContactNum(String contactNum) {
        return em.createQuery("select q from Qna q where q.contactNum = :contactNum", Qna.class)
                .setParameter("contactNum", contactNum)
                .getResultList();
    }

    @Override
    public List<Qna> findAll() {
        return em.createQuery("select q from Qna q", Qna.class)
                .getResultList();
    }
}
