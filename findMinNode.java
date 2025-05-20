// Método privado para encontrar el nodo con el menor valor
private Node<E> findMinNode(Node<E> node) throws ItemNotFound {
    if (node == null) throw new ItemNotFound("Subárbol vacío");

    while (node.left != null) {
        node = node.left;
    }

    // Validar que el valor existe usando el método search()
    this.search(node.data);

    return node;
}
