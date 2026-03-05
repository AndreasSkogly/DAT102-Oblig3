public class Node<T> implements MengdeADT {
        T element;
        Node<T> neste;

        public Node(T element) {
            this.element = element;
            this.neste = null;
        }
    }
}
