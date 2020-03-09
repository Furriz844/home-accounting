package ru.vdmitriy.homeaccounting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vdmitriy.homeaccounting.api.beans.Accounter;
import ru.vdmitriy.homeaccounting.api.beans.Wallet;
import ru.vdmitriy.homeaccounting.api.builders.WalletBuilder;
import ru.vdmitriy.homeaccounting.api.repo.WalletRepository;
import ru.vdmitriy.homeaccounting.beans.WalletImpl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
public class WalletController {

    private WalletBuilder builder;

    private WalletRepository repository;

    private Accounter accounter;

    @Autowired
    public WalletController(WalletBuilder builder, WalletRepository repository, Accounter accounter) {
        this.builder = builder;
        this.repository = repository;
        this.accounter = accounter;
    }

    @RequestMapping("/wallet")
    public Wallet getWallet(@RequestParam String uuid) {
        Wallet wallet = repository.getById(uuid);
        //todo calculate by sql
        //wallet.setCurrentValue(accounter.calculateCurrentAmount(wallet));
        return wallet;
    }

    @RequestMapping("wallet/all")
    //todo rewrite find and findAll to recalculate currentValue
    public List<WalletImpl> getAllWallets() {
        return repository.getAll();
    }

    @PostMapping("wallet/add")
    public String createWallet(@RequestBody WalletImpl wallet) {
        String walletId = UUID.randomUUID().toString();
        WalletImpl walletImpl = (WalletImpl) builder.setName(wallet.getName())
                .setDescription(wallet.getDescription())
                //todo generate walletId in builder
                .setWalletId(walletId)
                .setWalletTypeId(wallet.getWalletTypeId())
                .setCurrencyCode(wallet.getCurrencyCode())
                .setStartValue(wallet.getStartValue())
                .build();
        repository.insert(walletImpl);
        return walletId;
    }

    @RequestMapping("/wallet/delete")
    public String deleteWallet(@RequestParam String uuid) {
        WalletImpl wallet = repository.getById(uuid);
        if (Objects.isNull(wallet)) {
            return "Object not found";
        }
        //todo remove or replace payments
        repository.delete(wallet);
        return ("ok");
    }

    @PostMapping("/wallet/update")
    public String updateWallet(
            @RequestParam String uuid,
            @RequestBody WalletImpl wallet) {
        WalletImpl walletImpl = repository.getById(uuid);
        if (Objects.isNull(walletImpl)) {
            return "Object not found";
        }
        System.out.println(wallet.getStartValue());
        walletImpl.setName(wallet.getName());
        walletImpl.setDescription(wallet.getDescription());
        walletImpl.setWalletTypeId(wallet.getWalletTypeId());
        walletImpl.setCurrencyCode(wallet.getCurrencyCode());
        walletImpl.setStartValue(wallet.getStartValue());
        repository.insert(walletImpl);
        return "ok";
    }
}
