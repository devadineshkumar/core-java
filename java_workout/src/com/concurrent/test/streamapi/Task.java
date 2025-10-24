package com.concurrent.test.streamapi;

public class Task {
    private final int id;
    private final String name;
    private final String department;
    private final String destination;
    private final long timeMillis;

    public Task(int id, String name, String department, String destination, long timeMillis) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.destination = destination;
        this.timeMillis = timeMillis;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getDestination() {
        return destination;
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    @Override
    public String toString() {
        return "Task{id=" + id + ", name='" + name + "', department='" + department + "', destination='" + destination + "', timeMillis=" +
                timeMillis + "}";
    }
}
