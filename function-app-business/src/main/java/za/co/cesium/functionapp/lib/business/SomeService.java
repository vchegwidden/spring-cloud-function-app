package za.co.cesium.functionapp.lib.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SomeService {

    Map<String, User> nameMap = new HashMap<>();
    Map<String, User> usernameMap = new HashMap<>();

    public SomeService(List<User> dbRecords) {
        usernameMap = dbRecords.stream().collect(Collectors.toMap(User::getUsername, user -> user));
        nameMap = dbRecords.stream().collect(Collectors.toMap(User::getFirstName, user -> user));
    }
}

public class User {
    String username;
    String firstName;
    String lastName;
    String department;

    public User(String username, String firstName, String lastName, String department) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }
}
