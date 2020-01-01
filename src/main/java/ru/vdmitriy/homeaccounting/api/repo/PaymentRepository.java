package ru.vdmitriy.homeaccounting.api.repo;

import org.springframework.data.repository.CrudRepository;
import ru.vdmitriy.homeaccounting.beans.PaymentImpl;

public interface PaymentRepository extends CrudRepository<PaymentImpl, Long> {
    PaymentImpl getPaymentByUuid(String uuid);

    Iterable<PaymentImpl> getPaymentsByWalletUuid(String walletUuid);
}
