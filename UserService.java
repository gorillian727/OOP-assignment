import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();
    private static final String FILE_PATH = "users.txt";

    public UserService() {
        loadUsers();
    }

    // Register a new user
    public User register(String name, String email, String phoneNumber, String username, String password, String userType) {
        User user = new User(name, email, phoneNumber, username, password, userType);
        users.add(user);
        saveUsers();
        return user;
    }

    // Login user
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // Update user details
    public void updateUser(User user, String name, String email, String phoneNumber, String username, String password) {
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setUsername(username);
        user.setPassword(password);
        saveUsers();
    }

    // Delete user
    public void deleteUser(User user) {
        users.remove(user);
        saveUsers();
    }

    // Admin update user details
    public void adminUpdateUser(User admin, User user, String name, String email, String phoneNumber, String username, String password, String userType) {
        if (admin.getUserType().equals("admin")) {
            user.setName(name);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setUsername(username);
            user.setPassword(password);
            user.setUserType(userType);
            saveUsers();
        } else {
            System.out.println("Only admins can update user details.");
        }
    }

    // Logout user
    public void logout(User user) {
        System.out.println("User " + user.getUsername() + " has logged out.");
    }

    // Get list of users
    public List<User> getUsers() {
        return users;
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            users = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }
}
