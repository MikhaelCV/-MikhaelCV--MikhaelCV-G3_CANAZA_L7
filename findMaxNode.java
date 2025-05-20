// Método privado para encontrar el nodo con el mayor valor
private Node<E> findMaxNode(Node<E> node) throws ItemNotFound {
    if (node == null) throw new ItemNotFound("Subárbol vacío");

    while (node.right != null) {
        node = node.right;
    }

    // Validar que el valor existe usando el método search()
    this.search(node.data);

    return node;
}
