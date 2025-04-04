import java.lang.*;
import java.util.*;
class TaskScheduler {
    class Task {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Task next;
        Task(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }
    private Task head = null;
    private Task current = null;
    public void addTaskAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }
    public void addTaskAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }
    public void addTaskAtPosition(int id, String name, int priority, String dueDate, int position) {
        if (position <= 1 || head == null) {
            addTaskAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }
    public void removeTaskById(int id) {
        if (head == null) return;
        Task temp = head;
        Task prev = null;
        do {
            if (temp.taskId == id) {
                if (temp == head) {
                    Task tail = head;
                    while (tail.next != head) {
                        tail = tail.next;
                    }
                    if (head == head.next) {  // only one node
                        head = null;
                        current = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                        current = head;
                    }
                } else {
                    prev.next = temp.next;
                    if (current == temp) {
                        current = temp.next;
                    }
                }
                System.out.println("Task ID " + id + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task ID " + id + " not found.");
    }
    public void viewCurrentTask() {
        if (current != null) {
            System.out.println("Current Task: ID=" + current.taskId + ", Name=" + current.taskName +
                    ", Priority=" + current.priority + ", Due Date=" + current.dueDate);
        } else {
            System.out.println("No current task available.");
        }
    }
    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
            viewCurrentTask();
        } else {
            System.out.println("No task to move to.");
        }
    }
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        System.out.println("All Tasks:");
        do {
            System.out.println("ID=" + temp.taskId + ", Name=" + temp.taskName +
                    ", Priority=" + temp.priority + ", Due Date=" + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int targetPriority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        Task temp = head;
        boolean found = false;
        System.out.println("Tasks with Priority " + targetPriority + ":");
        do {
            if (temp.priority == targetPriority) {
                System.out.println("ID=" + temp.taskId + ", Name=" + temp.taskName +
                        ", Due Date=" + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with that priority.");
        }
    }
}
class Circular {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTaskAtEnd(101, "Write report", 1, "2025-04-20");
        scheduler.addTaskAtBeginning(102, "Design UI", 2, "2025-04-18");
        scheduler.addTaskAtPosition(103, "Fix bugs", 3, "2025-04-19", 2);
        scheduler.displayAllTasks();
        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.searchByPriority(2);
        scheduler.removeTaskById(103);
        scheduler.displayAllTasks();
    }
}