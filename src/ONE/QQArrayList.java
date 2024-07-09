package ONE;
//2205900101宋玮杰
public class QQArrayList<E> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public QQArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(E element) {
        if (size == array.length) {
            resizeArray();
        }
        array[size++] = element;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (E) array[index];
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        array[index] = element;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        // 检查索引是否在范围内
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        // 将索引后的所有元素向前移动一位
        System.arraycopy(array, index + 1, array, index, size - index - 1);

        // 将数组末尾的元素置为null，以便垃圾回收
        array[size - 1] = null;

        // 减少数组的大小
        size--;
    }

    private void resizeArray() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public static void main(String[] args) {
        QQArrayList<String> list = new QQArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        list.add("Java");

        System.out.println("Initial list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 移除索引为1的元素
        list.remove(1);

        System.out.println("List after removing index 1: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
