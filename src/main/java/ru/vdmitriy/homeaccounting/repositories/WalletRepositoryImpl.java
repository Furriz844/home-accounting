package ru.vdmitriy.homeaccounting.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vdmitriy.homeaccounting.api.beans.Wallet;
import ru.vdmitriy.homeaccounting.api.repo.WalletRepository;
import ru.vdmitriy.homeaccounting.beans.WalletImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class WalletRepositoryImpl implements WalletRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void delete(WalletImpl wallet) {
        em.remove(wallet);
    }

    @Override
    public List<WalletImpl> getAll() {
        TypedQuery<WalletImpl> query = em.createQuery("select w from WalletImpl w", WalletImpl.class);
        return query.getResultList();
    }

    @Override
    public WalletImpl getById(String walletId) {
        TypedQuery<WalletImpl> query = em.createQuery("select w from WalletImpl w where w.walletId=:walletId", WalletImpl.class);
        query.setParameter("walletId", walletId);
        return query.getSingleResult();
    }

    @Override
    public void insert(WalletImpl wallet) {
        em.persist(wallet);

    }
}
