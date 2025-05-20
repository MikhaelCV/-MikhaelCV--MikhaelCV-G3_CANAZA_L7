package bstreeInterface;

public interface BinarySearchTree<E extends Comparable<E>> {

    boolean isEmpty();

    void insert(E x) throws Exception;

    E search(E x) throws Exception;

    void delete(E x) throws Exception;

    String toString();

    void destroyNodes() throws Exception;

    int countAllNodes();

    int countNodes();

    int height(E x);

    int amplitude(int level);

    int areaBST();

    void drawBST();

    void parenthesize();

    boolean sameArea(Object anotherTree);
} 
