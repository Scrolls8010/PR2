package Messages;

import java.util.ArrayList;

public class MessengerApp {

    public static void main(String[] args) {

        MessengerService msn = new MessengerService();
        System.out.println("Messenger service started");

//        try {
//            msn.registerUser(new User("Lukas Reisinger","online",true));
//            msn.registerUser(new User("Gerald Reisinger","online",false));
//            msn.registerUser(new User("Kevin Teller","online",true));
//            msn.registerUser(new User("Kerstin Knapp","offline",false));
//            msn.registerUser(new User("Erich Reisinger","offline",true));
////            msn.registerUser(new User("Erich Reisinger","offline",false));
//        } catch (UserAlreadyExistsException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            msn.unregisterUser(msn.getUsers().get("Kerstin Knapp"));
//           // msn.unregisterUser(new User("Jamoin", "offline", true));
//
//        } catch (UserNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            msn.sendDirectMessage(new DirectMessage("Test123", msn.getUsers().get("Lukas Reisinger"), msn.getUsers().get("Erich Reisinger")));
//        } catch (UserNotFoundException e) {
//            e.printStackTrace();
//        } catch (UserOfflineException e) {
//            e.printStackTrace();
//        } catch (MessageToSelfException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            msn.sendBroadcastMessage(new BroadcastMessage("SERVER SHUTDOWN IN 10 MINUTES",msn.getUsers().get("Gerald Reisinger")));
//        } catch (UserNotAdminException e) {
//            e.printStackTrace();
//        }

        User geri = new User("Gerald", "online", true);
        User luki = new User("Luki", "online", false);
        User kerstin = new User("Kerstin", "offline", false);
        User monte = new User("Montanablack", "offline", true);

        try {
            msn.registerUser(geri);
            msn.registerUser(luki);
            msn.registerUser(kerstin);
            msn.registerUser(monte);
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }


        try {
            DirectMessage msg1 = new DirectMessage("Sub ist raus", luki, monte);
            DirectMessage msg2 = new DirectMessage("bin da", geri, luki);
            BroadcastMessage bmsg1 = new BroadcastMessage("Subbed mich", monte);
            DirectMessage msg3 = new DirectMessage("Hallo", luki, kerstin);
            BroadcastMessage bmsg2 = new BroadcastMessage("hat wer bier?!?", geri);

            ArrayList<Message> messages = new ArrayList<>();
            messages.add(msg1);
            messages.add(msg2);
            messages.add(bmsg1);
            messages.add(msg3);
            messages.add(bmsg2);

            for (Message m : messages) {

                try {
                    if (m instanceof DirectMessage) {
                        msn.sendDirectMessage((DirectMessage) m);
                    }
                    if (m instanceof BroadcastMessage) {
                        msn.sendBroadcastMessage((BroadcastMessage) m);
                    }

                } catch (MessengerException e) {
                    System.out.println("Error sending message " + e.getMessage());
                }
            }
        } catch (MessageToSelfException e) {
            System.out.println(e.getMessage());
        }
    }
}