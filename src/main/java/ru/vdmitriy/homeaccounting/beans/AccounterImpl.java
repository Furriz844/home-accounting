package ru.vdmitriy.homeaccounting.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vdmitriy.homeaccounting.api.beans.Accounter;
import ru.vdmitriy.homeaccounting.api.beans.Payment;
import ru.vdmitriy.homeaccounting.api.beans.Wallet;
import ru.vdmitriy.homeaccounting.api.repo.PaymentRepository;

import java.math.BigDecimal;
import java.util.Iterator;

@Component
public class AccounterImpl implements Accounter {

    private PaymentRepository paymentRepository;

    @Autowired
    public AccounterImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public BigDecimal calculateCurrentAmount(Wallet wallet) {
        Iterable<PaymentImpl> payments = paymentRepository.getPaymentsByWalletUuid(wallet.getWalletId());
        BigDecimal currentValue = wallet.getCurrentValue();
        Iterator<PaymentImpl> paymentIterator = payments.iterator();
        while (paymentIterator.hasNext()) {
            currentValue = calculate(currentValue, paymentIterator.next());
        }
        return currentValue;
    }

    private BigDecimal calculate(BigDecimal current, Payment p) {
        if (p.isProceed()) {
            if (p.isProfit()) {
                current = current.add(p.getValue());
            } else {
                current = current.subtract(p.getValue());
            }
        }
        return current;
    }
}
