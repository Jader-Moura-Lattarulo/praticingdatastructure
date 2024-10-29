package br.com.alura.models;

public class Cell {
    private final Object element;
    private Cell next;
    private Cell previous;

    public Cell(Object element) {
        this(null, element);
    }

    public Cell getPrevious() {
        return previous;
    }

    public void setPrevious(Cell previous) {
        this.previous = previous;
    }

    public Cell(Cell next, Object element) {
        this.next = next;
        this.element = element;
    }

    public Object getElement() {
        return element;
    }

    public Cell getNext() {
        return next;
    }

    public void setNext(Cell next) {
        this.next = next;
    }
}
