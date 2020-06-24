package ml.sadriev;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import ml.sadriev.enums.GenderEnum;
import ml.sadriev.model.Users;

public class Application {

    public static void main(String[] args) {
        final EntityManager em = Persistence.createEntityManagerFactory("ml.sadriev.hibernate").createEntityManager();

        final Users user = new Users();
        getNewUser(user);

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        final Users admin = new Users();
        getNewAdmin(admin);

        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();

        em.close();
    }

    private static void getNewAdmin(Users user) {
        user.setNickName("admin");
        user.setFirstName("Petr");
        user.setLastName("Petrov");
        user.setGender(GenderEnum.MALE);
        user.setEmail("petr@petrov.ru");
        user.setCreatingUserDate(new Date());
        user.setAdmin(true);
        user.setLogged(true);
        user.setPassword("qwerty");
    }

    private static void getNewUser(Users user) {
        user.setNickName("user1");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setGender(GenderEnum.MALE);
        user.setEmail("ivan@ivanov.ru");
        user.setCreatingUserDate(new Date());
        user.setAdmin(false);
        user.setLogged(false);
        user.setPassword("12345");
    }
}
