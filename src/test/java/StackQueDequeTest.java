import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.datastructure.lesson3.deque.DequeImpl;
import ru.geekbrains.datastructure.lesson3.queue.Queue;
import ru.geekbrains.datastructure.lesson3.queue.QueueImpl;
import ru.geekbrains.datastructure.lesson3.stack.Stack;
import ru.geekbrains.datastructure.lesson3.stack.StackImpl;

public class StackQueDequeTest {
    private Queue<Integer> queue;
    private Queue<Integer> dequeue;
    private Stack<Integer> stack;

    @BeforeEach
    public void prepare (){
         queue = new QueueImpl<>(5);
         dequeue = new DequeImpl<>(5);
         stack = new StackImpl<>(5);
    }

    @Test
    public void testRemoveStack() {}
    @Test
    public void testRemoveQueue() {}
    @Test
    public void testRemoveDequeRight() {}
    @Test
    public void testRemoveDequeLeft() {}
}
