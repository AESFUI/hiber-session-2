package ml.sadriev.session.service;

import javax.annotation.Resource;
import ml.sadriev.session.api.repository.UsersRepository;
import ml.sadriev.session.api.service.UsersService;
import ml.sadriev.session.model.Users;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUser(Users user) {
        return null;
    }

    public boolean removeUser(Users user) {
        return false;
    }

    public boolean removeAllUsers() {
        return false;
    }

    public Users loginUser(String nickName, String email, String password) {
        return null;
    }

    public boolean logoutUser(Users user) {
        return false;
    }
}
