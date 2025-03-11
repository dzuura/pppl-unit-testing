package org.example;

import java.util.HashSet;
import java.util.Set;

public class UserManager {
    private Set<String> users;

    public UserManager() {
        this.users = new HashSet<>();
    }

    public void addName(String username) {
        users.add(username);
    }

    public void removeName(String username) {
        users.remove(username);
    }

    public Set<String> getUsers() {
        return users;
    }

    public int getUserCount() {
        return users.size();
    }

    public boolean userExist(String username) {
        return users.contains(username);
    }

    public void clearUsername() {
        users.clear();
    }
}
