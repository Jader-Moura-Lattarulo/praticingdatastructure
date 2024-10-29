package br.com.alura.models;

public class LinkedList {

    private Cell firstOne = null;
    private Cell lastOne = null;

    private int totalOfElements = 0;

    public void addFirst(Object element) {
        if(this.totalOfElements == 0) {
            this.firstOne = new Cell(element);
            this.lastOne = this.firstOne;
        } else {
            Cell newest = new Cell(this.firstOne, element);
            this.firstOne.setPrevious(newest);
            this.firstOne = newest;
        }
        this.totalOfElements++;
    }

    public void add(Object element) {
        if (this.totalOfElements == 0) {
            addFirst(element);
        } else {
            Cell newest = new Cell(null, element);
            this.lastOne.setNext(newest);
            newest.setPrevious(this.lastOne);
            this.lastOne = newest;
            this.totalOfElements++;
        }
    }

    public void add(int position, Object element) {

        if(position == 0) {
            addFirst(element);
        } else if (position == this.totalOfElements) {
            this.add(element);
        } else {
            Cell previous = this.getCell(position - 1);
            Cell next = previous.getNext();

            Cell newest = new Cell(previous.getNext(), element);
            newest.setPrevious(previous);
            previous.setNext(newest);
            next.setPrevious(newest);
            this.totalOfElements++;
        }

    }

    public Object get(int position) {
        return this.getCell(position).getElement();
    }

    public void remove(int position) {
        if (position == 0) {
            this.removeFromStart();
        } else if (position == this.totalOfElements - 1) {
            this.removeFromEnd();
        } else {
            Cell previous = this.getCell(position - 1);
            Cell current = previous.getNext();
            Cell next = current.getNext();

            previous.setNext(next);
            next.setPrevious(previous);

            this.totalOfElements--;
        }
    }

    public void removeFromEnd() {
        if(this.totalOfElements == 1) {
            removeFromStart();
        } else {
            Cell penultimate = this.lastOne.getPrevious();
            penultimate.setNext(null);
            this.lastOne = penultimate;
            this.totalOfElements--;
        }
    }

    public void removeFromStart() {
        if(this.totalOfElements == 0) throw new IllegalArgumentException("Lista vazia");

        this.firstOne = this.firstOne.getNext();
        this.totalOfElements--;

        if(this.totalOfElements == 0) this.lastOne = null;
    }

    public int size() {
        return this.totalOfElements;
    }

    public boolean contains(Object element) {
        Cell current = this.firstOne;

        while (current != null) {
            if(current.getElement().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public String toString() {
        if(this.totalOfElements == 0) return "[]";

        Cell current = firstOne;

        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalOfElements; i++) {
            builder.append(current.getElement());
            builder.append(",");

            current = current.getNext();
        }

        builder.append("]");

        return builder.toString();
    }

    private boolean positionOccupied(int position) {
        return position >= 0 && position < this.totalOfElements;
    }

    private Cell getCell(int position) {
        if(!positionOccupied(position)) {
            throw new IllegalArgumentException("Posição inexistente");
        }

        Cell current = firstOne;

        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }
        return current;
    }
}

