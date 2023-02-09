package sezun.work.repository;

import sezun.work.domain.Admin;

import java.util.Optional;

public interface AdminRepository {
    public Admin save(Admin admin);
    public Optional<Admin> findById(Long id);
}
