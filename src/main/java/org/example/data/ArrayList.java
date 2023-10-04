package org.example.data;

public class ArrayList<T> implements AbstractArray<T> {
    public ArrayList() {
        _array = new Object[_count];
    }

    public ArrayList(int count) {
        _count = count;
        _array = new Object[_count];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) throws IndexOutOfBoundsException {
        if (checkIndex(index))
            throw new IndexOutOfBoundsException("The index out of the array");

        return (T) _array[index];
    }

    @Override
    public void set(int index, T object) throws IndexOutOfBoundsException {
        if (checkIndex(index))
            throw new IndexOutOfBoundsException("The index out of the array");

        _array[index] = object;
    }

    @Override
    public void add(T object) {
        if (_size == _count)
            updateCount((int) (_count * _ratio));

        _array[_size] = object;
        _size += 1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[_size];
        System.arraycopy(_array, 0, array, 0, _size);
        return array;
    }

    @Override
    public void add(T object, int index) throws IndexOutOfBoundsException {
        if (checkIndex(index))
            throw new IndexOutOfBoundsException("The index out of the array");

        if (_size == _count)
            updateCount((int) (_count * _ratio));

        shiftRight(index, 1);

        _array[index] = object;
        _size += 1;
    }

    @Override
    public boolean remove(T object) {
        int index = indexOf(object);
        if (checkIndex(index))
            return false;

        shiftLeft(index + 1, 1);
        _size -= 1;

        return true;
    }

    @Override
    public void removeAt(int index) throws IndexOutOfBoundsException {
        if (checkIndex(index))
            throw new IndexOutOfBoundsException("The index out of the array");


        shiftLeft(index + 1, 1);
        _size -= 1;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public boolean isEmpty() {
        return _size == 0;
    }

    @Override
    public boolean contains(T object) {
        return indexOf(object) != -1;
    }

    @Override
    public int indexOf(T object) {
        for (int i = 0; i < _size; i++) {
            if (_array[i].equals(object))
                return i;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(T object) {
        for (int i = _size - 1; i >= 0; i--) {
            if (_array[i].equals(object))
                return i;
        }

        return -1;
    }

    @Override
    public void clear() {
        _count = 10;
        _array = new Object[_count];
        _size = 0;
    }

    private void updateCount(int newCount) {
        Object[] newArray = new Object[newCount];

        System.arraycopy(_array, 0, newArray, 0, _size);

        _array = newArray;
        _count = newCount;
    }

    private void shiftRight(int index, int shift) {
        for (int i = _size - 1; i >= index; i--) {
            if (i + shift >= _count)
                continue;
            _array[i + shift] = _array[i];
        }
    }

    private void shiftLeft(int index, int shift) {
        for (int i = index; i < _size; i++) {
            if (i - shift < 0)
                continue;
            _array[i - shift] = _array[i];
        }
    }

    boolean checkIndex(int index) {

        return index < 0 || index >= _size;

    }

    private int _size = 0;
    private int _count = 10;
    private Object[] _array;
    private final double _ratio = 1.5;
}
