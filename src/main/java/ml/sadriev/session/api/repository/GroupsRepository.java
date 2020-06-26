package ml.sadriev.session.api.repository;

import java.util.List;
import ml.sadriev.session.model.Groups;
import ml.sadriev.session.model.Users;
import org.hibernate.Session;

public interface GroupsRepository {

    void createGroup(Session session, Groups group);

    int removeGroup(Session session, String name);

    void addUserToGroup(Session session, Users user, Groups group);

    Groups findGroupByName(Session session, String groupName);

    void removeUserFromGroup(Session session, Users user, Groups group);

    List<Users> getListUsersOfGroup(Session session, Groups group);
}
