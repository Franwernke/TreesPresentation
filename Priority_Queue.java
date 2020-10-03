import java.util.ArrayList;
import java.util.List;

public class Priority_Queue {
    public List<Integer> Heap;
    public int size;

    public Priority_Queue() {
        Heap = new ArrayList<Integer>();
        Heap.add(-1);
    }

    // Insere um elemento na Heap
    public void insert(int val) {
        Heap.add(val);
        ClimbHeap();        
    }

    // Mantém a regra base de uma Heap após uma inserção
    private void ClimbHeap() {
        Integer cur_index = Heap.size() - 1;
        Integer father = cur_index/2;
        while (cur_index > 1 && Heap.get(cur_index) < Heap.get(father)) {
            swapElementsInHeap(cur_index, father);

            cur_index = father;
            father = cur_index/2;
        }
    }

    // Retorna o mínimo dentro da Heap
    public Integer popMinimum() {
        Integer minVal = Heap.get(1);
        Heap.set(1, Heap.get(Heap.size() - 1));
        Heap.remove(Heap.size() - 1);
        DescendHeap();
        return minVal;
    }

    // Mantém a regra base de uma Heap após uma remoção
    private void DescendHeap() {
        Integer cur_index = 1;
        Integer leftSun = cur_index * 2;
        Integer rightSun = cur_index * 2 + 1;
        while (leftSun < Heap.size() || rightSun < Heap.size()) {
            if (leftSun < Heap.size() && rightSun < Heap.size()) {
                if (Heap.get(leftSun) < Heap.get(rightSun) && Heap.get(leftSun) < Heap.get(cur_index)) {
                    swapElementsInHeap(cur_index, leftSun);
                    cur_index = leftSun;
                }
                else if (Heap.get(rightSun) <= Heap.get(leftSun) && Heap.get(rightSun) < Heap.get(cur_index)) {
                    swapElementsInHeap(cur_index, rightSun);
                    cur_index = rightSun;
                }
                else break;
            }
            else if (leftSun < Heap.size()) {
                if (Heap.get(leftSun) < Heap.get(cur_index)) {
                    swapElementsInHeap(cur_index, leftSun);
                    cur_index = leftSun;
                }
                break;
            }
            else if (Heap.get(rightSun) <= Heap.get(leftSun)) {
                swapElementsInHeap(cur_index, rightSun);
                cur_index = rightSun;        
                break;
            }
            leftSun = cur_index * 2;
            rightSun = cur_index * 2 + 1;
        }
    }
    
    private void swapElementsInHeap(Integer i, Integer j) {
        Integer aux = Heap.get(i);
        Heap.set(i, Heap.get(j));
        Heap.set(j, aux);
    }

    public void printMe() {
        for (int i = 1; i < Heap.size(); i++) {
            System.out.print(" " + Heap.get(i));
        }
    }

    public static void main(String[] args) {
        Priority_Queue PQ = new Priority_Queue();    
        PQ.insert(5);
        PQ.insert(4);
        PQ.insert(2);
        PQ.insert(9);
        PQ.insert(10);
        PQ.insert(40);
        PQ.insert(1);
        PQ.insert(-10);

        PQ.printMe();

        while (PQ.Heap.size() > 1) {
            System.out.println("\nMínimo: " + PQ.popMinimum());
            PQ.printMe();
        }
    }
}
