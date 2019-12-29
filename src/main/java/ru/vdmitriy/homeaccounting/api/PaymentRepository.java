package ru.vdmitriy.homeaccounting.api;

import org.springframework.data.repository.CrudRepository;
import ru.vdmitriy.homeaccounting.beans.PaymentImpl;

public interface PaymentRepository extends CrudRepository<PaymentImpl, Long> {
    PaymentImpl getPaymentByUuid(String uuid);
}
