package ml.sadriev.session.service;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import ml.sadriev.session.api.repository.GroupsRepository;
import ml.sadriev.session.api.service.GroupsService;
import ml.sadriev.session.api.service.UsersService;
import ml.sadriev.session.model.Groups;
import ml.sadriev.session.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupsServiceImpl implements GroupsService {

    private final GroupsRepository groupsRepository;

    private final UsersService usersService;

    private final SessionFactory sessionFactory;

    @Autowired
    public GroupsServiceImpl(EntityManagerFactory factory, GroupsRepository groupsRepository,
                             UsersService usersService) {
        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
        this.groupsRepository = groupsRepository;
        this.usersService = usersService;
    }

    public void createGroup(String ownerName, Groups group) throws Exception {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Users user = usersService.findUserByName(ownerName);
        if (user == null || !user.isAdmin()) {
            return;
        }

        groupsRepository.createGroup(session, group);

        session.getTransaction().commit();
        session.close();
    }

    public void removeGroup(String ownerName, String name) throws Exception {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Users user = usersService.findUserByName(ownerName);
        if (user == null || !user.isAdmin()) {
            throw new Exception("Only admin may delete groups!");
        }

        groupsRepository.removeGroup(session, name);

        session.getTransaction().commit();
        session.close();
    }

    public void addUserToGroup(Users user, Groups group) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        group = session.load(Groups.class, group.getId());
        user = session.load(Users.class, user.getId());

        groupsRepository.addUserToGroup(session, user, group);

        session.getTransaction().commit();
        session.close();
    }

    public Groups findGroupByName(String groupName) {
        Session session = sessionFactory.openSession();
        return groupsRepository.findGroupByName(session, groupName);
    }

    public List<Users> getListUsersOfGroup(Groups group) {
        Session session = sessionFactory.openSession();

        List<Users> users = groupsRepository.getListUsersOfGroup(session, group);

        session.close();

        return users;
    }
}
