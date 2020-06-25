package ml.sadriev.session.repository;

import java.util.UUID;
import javax.persistence.Query;
import ml.sadriev.session.api.repository.UsersRepository;
import ml.sadriev.session.model.Users;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    public void createUser(Session session, Users user) {
        session.save(user);
    }

    public void removeUserByName(Session session, String name) {
        String hql = "DELETE FROM Users WHERE nickName = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        query.executeUpdate();
    }

    public void removeUserById(Session session, UUID id) {
        String hql = "DELETE FROM Users WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void removeAllUsers(Session session) {
        String hql = "DELETE FROM Users";
        Query query = session.createQuery(hql);
        query.executeUpdate();
    }

    public int loginUserByNickName(Session session, String nickName, String password) {

        String hql = "UPDATE Users SET isLogged = true WHERE nickName = :nickName";
        Query query = session.createQuery(hql);
        query.setParameter("nickName", nickName);
        return query.executeUpdate();
    }

    public int loginUserByEmail(Session session, String email, String password) {
        String hql = "UPDATE Users SET isLogged = true WHERE email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        return query.executeUpdate();
    }

    public int logoutUser(Session session, String nickName) {
        String hql = "UPDATE Users SET isLogged = false WHERE nickName = :nickName";
        Query query = session.createQuery(hql);
        query.setParameter("nickName", nickName);
        return query.executeUpdate();
    }

    public int isUserLogged(Session session, String nickName) {
        String hql = "FROM Users WHERE nickName = :nickName AND isLogged = true";
        Query query = session.createQuery(hql);
        query.setParameter("nickName", nickName);
        return query.executeUpdate();
    }

    public Users findUserByName(Session session, String nickName) {
        String hql = "FROM Users WHERE nickName = :nickName";
        Query query = session.createQuery(hql);
        query.setParameter("nickName", nickName);
        return (Users) query.getSingleResult();
    }

    public Users findUserByEmail(Session session, String email) {
        String hql = "FROM Users WHERE email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        return (Users) query.getSingleResult();
    }

    public int findPasswordByName(Session session, String nickName) {
        String hql = "FROM Users WHERE nickName = :nickName";
        Query query = session.createQuery(hql);
        query.setParameter("nickName", nickName);
        return query.executeUpdate();
    }
    public int findPasswordByEmail(Session session, String email) {
        String hql = "FROM Users WHERE email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        return query.executeUpdate();
    }
    
}
