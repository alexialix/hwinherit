package ru.netology;

public class Meeting extends Task {
    private final String topic;
    private final String project;
    private final String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        // Проверяем, что topic и project не равны null, чтобы избежать ошибок NullPointerException
        if (topic != null && topic.contains(query)) {
            return true;
        }
        return project != null && project.contains(query);
    }
}
