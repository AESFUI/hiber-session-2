package ml.sadriev.session.service;

import java.util.UUID;
import javax.persistence.EntityManagerFactory;
import ml.sadriev.session.api.repository.UsersRepository;
import ml.sadriev.session.api.service.UsersService;
import ml.sadriev.session.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    private final SessionFactory sessionFactory;

    @Autowired
    public UsersServiceImpl(EntityManagerFactory factory, UsersRepository usersRepository) {
        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
        this.usersRepository = usersRepository;
    }

    public void createUser(Users user) {
        if (user != null && !isBlank(user.getNickName()) && !isBlank(user.getFirstName())
                && !isBlank(user.getEmail()) && !isBlank(user.getPassword()) && user.getGender() != null
                && user.getCreatingUserDate() != null) {

            Session session = sessionFactory.openSession();
            session.getTransaction().begin();

            usersRepository.createUser(session, user);

            session.getTransaction().commit();
            session.close();
        }
    }

    public void removeUserByName(String nickName) throws Exception {
        if (isBlank(nickName)) {
            throw new Exception("Not filled field");
        }

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Users user = usersRepository.findUserByName(session, nickName);

        if (user != null) {
            usersRepository.removeUserByName(session, nickName);
        }

        session.getTransaction().commit();
        session.close();
    }

    public void removeUserById(UUID id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        usersRepository.removeUserById(session, id);

        session.getTransaction().commit();
        session.close();
    }

    public void removeAllUsers() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        usersRepository.removeAllUsers(session);

        session.getTransaction().commit();
        session.close();
    }

    public void loginUser(String nickName, String email, String password) throws Exception {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        if (!isBlank(nickName)) {
            String userPass = usersRepository.findPasswordByName(session, nickName); //для наших целей можно)))
            if (!isBlank(userPass) && userPass.equals(password)) {
                usersRepository.loginUserByNickName(session, nickName, password);
            } else {
                throw new Exception("Password incorrect!");
            }
        } else if (!isBlank(email)) {
            String userPass = usersRepository.findPasswordByEmail(session, nickName);
            if (!isBlank(userPass) && userPass.equals(password)) {
                usersRepository.loginUserByEmail(session, email, password);
            } else {
                throw new Exception("Password incorrect!");
            }
        }

        session.getTransaction().commit();
        session.close();
    }

    public void logoutUser(String nickName) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        if (!isBlank(nickName)) {
            int col = usersRepository.isUserLogged(session, nickName);
            if (col == 1) {
                usersRepository.logoutUser(session, nickName);
            }
        }

        session.getTransaction().commit();
        session.close();
    }


    public Users findUserByName(String nickName) throws Exception {
        if (isBlank(nickName)) {
            throw new Exception("Not filled field");
        }

        Session session = sessionFactory.openSession();
        Users user = usersRepository.findUserByName(session, nickName);
        session.close();

        return user;
    }


}
