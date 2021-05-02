package Messages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MessengerService {

    private HashMap<String, User> users = new HashMap<>();
    private ArrayList<Message> history = new ArrayList<>();

    public MessengerService(HashMap<String, User> users, ArrayList<Message> history) {
        this.users = users;
        this.history = history;
    }

    public MessengerService() {

    }

    public void registerUser(User user) throws UserAlreadyExistsException {
        if (users.containsKey(user.getName())) {
            throw new UserAlreadyExistsException("User already exists!!" + "User: " + user.getName());
        } else {
            users.put(user.getName(), user);
        }
    }


    public void unregisterUser(User user) throws UserNotFoundException {
        if (!users.containsKey(user.getName())) {
            throw new UserNotFoundException("User does not exist!!");
        } else {
            users.remove(user.getName());
        }
    }

    public void sendDirectMessage(DirectMessage message) throws UserNotFoundException, UserOfflineException {
        try {
            if (!users.containsKey(message.getFrom().getName()) || !users.containsKey(message.getTo().getName())) {
                throw new UserNotFoundException("sender or reciever not found!");
            }
        } catch (NullPointerException e) {
            throw new UserNotFoundException("sender or reciever not found!", e);
        }
        if (!message.getTo().getStatus().equals(User.STATUS_ONLINE)) {
            throw new UserOfflineException("Reciever is not online!!");
        }
        System.out.println(message.getFrom() + " sends text " + message.getText() + " to " + message.getTo());
        history.add(message);
    }

    public void sendBroadcastMessage (BroadcastMessage message) throws UserNotAdminException {
        if (!message.getFrom().isAdmin()) {
            throw new UserNotAdminException("User is no admin!!");
        }
        for (Map.Entry<String,User> entry : users.entrySet()) {
            if (message.getFrom().equals(entry.getValue())) {
                continue;
            }
            System.out.println("Broadcast: " + message.getFrom().getName() + " sends Text " + message.getText() + " to " + entry.getValue().getName());
        }
        history.add(message);
    }



    public HashMap<String, User> getUsers() {
        return users;
    }

    public ArrayList<Message> getHistory() {
        return history;
    }




}



