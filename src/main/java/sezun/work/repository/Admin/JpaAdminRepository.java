package sezun.work.repository.Admin;

import sezun.work.domain.Admin;
import sezun.work.repository.Admin.AdminRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

public class JpaAdminRepository implements AdminRepository {

    private final EntityManager em;

    public JpaAdminRepository(EntityManager em){
        this.em = em;

    }
    @Override
    public Admin save(Admin admin) {
        em.persist(admin);
        return admin;
    }

    @Override
    public Optional<Admin> findById(Long id) {
        Admin admin = em.find(Admin.class, id);
        return Optional.ofNullable(admin);
    }
}
