// Método privado para recorrido en preOrden: nodo, izquierda, derecha
private void preOrder(Node<E> node) {
    if (node != null) {
        System.out.print(node.data + " "); // Visitar la raíz
        preOrder(node.left);               // Recorre subárbol izquierdo
        preOrder(node.right);              // Recorre subárbol derecho
    }
}
