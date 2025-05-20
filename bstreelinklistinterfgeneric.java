package bstreelinklistinterfgeneric;

import bstreeInterface.BinarySearchTree;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    // Clase interna Node que representa cada nodo del árbol
    protected static class Node<E> {
        E data;
        Node<E> left, right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    protected Node<E> root; // Raíz del árbol

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    // Método público para insertar un elemento
    @Override
    public void insert(E x) throws ItemDuplicated {
        root = insertRec(root, x);
    }

    // Método privado recursivo para insertar, validando duplicados
    private Node<E> insertRec(Node<E> node, E x) throws ItemDuplicated {
        if (node == null) return new Node<>(x);

        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            node.left = insertRec(node.left, x);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, x);
        } else {
            throw new ItemDuplicated("Elemento duplicado: " + x);
        }
        return node;
    }

    // Método público para buscar un elemento
    @Override
    public E search(E x) throws ItemNotFound {
        return searchRec(root, x);
    }

    // Método recursivo para buscar un elemento
    private E searchRec(Node<E> node, E x) throws ItemNotFound {
        if (node == null) throw new ItemNotFound("Elemento no encontrado: " + x);

        int cmp = x.compareTo(node.data);
        if (cmp < 0) return searchRec(node.left, x);
        else if (cmp > 0) return searchRec(node.right, x);
        else return node.data;
    }

    // Método público para eliminar un elemento
    @Override
    public void delete(E x) throws ItemNotFound, ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("El árbol está vacío");
        root = deleteRec(root, x);
    }

    // Método recursivo para eliminar un elemento del árbol
    private Node<E> deleteRec(Node<E> node, E x) throws ItemNotFound {
        if (node == null) throw new ItemNotFound("Elemento no encontrado: " + x);

        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            node.left = deleteRec(node.left, x);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, x);
        } else {
            // Nodo encontrado
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Nodo con dos hijos
            Node<E> min = findMin(node.right); // sucesor inOrden
            node.data = min.data;
            node.right = deleteRec(node.right, min.data); // eliminar el sucesor
        }
        return node;
    }

    // Encuentra el nodo con el valor mínimo del subárbol
    private Node<E> findMin(Node<E> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Devuelve una representación en texto del recorrido inOrden del BST
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrderRec(root, sb);
        return sb.toString().trim(); // Eliminar espacio final
    }

    // Método auxiliar para recorrido inOrden
    private void inOrderRec(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrderRec(node.left, sb);
            sb.append(node.data).append(" ");
            inOrderRec(node.right, sb);
        }
    }
}
