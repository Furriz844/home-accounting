package ru.vdmitriy.homeaccounting.api.repo;

import org.springframework.data.repository.CrudRepository;
import ru.vdmitriy.homeaccounting.beans.WalletImpl;

public interface WalletRepository extends CrudRepository<WalletImpl, String> {
}
