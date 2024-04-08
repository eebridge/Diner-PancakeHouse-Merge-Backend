package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponent> {

    Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.peek() != null) {
            if (stack.peek().hasNext()) {
                return true;
            }
            else {
                stack.pop();
                if (stack.peek() != null) {
                    if (stack.peek().hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public MenuComponent next() {
        return stack.peek().next();
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}