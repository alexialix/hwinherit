package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Обсуждение версии", "Проект Бета", "Среда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTasksMatchingQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        String[] subtasks = {"Купить молоко", "Купить хлеб"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Релиз нового продукта", "Проект Альфа", "Понедельник");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTasksIfQueryDoesNotMatch() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        String[] subtasks = {"Купить молоко", "Купить хлеб"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Релиз нового продукта", "Проект Альфа", "Понедельник");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Бегать");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMultipleTasksMatchingQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        String[] subtasks = {"Купить молоко", "Обсуждение новой документации"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Обсуждение новой версии", "Проект Альфа", "Среда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting}; // Ожидаем, что найдутся две задачи
        Task[] actual = todos.search("новой");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindExactlyOneTaskMatchingQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        String[] subtasks = {"Купить молоко", "Купить хлеб"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Обсуждение новой версии", "Проект Альфа", "Среда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask}; // Ожидаем, что найдётся ровно одна задача
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoTasksMatchingQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        String[] subtasks = {"Купить молоко", "Купить хлеб"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Обсуждение новой версии", "Проект Альфа", "Среда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {}; // Ожидаем, что не найдётся ни одной задачи
        Task[] actual = todos.search("Танцы");
        Assertions.assertArrayEquals(expected, actual);
    }
}

