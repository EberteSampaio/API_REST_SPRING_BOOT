package med.voll.api.domain.record.user;

import med.voll.api.domain.entity.User;

public record AuthData(String login, String email,String password) {

    public AuthData(User userSystem){
        this(userSystem.getLogin(), userSystem.getEmail(),userSystem.getPassword());
    }
}
