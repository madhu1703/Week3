import java.lang.*;
import java.util.*;
import java.util.*;

class Process {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int processCount = 0;

    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        processCount++;
    }

    public void removeProcess(int pid) {
        if (head == null) return;

        Process current = head;
        Process prev = tail;
        do {
            if (current.pid == pid) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                processCount--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process current = head;
        System.out.print("Processes in queue: ");
        do {
            System.out.print("[PID: " + current.pid + ", RT: " + current.remainingTime + "] ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public void simulateScheduling(int timeQuantum) {
        if (head == null) return;

        int time = 0;
        List<Process> completed = new ArrayList<>();
        Process current = head;

        System.out.println("Starting Round Robin Scheduling with Time Quantum = " + timeQuantum + "\n");

        while (processCount > 0) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                System.out.println("Executing Process " + current.pid + " for " + execTime + " units.");
                current.remainingTime -= execTime;
                time += execTime;
                Process temp = head;
                do {
                    if (temp != current && temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                } while (temp != head);

                if (current.remainingTime == 0) {
                    current.turnaroundTime = time;
                    completed.add(current);
                    removeProcess(current.pid);
                    current = tail.next;
                } else {
                    current = current.next;
                }

                displayProcesses();
                System.out.println();
            } else {
                current = current.next;
            }
        }
        System.out.println("All processes completed.\n");
        int totalWT = 0, totalTAT = 0;
        System.out.println("PID\tBurst\tPriority\tWaiting\tTurnaround");
        for (Process p : completed) {
            System.out.println(p.pid + "\t" + p.burstTime + "\t" + p.priority + "\t\t" +
                    p.waitingTime + "\t" + p.turnaroundTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.println("\nAverage Waiting Time: " + (float) totalWT / completed.size());
        System.out.println("Average Turnaround Time: " + (float) totalTAT / completed.size());
    }
}
class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        int timeQuantum = 4;

        scheduler.simulateScheduling(timeQuantum);
    }
}

