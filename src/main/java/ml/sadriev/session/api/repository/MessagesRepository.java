package ml.sadriev.session.api.repository;

import java.util.List;
import java.util.UUID;
import ml.sadriev.session.model.Groups;
import ml.sadriev.session.model.Messages;
import ml.sadriev.session.model.Users;

public interface MessagesRepository {

    boolean sendMessage(String message);

    Messages readMessage(String message);

    List<Messages> readMessagesByUserName(Users user);

    List<Messages> readMessagesByGroupName(Groups group);

    Messages editMessageById(UUID groupId);

    boolean removeMessage();
}
