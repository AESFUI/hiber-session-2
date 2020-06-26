package ml.sadriev.session.repository;

import java.util.List;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ml.sadriev.session.api.repository.GroupsRepository;
import ml.sadriev.session.model.Groups;
import ml.sadriev.session.model.Users;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class GroupsRepositoryImpl implements GroupsRepository {

    public void createGroup(Session session, Groups group) {
        session.save(group);
    }

    public int removeGroup(Session session, String name) {
        CriteriaDelete<Groups> query = session.getCriteriaBuilder().createCriteriaDelete(Groups.class);
        Root<Groups> root = query.from(Groups.class);
        query.where(root.get("groupName").in(name));
        return session.createQuery(query).executeUpdate();
    }

    public void addUserToGroup(Session session, Users user, Groups group) {
        group.getUsers().add(user);
    }

    public Groups findGroupByName(Session session, String groupName) {
        CriteriaQuery<Groups> query = session.getCriteriaBuilder().createQuery(Groups.class);
        Root<Groups> root = query.from(Groups.class);
        query.where(root.get("groupName").in(groupName));
        return session.createQuery(query).getSingleResult();
    }

    public void removeUserFromGroup(Session session, Users user, Groups group) {
        group.getUsers().remove(user);
    }

    public List<Users> getListUsersOfGroup(Session session, Groups group) {
        CriteriaQuery<Groups> query = session.getCriteriaBuilder().createQuery(Groups.class);
        Root<Groups> root = query.from(Groups.class);
        query.where(root.get("groupName").in(group.getGroupName()));
        return session.createQuery(query).list().get(0).getUsers();
    }
}
