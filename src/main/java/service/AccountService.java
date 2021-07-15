package service;

import domein.Account;
import dto.AccountCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AccountRepository;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Iterable<Account> getAccountById(Iterable<UUID> id){
        return accountRepository.findAllById(id);
    }




    public Account createAccount(AccountCreateDTO accountCreateDTO){
        Account account=new Account();
        account.setAccountId(accountCreateDTO.getAccountId());
        account.setAccountNum(accountCreateDTO.getAccountNum());
        account.setType(accountCreateDTO.getType());
        account.setBalance(accountCreateDTO.getBalance());
        account=accountRepository.save(account);
        return account;

    }


}
