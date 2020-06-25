package ml.sadriev.session.repository;

import ml.sadriev.session.api.repository.UsersRepository;
import ml.sadriev.session.model.Users;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    public void createUser(Session session, Users user) {
        session.persist(user);
    }

    public boolean removeUser(Users user) {
        return false;
    }

    public boolean removeAllUsers() {
        return false;
    }

    public Users loginUser(String nickName, String email, String password) {
        return null;
    }

    public boolean logoutUser(Users user) {
        return false;
    }
}
