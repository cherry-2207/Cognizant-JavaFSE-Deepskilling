package com.demo;

public class TaskManagementSystem {

    static class Task {
        private int taskId;
        private String taskName;
        private String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "taskId=" + taskId +
                    ", taskName='" + taskName + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public Task searchTask(int taskId) {
        Node current = head;

        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }

        return null;
    }

    public void traverseTasks() {
        Node current = head;

        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {

        if (head == null) {
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Task Deleted Successfully");
            return;
        }

        Node current = head;

        while (current.next != null &&
                current.next.task.taskId != taskId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Task Deleted Successfully");
        } else {
            System.out.println("Task Not Found");
        }
    }

    public static void main(String[] args) {

        TaskManagementSystem taskList =
                new TaskManagementSystem();

        taskList.addTask(
                new Task(101, "Design UI", "Pending")
        );

        taskList.addTask(
                new Task(102, "Develop Backend", "In Progress")
        );

        taskList.addTask(
                new Task(103, "Testing", "Pending")
        );

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearch Task:");
        System.out.println(taskList.searchTask(102));

        System.out.println("\nDeleting Task 102");
        taskList.deleteTask(102);

        System.out.println("\nTasks After Deletion:");
        taskList.traverseTasks();
    }
}