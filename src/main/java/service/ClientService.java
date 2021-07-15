package service;

import domein.Account;
import domein.AccountType;
import domein.Client;
import dto.AccountCreateDTO;
import dto.ClientCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountService accountService;

    public Client getClient(UUID id){
        return clientRepository.findById(id).get();

    }

    public List<Account> getAccounts(Iterable<UUID> id){
        List<Account> accounts=new ArrayList<>();

        accountService.getAccountById(id).forEach(accounts::add);
        return accounts;
    }


    public Client createClient(ClientCreateDTO clientCreateDTO, AccountCreateDTO accountCreateDTO){
        Client client=new Client();
        client.setClientId(clientCreateDTO.getUuid());
        client.setFirstName(clientCreateDTO.getFirstName());
        client.setLastName(clientCreateDTO.getLastName());
        Account account=accountService.createAccount(accountCreateDTO);
        List<Account> list=new ArrayList<>();
        list.add(account);
        client.setAccounts(list);
        client=clientRepository.save(client);
        return client;
    }





}
