package ml.sadriev.session;

import java.util.Date;
import javax.annotation.Resource;

import lombok.SneakyThrows;
import ml.sadriev.session.api.service.GroupsService;
import ml.sadriev.session.api.service.UsersService;
import ml.sadriev.session.enums.GenderEnum;
import ml.sadriev.session.model.Groups;
import ml.sadriev.session.model.Users;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class Testing {

    @Resource
    private UsersService usersService;
    @Resource
    private GroupsService groupsService;

    @SneakyThrows
    public void start() {
        Users user = getNewUser("user1");
        usersService.createUser(user);
        user = getNewUser("user2");
        usersService.createUser(user);
        user = getNewUser("user3");
        usersService.createUser(user);

        usersService.removeUserByName("user2");

        usersService.loginUser("user1", StringUtils.EMPTY, "12345");

        usersService.createUser(getNewAdmin("admin"));

        groupsService.createGroup("admin", getNewGroup("GroupOne"));
        groupsService.addUserToGroup(usersService.findUserByName("user1"), groupsService.findGroupByName("GroupOne"));

        groupsService.getListUsersOfGroup(groupsService.findGroupByName("GroupOne"));

        groupsService.removeGroup("admin", "GroupOne");
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

    private Users getNewAdmin(String nickName) {
        Users user = getNewUser(nickName);
        user.setAdmin(true);
        return user;
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

    private Groups getNewGroup(String groupName) {
        Groups group = new Groups();
        group.setGroupName(groupName);
        return group;
    }
}
