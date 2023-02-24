package sezun.work.repository.Qna;

import sezun.work.domain.Qna;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryQnaRepository implements QnaRepository {

    private static Map<Long, Qna> store = new HashMap<>();
    private static long sequence = 0l;

    @Override
    public Qna save(Qna qna) {
        qna.setId(++sequence);
        store.put(qna.getId(), qna);
        return qna;
    }

    @Override
    public Optional<Qna> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Qna> findByName(String name) {
        return store.values().stream()
                .filter(q -> q.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Qna> findByCorpName(String corpName) {
        return store.values().stream()
                .filter(q -> q.getName().equals(corpName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Qna> findByEmail(String email) {
        return store.values().stream()
                .filter(q -> q.getName().equals(email))
                .collect(Collectors.toList());
    }

    @Override
    public List<Qna> findByContactNum(String contactNum) {
        return store.values().stream()
                .filter(q -> q.getName().equals(contactNum))
                .collect(Collectors.toList());
    }

    @Override
    public List<Qna> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
