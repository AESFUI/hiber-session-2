package ml.sadriev.session.api.repository;

import ml.sadriev.session.model.Users;

public interface UsersRepository {

    Users createUser(Users user);

    boolean removeUser(Users user);

    boolean removeAllUsers();

    Users loginUser(String nickName, String email, String password);

    boolean logoutUser(Users user);
}
