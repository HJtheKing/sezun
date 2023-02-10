package sezun.work.repository.Qna;

import javax.persistence.EntityManager;

public class JpaQnaRepository {
    private final EntityManager em;

    public JpaQnaRepository(EntityManager em){
        this.em = em;
    }

}
