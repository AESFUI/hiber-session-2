package ml.sadriev.session.api.repository;

import ml.sadriev.session.model.Users;
import org.hibernate.Session;

public interface UsersRepository {

    void createUser(Session session, Users user);

    boolean removeUser(Users user);

    boolean removeAllUsers();

    Users loginUser(String nickName, String email, String password);

    boolean logoutUser(Users user);
}
