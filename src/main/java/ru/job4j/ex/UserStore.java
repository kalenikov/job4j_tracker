package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.getUsername())) return user;
        }
        throw new UserNotFoundException("user " + login + " not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("name length should be greater than 3");
        }
        if (!user.isValid()) {
            throw new UserInvalidException("user " + user.getUsername() + "is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
        };
        try {
            User user = findUser(users, "Tt");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ex) {
            System.out.println(ex.getMessage());
        } catch (UserNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }
}