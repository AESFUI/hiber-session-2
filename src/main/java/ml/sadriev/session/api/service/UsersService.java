package ml.sadriev.session.api.service;

import java.util.UUID;
import ml.sadriev.session.model.Users;

public interface UsersService {

    void createUser(Users user);

    void removeUserByName(String nickName) throws Exception;

    void removeUserById(UUID id);

    void removeAllUsers();

    void loginUser(String nickName, String email, String password) throws Exception;

    void logoutUser(String nickName);
}
