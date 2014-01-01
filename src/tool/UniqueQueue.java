package tool;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UniqueQueue<T> implements Queue<T>
{
    protected final Queue<T> queue = new LinkedList<T>();
    protected final Set<T>   set   = new HashSet<T>();

    public boolean add(T t)
    {
        // Only add element to queue if the set does not contain the specified element.
        if (set.add(t))
        {
            queue.add(t);
        }

        return true; // Must always return true as per API def.
    }

    public T remove() throws NoSuchElementException
    {
        T ret = queue.remove();
        set.remove(ret);
        return ret;
    }

    @Override
    public int size()
    {
        return queue.size();
    }

    @Override
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return queue.contains(o);
    }

    @Override
    public Iterator<T> iterator()
    {
        return queue.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return queue.toArray();
    }

    @SuppressWarnings("hiding")
    @Override
    public <T> T[] toArray(T[] a)
    {
        return queue.toArray(a);
    }

    @Override
    public boolean remove(Object o)
    {
        if (set.remove(o))
        {
            queue.remove(o);
            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return queue.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        for (T elt : c)
        {
            if (!add(elt))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        for (Object elt : c)
        {
            if (!remove(elt))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        throw new NotImplementedException();
    }

    @Override
    public void clear()
    {
        queue.clear();
        set.clear();
    }

    @Override
    public boolean offer(T e)
    {
        throw new NotImplementedException();
    }

    @Override
    public T poll()
    {
        T elt = queue.poll();
        set.remove(elt);
        return elt;
    }

    @Override
    public T element()
    {
        return queue.element();
    }

    @Override
    public T peek()
    {
        return queue.peek();
    }

}
