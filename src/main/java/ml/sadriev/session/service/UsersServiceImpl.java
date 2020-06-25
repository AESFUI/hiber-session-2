package ml.sadriev.session.service;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import ml.sadriev.session.api.repository.UsersRepository;
import ml.sadriev.session.api.service.UsersService;
import ml.sadriev.session.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private final UsersRepository usersRepository;

    private SessionFactory sessionFactory;

    @Autowired
    public UsersServiceImpl(EntityManagerFactory factory, UsersRepository usersRepository) {
        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
        this.usersRepository = usersRepository;
    }

    public void createUser(Users user) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        session.persist(user);

        usersRepository.createUser(session, user);
        session.getTransaction().commit();
        session.close();
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
