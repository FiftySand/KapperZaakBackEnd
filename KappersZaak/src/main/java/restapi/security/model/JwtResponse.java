package restapi.security.model;

import logic.Account;

public class JwtResponse {
    private String token;
    private Account account;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccountId(Account account) {
        this.account = account;
    }

    public JwtResponse(String token, Account account) {
        this.token = token;
        this.account = account;
    }
}
