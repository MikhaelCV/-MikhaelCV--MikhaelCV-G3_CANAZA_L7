public E getMin() throws ItemNotFound {
    return findMinNode(root).data;
}

public E getMax() throws ItemNotFound {
    return findMaxNode(root).data;
}
