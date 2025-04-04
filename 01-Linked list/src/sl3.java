import java.lang.*;
import java.util.*;

class FriendNode {
    String friendId;
    FriendNode next;

    public FriendNode(String friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    String userId;
    String name;
    int age;
    FriendNode friendListHead;
    UserNode next;

    public UserNode(String userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendListHead = null;
        this.next = null;
    }

    public void addFriend(String friendId) {
        if (isFriendExists(friendId)) return;
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = friendListHead;
        friendListHead = newFriend;
    }

    public void removeFriend(String friendId) {
        if (friendListHead == null) return;
        if (friendListHead.friendId.equals(friendId)) {
            friendListHead = friendListHead.next;
            return;
        }
        FriendNode current = friendListHead;
        while (current.next != null && !current.next.friendId.equals(friendId)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public boolean isFriendExists(String friendId) {
        FriendNode current = friendListHead;
        while (current != null) {
            if (current.friendId.equals(friendId)) return true;
            current = current.next;
        }
        return false;
    }

    public List<String> getFriendIds() {
        List<String> friends = new ArrayList<>();
        FriendNode current = friendListHead;
        while (current != null) {
            friends.add(current.friendId);
            current = current.next;
        }
        return friends;
    }

    public int countFriends() {
        int count = 0;
        FriendNode current = friendListHead;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

class SocialMedia {
    private UserNode head;

    public void addUser(String userId, String name, int age) {
        if (findUserById(userId) != null) {
            System.out.println("User ID already exists.");
            return;
        }
        UserNode newUser = new UserNode(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    public UserNode findUserById(String userId) {
        UserNode current = head;
        while (current != null) {
            if (current.userId.equals(userId)) return current;
            current = current.next;
        }
        return null;
    }

    public void addFriendConnection(String id1, String id2) {
        UserNode user1 = findUserById(id1);
        UserNode user2 = findUserById(id2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        user1.addFriend(id2);
        user2.addFriend(id1);
    }

    public void removeFriendConnection(String id1, String id2) {
        UserNode user1 = findUserById(id1);
        UserNode user2 = findUserById(id2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        user1.removeFriend(id2);
        user2.removeFriend(id1);
    }

    public void findMutualFriends(String id1, String id2) {
        UserNode user1 = findUserById(id1);
        UserNode user2 = findUserById(id2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        List<String> list1 = user1.getFriendIds();
        List<String> list2 = user2.getFriendIds();
        System.out.println("Mutual Friends between " + id1 + " and " + id2 + ":");
        boolean found = false;
        for (String f : list1) {
            if (list2.contains(f)) {
                System.out.println("- " + f);
                found = true;
            }
        }
        if (!found) System.out.println("No mutual friends.");
    }

    public void displayFriends(String userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        List<String> friends = user.getFriendIds();
        System.out.println("Friends of " + user.name + " (" + user.userId + "):");
        for (String f : friends) {
            System.out.println("- " + f);
        }
        if (friends.isEmpty()) {
            System.out.println("No friends found.");
        }
    }

    public void searchUser(String keyword) {
        UserNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.userId.equalsIgnoreCase(keyword) || current.name.equalsIgnoreCase(keyword)) {
                System.out.println("User Found: " + current.name + " | ID: " + current.userId + " | Age: " + current.age);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("User not found.");
    }

    public void countFriendsOfEachUser() {
        UserNode current = head;
        System.out.println("Friend Count per User:");
        while (current != null) {
            System.out.println(current.name + " (" + current.userId + ") has " + current.countFriends() + " friend(s).");
            current = current.next;
        }
    }
}

class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia s = new SocialMedia();
        s.addUser("U001", "Alice", 25);
        s.addUser("U002", "Bob", 24);
        s.addUser("U003", "Charlie", 23);
        s.addUser("U004", "David", 22);

        s.addFriendConnection("U001", "U002");
        s.addFriendConnection("U001", "U003");
        s.addFriendConnection("U002", "U003");
        s.addFriendConnection("U002", "U004");

        System.out.println();
        s.displayFriends("U002");

        System.out.println();
        s.findMutualFriends("U001", "U002");

        System.out.println();
        s.searchUser("U003");

        System.out.println();
        s.countFriendsOfEachUser();

        System.out.println("\nRemoving friend connection between U002 and U003:");
        s.removeFriendConnection("U002", "U003");

        s.displayFriends("U002");
    }
}
