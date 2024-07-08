import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static UserService userService = new UserService();
    private static User currentUser = null;
    private static ClimateData climateData = new ClimateData();
    private static EducationMaterial educationMaterial = new EducationMaterial();
    private static FAQ faq = new FAQ();
    private static Scanner scanner = new Scanner(System.in);
    private static final String ADMIN_CODE = "001006";

    public static void main(String[] args) {
        do {
            if (currentUser == null) {
                showMainMenu();
            } else {
                showUserMenu();
            }
        } while (true);
    }

    private static void showMainMenu() {
        System.out.println("Welcome to the Climate Action Application");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");

        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        register();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        choice = -1; // Reset choice to stay in loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void register() {
        System.out.println("Register a new user");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        String email;
        while (true) {
            System.out.print("Email: ");
            email = scanner.nextLine();
            if (email.contains("@") && email.endsWith(".com")) {
                break;
            } else {
                System.out.println("Email invalid, enter a valid email or press Q to quit.");
                if (email.equalsIgnoreCase("Q")) {
                    return;
                }
            }
        }

        String phoneNumber;
        while (true) {
            System.out.print("Phone Number: ");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("\\d+")) {
                break;
            } else {
                System.out.println("Phone number invalid, enter a valid phone number or press Q to quit.");
                if (phoneNumber.equalsIgnoreCase("Q")) {
                    return;
                }
            }
        }

        System.out.print("Username: ");
        String username = scanner.nextLine();

        String password;
        while (true) {
            System.out.print("Password: ");
            password = scanner.nextLine();
            if (password.matches(".*[A-Za-z].*") && password.matches(".*\\d.*") && password.length() >= 5) {
                break;
            } else {
                System.out.println("Password invalid, it must have at least 4 letters and 1 number. Enter a valid password or press Q to quit.");
                if (password.equalsIgnoreCase("Q")) {
                    return;
                }
            }
        }

        System.out.print("User Type (public/admin): ");
        String userType = scanner.nextLine();

        if (userType.equals("admin")) {
            while (true) {
                System.out.print("Enter Admin Code: ");
                String adminCode = scanner.nextLine();
                if (ADMIN_CODE.equals(adminCode)) {
                    break;
                } else {
                    System.out.println("Admin code is invalid.\nEnter the correct code or register as a public user.\nPress Q to quit.");
                    System.out.print("Do you want to continue as a public user? (yes/no): ");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("Q")) {
                        return;
                    } else if (choice.equalsIgnoreCase("yes")) {
                        userType = "public";
                        break;
                    }
                }
            }
        } else if (!userType.equals("public")) {
            System.out.println("Invalid user type. Please enter 'public' or 'admin'.");
            return;
        }

        currentUser = userService.register(name, email, phoneNumber, username, password, userType);
        System.out.println("User registered successfully!");
    }

    private static void login() {
        System.out.println("Login");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        currentUser = userService.login(username, password);

        if (currentUser != null) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void showUserMenu() {
        System.out.println("Welcome, " + currentUser.getUsername());
        System.out.println("1. Profile");
        System.out.println("2. Climate Data");
        System.out.println("3. Education Material");
        System.out.println("4. FAQs");
        if (currentUser.getUserType().equals("admin")) {
            System.out.println("5. Admin Menu");
            System.out.println("6. Logout");
        } else {
            System.out.println("5. Logout");
        }

        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        showProfileMenu();
                        break;
                    case 2:
                        showClimateMenu();
                        break;
                    case 3:
                        showEducationMenu();
                        break;
                    case 4:
                        showFAQMenu();
                        break;
                    case 5:
                        if (currentUser.getUserType().equals("admin")) {
                            showAdminMenu();
                            break;
                        }
                        // Fall through if user is not admin
                    case 6:
                        logout();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        choice = -1; // Reset choice to stay in loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void showProfileMenu() {
        System.out.println("Profile Menu");
        System.out.println("1. View Profile");
        System.out.println("2. Update Profile");
        System.out.println("3. Delete Profile");
        System.out.println("4. Back to Main Menu");

        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        viewProfile();
                        break;
                    case 2:
                        updateProfile();
                        break;
                    case 3:
                        deleteProfile();
                        break;
                    case 4:
                        return; // Back to main menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        choice = -1; // Reset choice to stay in loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void showClimateMenu() {
        System.out.println("Climate Data Menu");
        System.out.println("1. View Climate Data");
        if (currentUser.getUserType().equals("admin")) {
            System.out.println("2. Add Climate Data");
            System.out.println("3. Edit Climate Data");
            System.out.println("4. Delete Climate Data");
            System.out.println("5. Back to Main Menu");
        } else {
            System.out.println("2. Back to Main Menu");
        }

        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        viewClimateData();
                        break;
                    case 2:
                        if (currentUser.getUserType().equals("admin")) {
                            addClimateData();
                            break;
                        }
                        // Fall through if user is not admin
                    case 3:
                        if (currentUser.getUserType().equals("admin")) {
                            editClimateData();
                            break;
                        }
                        // Fall through if user is not admin
                    case 4:
                        if (currentUser.getUserType().equals("admin")) {
                            deleteClimateData();
                            break;
                        }
                        // Fall through if user is not admin
                    case 5:
                        return; // Back to main menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        choice = -1; // Reset choice to stay in loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void showEducationMenu() {
        System.out.println("Education Material Menu");
        System.out.println("1. View Education Material");
        if (currentUser.getUserType().equals("admin")) {
            System.out.println("2. Add Education Material");
            System.out.println("3. Update Education Material");
            System.out.println("4. Delete Education Material");
            System.out.println("5. Back to Main Menu");
        } else {
            System.out.println("2. Back to Main Menu");
        }

        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        viewEducationMaterial();
                        break;
                    case 2:
                        if (currentUser.getUserType().equals("admin")) {
                            addEducationMaterial();
                            break;
                        }
                        // Fall through if user is not admin
                    case 3:
                        if (currentUser.getUserType().equals("admin")) {
                            updateEducationMaterial();
                            break;
                        }
                        // Fall through if user is not admin
                    case 4:
                        if (currentUser.getUserType().equals("admin")) {
                            deleteEducationMaterial();
                            break;
                        }
                        // Fall through if user is not admin
                    case 5:
                        return; // Back to main menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        choice = -1; // Reset choice to stay in loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void showFAQMenu() {
        System.out.println("FAQs");
        System.out.println("Resources courtesy of United States Environmental Protection Agency");
        for (int i = 0; i < faq.getFaqs().size(); i++) {
            System.out.println((i + 1) + ". " + faq.getFaqs().get(i).getQuestion());
        }
        System.out.println((faq.getFaqs().size() + 1) + ". Back to Main Menu");

        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice == faq.getFaqs().size() + 1) {
                    return; // Back to main menu
                } else if (choice > 0 && choice <= faq.getFaqs().size()) {
                    showFAQDetail(choice - 1);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                    choice = -1; // Reset choice to stay in loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void showFAQDetail(int index) {
        FAQ.QuestionAnswer qa = faq.getFAQ(index);
        System.out.println("Question: " + qa.getQuestion());
        System.out.println("Answer: " + qa.getAnswer());
        System.out.println("1. Back to FAQs");

        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice == 1) {
                    return; // Back to FAQs
                } else {
                    System.out.println("Invalid choice. Please try again.");
                    choice = -1; // Reset choice to stay in loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void showAdminMenu() {
        System.out.println("Admin Menu");
        System.out.println("1. Admin Update User");
        System.out.println("2. Admin View User Profile");
        System.out.println("3. Manage FAQs");
        System.out.println("4. Back to Main Menu");

        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        adminUpdateUser();
                        break;
                    case 2:
                        adminViewUserProfile();
                        break;
                    case 3:
                        manageFAQs();
                        break;
                    case 4:
                        return; // Back to main menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        choice = -1; // Reset choice to stay in loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void manageFAQs() {
        System.out.println("Manage FAQs");
        System.out.println("1. Add FAQ");
        System.out.println("2. Update FAQ");
        System.out.println("3. Delete FAQ");
        System.out.println("4. Back to Admin Menu");

        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        addFAQ();
                        break;
                    case 2:
                        updateFAQ();
                        break;
                    case 3:
                        deleteFAQ();
                        break;
                    case 4:
                        return; // Back to admin menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        choice = -1; // Reset choice to stay in loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void addFAQ() {
        System.out.print("Enter FAQ question: ");
        String question = scanner.nextLine();
        System.out.print("Enter FAQ answer: ");
        String answer = scanner.nextLine();
        faq.addFAQ(question, answer);
        System.out.println("FAQ added successfully!");
    }

    private static void updateFAQ() {
        System.out.println("Select FAQ to update:");
        for (int i = 0; i < faq.getFaqs().size(); i++) {
            System.out.println((i + 1) + ". " + faq.getFaqs().get(i).getQuestion());
        }
        System.out.println((faq.getFaqs().size() + 1) + ". Back to Admin Menu");

        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice == faq.getFaqs().size() + 1) {
                    return; // Back to admin menu
                } else if (choice > 0 && choice <= faq.getFaqs().size()) {
                    System.out.print("Enter new FAQ question: ");
                    String question = scanner.nextLine();
                    System.out.print("Enter new FAQ answer: ");
                    String answer = scanner.nextLine();
                    faq.updateFAQ(choice - 1, question, answer);
                    System.out.println("FAQ updated successfully!");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                    choice = -1; // Reset choice to stay in loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void deleteFAQ() {
        System.out.println("Select FAQ to delete:");
        for (int i = 0; i < faq.getFaqs().size(); i++) {
            System.out.println((i + 1) + ". " + faq.getFaqs().get(i).getQuestion());
        }
        System.out.println((faq.getFaqs().size() + 1) + ". Back to Admin Menu");

        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice == faq.getFaqs().size() + 1) {
                    return; // Back to admin menu
                } else if (choice > 0 && choice <= faq.getFaqs().size()) {
                    faq.deleteFAQ(choice - 1);
                    System.out.println("FAQ deleted successfully!");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                    choice = -1; // Reset choice to stay in loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void viewProfile() {
        System.out.println("Profile Details");
        System.out.println("Name: " + currentUser.getName());
        System.out.println("Email: " + currentUser.getEmail());
        System.out.println("Phone Number: " + currentUser.getPhoneNumber());
        System.out.println("Username: " + currentUser.getUsername());
        System.out.println("User Type: " + currentUser.getUserType());
    }

    private static void updateProfile() {
        System.out.println("Update Profile");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        userService.updateUser(currentUser, name, email, phoneNumber, username, password);
        System.out.println("Profile updated successfully!");
    }

    private static void deleteProfile() {
        userService.deleteUser(currentUser);
        currentUser = null;
        System.out.println("Profile deleted successfully!");
    }

    private static void logout() {
        userService.logout(currentUser);
        currentUser = null;
    }

    private static void adminUpdateUser() {
        System.out.println("Admin Update User");

        System.out.print("Target Username: ");
        String targetUsername = scanner.nextLine();

        User targetUser = null;
        for (User user : userService.getUsers()) {
            if (user.getUsername().equals(targetUsername)) {
                targetUser = user;
                break;
            }
        }

        if (targetUser == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("User Type (public/admin): ");
        String userType = scanner.nextLine();

        userService.adminUpdateUser(currentUser, targetUser, name, email, phoneNumber, username, password, userType);
        System.out.println("User updated successfully!");
    }

    private static void adminViewUserProfile() {
        System.out.println("Admin View User Profile");

        System.out.print("Target Username: ");
        String targetUsername = scanner.nextLine();

        User targetUser = null;
        for (User user : userService.getUsers()) {
            if (user.getUsername().equals(targetUsername)) {
                targetUser = user;
                break;
            }
        }

        if (targetUser == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Profile Details");
        System.out.println("Name: " + targetUser.getName());
        System.out.println("Email: " + targetUser.getEmail());
        System.out.println("Phone Number: " + targetUser.getPhoneNumber());
        System.out.println("Username: " + targetUser.getUsername());
        System.out.println("User Type: " + targetUser.getUserType());
    }

    private static void viewClimateData() {
        climateData.displayClimateData();
    }

    private static void addClimateData() {
        System.out.println("Add Climate Data");

        System.out.print("Enter climate data: ");
        String data = scanner.nextLine();

        climateData.addData(data);
        System.out.println("Climate data added successfully!");
    }

    private static void editClimateData() {
        System.out.println("Edit Climate Data");

        System.out.print("Enter index of climate data to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new climate data: ");
        String newData = scanner.nextLine();

        climateData.editData(index, newData);
        System.out.println("Climate data updated successfully!");
    }

    private static void deleteClimateData() {
        System.out.println("Delete Climate Data");

        System.out.print("Enter index of climate data to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        climateData.deleteData(index);
        System.out.println("Climate data deleted successfully!");
    }

    private static void viewEducationMaterial() {
        educationMaterial.viewMaterial();
    }

    private static void addEducationMaterial() {
        System.out.println("Add Education Material");

        System.out.print("Enter educational material: ");
        String material = scanner.nextLine();

        educationMaterial.addMaterial(material);
        System.out.println("Educational material added successfully!");
    }

    private static void updateEducationMaterial() {
        System.out.println("Update Education Material");

        System.out.print("Enter index of educational material to update: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new educational material: ");
        String newMaterial = scanner.nextLine();

        educationMaterial.updateMaterial(index, newMaterial);
        System.out.println("Educational material updated successfully!");
    }

    private static void deleteEducationMaterial() {
        System.out.println("Delete Education Material");

        System.out.print("Enter index of educational material to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        educationMaterial.deleteMaterial(index);
        System.out.println("Educational material deleted successfully!");
    }
}