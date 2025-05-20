// Método privado para recorrido postOrden: izquierda, derecha, nodo
private void postOrder(Node<E> node) {
    if (node != null) {
        postOrder(node.left);              // Recorre subárbol izquierdo
        postOrder(node.right);             // Recorre subárbol derecho
        System.out.print(node.data + " "); // Visita la raíz (al final)
    }
}
