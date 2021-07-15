package domein;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Client {
    @Id
    private UUID clientId;

    private String firstName;
    private String lastName;

    @OneToMany
    private List<Account> accounts;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Client client = (Client) o;
        return clientId.equals(client.clientId) &&
                firstName.equals(client.firstName) &&
                lastName.equals(client.lastName) &&
                accounts.equals(client.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, firstName, lastName, accounts);
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
