// Método privado para recorrer el árbol en orden (inOrder)
private void inOrder(Node<E> node) {
    if (node != null) {
        inOrder(node.left);             // Recorre el subárbol izquierdo
        System.out.print(node.data + " "); // Imprime el dato del nodo actual
        inOrder(node.right);            // Recorre el subárbol derecho
    }
}
