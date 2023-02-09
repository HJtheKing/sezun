package sezun.work.repository;

import sezun.work.domain.Admin;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryAdminRepository implements AdminRepository{
    private static Map<Long, Admin> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Admin save(Admin admin) {
        admin.setId(++sequence);
        store.put(sequence, admin);
        return admin;
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
}
