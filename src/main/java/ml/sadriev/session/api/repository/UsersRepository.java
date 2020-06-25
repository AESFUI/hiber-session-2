package ml.sadriev.session.api.repository;

import java.util.UUID;
import ml.sadriev.session.model.Users;
import org.hibernate.Session;

public interface UsersRepository {

    void createUser(Session session, Users user);

    void removeUserByName(Session session, String nickName);

    void removeUserById(Session session, UUID id);

    void removeAllUsers(Session session);

    int loginUserByNickName(Session session, String nickName, String password);

    int loginUserByEmail(Session session, String email, String password);

    int logoutUser(Session session, String nickName);

    int isUserLogged(Session session, String nickName);

    Users findUserByName(Session session, String nickName);

    Users findUserByEmail(Session session, String email);

    int findPasswordByName(Session session, String nickName);

    int findPasswordByEmail(Session session, String email);
}