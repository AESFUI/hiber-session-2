package ml.sadriev.session.api.service;

import java.util.List;
import ml.sadriev.session.model.Groups;
import ml.sadriev.session.model.Users;

public interface GroupsService {

    void createGroup(String ownerName, Groups group) throws Exception;

    void removeGroup(String ownerName, String name) throws Exception;

    void addUserToGroup(Users user, Groups group);

    Groups findGroupByName(String groupName);

    List<Users> getListUsersOfGroup(Groups group);
}
