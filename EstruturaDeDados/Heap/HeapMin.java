package Heap;

public class HeapMin {
    private int[] data;
    private int counter;
    private boolean canIncrease;

    public HeapMin(int n) {
        this.data = new int[n];
        this.counter = 0;
        this.canIncrease = false;
    }

    public HeapMin() {
        this.data = new int[10];
        this.counter = 0;
        this.canIncrease = false;
    }

    public int lower() {
        if (empty()) {
            throw new RuntimeException("Empty Heap");
        }

        return data[0];
    }

    public boolean empty() {
        return counter == 0;
    }

    public void insert(int value) {
        if (counter == data.length && !canIncrease) {
            throw new RuntimeException("Full Heap");
        } else {
            increase();
        }

        data[counter] = value;
        counter++;
        up(counter - 1);
    }

    private void up(int index) {
        int parentIndex, aux;

        if (index != 0) {
            parentIndex = (index - 1) / 2;

            if (data[parentIndex] > data[index]) {
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
        int leftChildIndex, rightChildIndex, minIndex, aux;

        leftChildIndex = 2 * index + 1;
        rightChildIndex = 2 * index + 2;

        if (rightChildIndex >= counter) {
            if (leftChildIndex >= counter) {
                return;
            } else {
                minIndex = leftChildIndex;
            }
        } else {
            if (data[leftChildIndex] <= data[rightChildIndex]) {
                minIndex = leftChildIndex;
            } else {
                minIndex = rightChildIndex;
            }
        }

        if (data[index] > data[minIndex]) {
            aux = data[minIndex];
            data[minIndex] = data[index];
            data[index] = aux;

            down(minIndex);
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

    private void increase() {
        int[] newData = new int[(int)(data.length * 1.5)];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }
}
