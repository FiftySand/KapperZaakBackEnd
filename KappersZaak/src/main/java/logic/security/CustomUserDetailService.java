package logic.security;


import logic.Account;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import repository.IAccountRepository;

@Component
public class CustomUserDetailService implements UserDetailsService {
    private IAccountRepository repo;

    public CustomUserDetailService(IAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Account account = repo.getAccountByName(name);
        if (account == null){
            throw new UsernameNotFoundException("User with username : " + name + " could not be found");
        }
        return new Account(account.getId(), account.getName(), account.getPassword());
    }
}
