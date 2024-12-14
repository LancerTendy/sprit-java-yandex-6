import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List; // Добавьте этот импорт

public class InMemoryHistoryManagerTest {

    @Test
    public void testAddAndGetHistory() {
        InMemoryHistoryManager historyManager = new InMemoryHistoryManager();
        Task task1 = new Task(1, "Test Task 1");
        Task task2 = new Task(2, "Test Task 2");

        historyManager.add(task1);
        historyManager.add(task2);

        List<Task> history = historyManager.getHistory();
        assertEquals(2, history.size());
        assertEquals(task1.getId(), history.get(0).getId());
        assertEquals(task2.getId(), history.get(1).getId());
    }

    @Test
    public void testRemoveTask() {
        InMemoryHistoryManager historyManager = new InMemoryHistoryManager();
        Task task1 = new Task(1, "Test Task 1");
        historyManager.add(task1);

        historyManager.remove(task1.getId());
        List<Task> history = historyManager.getHistory();
        assertEquals(0, history.size());
    }
}
