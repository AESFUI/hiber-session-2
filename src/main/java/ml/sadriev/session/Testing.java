package ml.sadriev.session;

import java.util.Date;
import javax.annotation.Resource;
import ml.sadriev.session.api.service.UsersService;
import ml.sadriev.session.enums.GenderEnum;
import ml.sadriev.session.model.Users;
import org.springframework.stereotype.Component;

@Component
public class Testing {

    @Resource
    private UsersService usersService;

    public void start() {
        Users user = getNewUser("user2");
        usersService.createUser(user);
    }



    private void getNewAdmin(Users user) {
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

    private Users getNewUser(String nickName) {
        Users user = new Users();
        user.setNickName(nickName);
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setGender(GenderEnum.MALE);
        user.setEmail(nickName + "@ivanov.ru");
        user.setCreatingUserDate(new Date());
        user.setAdmin(false);
        user.setLogged(false);
        user.setPassword("12345");
        return user;
    }
}
