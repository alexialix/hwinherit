package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchQueryInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Assertions.assertTrue(simpleTask.matches("Позвонить"));
    }

    @Test
    public void shouldNotMatchQueryInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Assertions.assertFalse(simpleTask.matches("Встреча"));
    }

    @Test
    public void shouldMatchQueryInEpic() {
        String[] subtasks = {"Купить молоко", "Купить хлеб"};
        Epic epic = new Epic(2, subtasks);
        Assertions.assertTrue(epic.matches("молоко"));
    }

    @Test
    public void shouldNotMatchQueryInEpic() {
        String[] subtasks = {"Купить молоко", "Купить хлеб"};
        Epic epic = new Epic(2, subtasks);
        Assertions.assertFalse(epic.matches("Постельное белье"));
    }

    @Test
    public void shouldMatchQueryInMeetingTopic() {
        Meeting meeting = new Meeting(3, "Релиз нового продукта", "Проект Икс", "Понедельник");
        Assertions.assertTrue(meeting.matches("Релиз"));
    }

    @Test
    public void shouldMatchQueryInMeetingProject() {
        Meeting meeting = new Meeting(3, "Релиз нового продукта", "Проект Икс", "Понедельник");
        Assertions.assertTrue(meeting.matches("Икс"));
    }

    @Test
    public void shouldNotMatchQueryInMeeting() {
        Meeting meeting = new Meeting(3, "Релиз нового продукта", "Проект Икс", "Понедельник");
        Assertions.assertFalse(meeting.matches("Встреча"));
    }
}
