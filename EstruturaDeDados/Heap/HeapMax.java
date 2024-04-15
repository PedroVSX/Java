package Heap;

public class HeapMax {
    private int[] data;
    private int counter;

    public HeapMax(int n) {
        this.data = new int[n];
        this.counter = 0;
    }

    public int higher() {
        if (empty()) {
            throw new RuntimeException("Empty Heap");
        }

        return data[0];
    }

    public boolean empty() {
        return counter == 0;
    }

    public void insert(int value) {
        if (counter == data.length) {
            throw new RuntimeException("Full Heap");
        }

        data[counter] = value;
        counter++;
        up(counter - 1);
    }

    private void up(int index) {
        int parentIndex, aux;

        if (index != 0) {
            parentIndex = (index - 1) / 2;

            if (data[parentIndex] < data[index]) {
                aux = data[parentIndex];
                data[parentIndex] = data[index];
                data[index] = aux;

                up(parentIndex);
            }
        }
    }

    public void remove() {
        if (empty()) {
            throw new RuntimeException("Empty Heap");
        }

        data[0] = data[counter - 1];
        counter--;

        if (counter > 0) {
            down(0);
        }
    }

    private void down(int index) {
        int leftChildIndex, rightChildIndex, maxIndex, aux;

        leftChildIndex = 2 * index + 1;
        rightChildIndex = 2 * index + 2;

        if (rightChildIndex >= counter) {
            if (leftChildIndex >= counter) {
                return;
            } else {
                maxIndex = leftChildIndex;
            }
        } else {
            if (data[leftChildIndex] >= data[rightChildIndex]) {
                maxIndex = leftChildIndex;
            } else {
                maxIndex = rightChildIndex;
            }
        }

        if (data[index] < data[maxIndex]) {
            aux = data[index];
            data[index] = data[maxIndex];
            data[maxIndex] = aux;

            down(maxIndex);
        }
    }

    public void show() {
        System.out.print("[");
        for (int i = 0; i < counter; i++) {
            if (i == counter - 1) {
                System.out.print(data[i]);
            } else {
                System.out.print(data[i] + ", ");
            }
        }
        System.out.println("]");
    }
}
