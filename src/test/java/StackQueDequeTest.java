import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.datastructure.lesson3.deque.Deque;
import ru.geekbrains.datastructure.lesson3.deque.DequeImpl;
import ru.geekbrains.datastructure.lesson3.queue.Queue;
import ru.geekbrains.datastructure.lesson3.queue.QueueImpl;
import ru.geekbrains.datastructure.lesson3.stack.Stack;
import ru.geekbrains.datastructure.lesson3.stack.StackImpl;

public class StackQueDequeTest {
    private Queue<Integer> queue;
    private Deque<Integer> deq;
    private Stack<Integer> stack;

    @BeforeEach
    public void prepare (){
         queue = new QueueImpl<>(5);
         deq = new DequeImpl<>(5);
         stack = new StackImpl<>(5);
    }

    @Test
    public void testRemoveStack() {
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    stack.pop();

        Assertions.assertEquals((Object) 4,stack.peek());
    }

    @Test
    public void testRemoveQueue() {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        queue.remove();

        Assertions.assertEquals((Object) 2,queue.peek());
    }

    @Test
    public void testRemoveDequeRight() {
        deq.insertLeft(1);
        deq.insertLeft(2);
        deq.insertLeft(3);
        deq.insertLeft(4);
        deq.insertLeft(5);

        deq.removeRight();

        Assertions.assertEquals((Object) 5,deq.peek());
        Assertions.assertTrue(4 == deq.size());

    }

    @Test
    public void testRemoveDequeLeft() {
        deq.insertRight(1);
        deq.insertRight(2);
        deq.insertRight(3);
        deq.insertRight(4);
        deq.insertRight(5);

        deq.removeLeft();

        Assertions.assertEquals((Object) 2,deq.peek());
        Assertions.assertTrue(4 == deq.size());


    }
}
