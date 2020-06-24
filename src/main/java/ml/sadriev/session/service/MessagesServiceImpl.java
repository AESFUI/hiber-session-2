package ml.sadriev.session.service;

import java.util.List;
import java.util.UUID;
import ml.sadriev.session.api.service.MessagesService;
import ml.sadriev.session.model.Groups;
import ml.sadriev.session.model.Messages;
import ml.sadriev.session.model.Users;
import org.springframework.stereotype.Service;

@Service
public class MessagesServiceImpl implements MessagesService {

    public boolean sendMessage(String message) {
        return false;
    }

    public Messages readMessage(String message) {
        return null;
    }

    public List<Messages> readMessagesByUserName(Users user) {
        return null;
    }

    public List<Messages> readMessagesByGroupName(Groups group) {
        return null;
    }

    public Messages editMessageById(UUID groupId) {
        return null;
    }

    public boolean removeMessage() {
        return false;
    }
}
