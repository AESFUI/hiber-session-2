package ml.sadriev.session.service;

import java.util.List;
import ml.sadriev.session.api.service.GroupsService;
import ml.sadriev.session.model.Groups;
import ml.sadriev.session.model.Users;
import org.springframework.stereotype.Service;

@Service
public class GroupsServiceImpl implements GroupsService {

    public Groups createGroup(String name) {
        return null;
    }

    public boolean removeGroup(String name) {
        return false;
    }

    public Groups addUserToGroup(Users user, Groups group) {
        return null;
    }

    public boolean removeUserFromGroup(Users user, Groups group) {
        return false;
    }

    public List<Users> getListUsersOfGroup(Groups group) {
        return null;
    }
}
