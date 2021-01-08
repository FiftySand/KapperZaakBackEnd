//package restapi.security;
//
//import logic.Account;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import restapi.repository.AccountRepositoryImpl;
//
//@Component
//public class CustomUserDetailService implements UserDetailsService {
//    private AccountRepositoryImpl repo;
//
//    public CustomUserDetailService(AccountRepositoryImpl repo) {
//        this.repo = repo;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        Account account = repo.getAccountByName(name);
//        if (account == null){
//            throw new UsernameNotFoundException("User with username : " + name + " could not be found");
//        }
//        return new Account(account.getId(), account.getName(), account.getPassword());
//    }
//}
