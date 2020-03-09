package ru.vdmitriy.homeaccounting.api.repo;

import ru.vdmitriy.homeaccounting.beans.WalletImpl;

import java.util.List;

public interface WalletRepository {

    void delete(WalletImpl wallet);

    List<WalletImpl> getAll();

    WalletImpl getById(String uuid);

    void insert(WalletImpl Wallet);
}
