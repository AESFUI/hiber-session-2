package ml.sadriev.session.api.repository;

import java.util.List;
import ml.sadriev.session.model.Groups;
import ml.sadriev.session.model.Users;

public interface GroupsRepository {

    Groups createGroup(String name);

    boolean removeGroup(String name);

    Groups addUserToGroup(Users user, Groups group);

    boolean removeUserFromGroup(Users user, Groups group);

    List<Users> getListUsersOfGroup(Groups group);
}
