package algorithms.repeat;

import java.util.ArrayList;
import java.util.Iterator;

public class Peeking_Iterator_284 {
  class PeekingIterator<E> implements Iterator<E> {
    Iterator<E> itor = null;
    E next = null;

    public PeekingIterator(Iterator<E> iterator) {
      itor = iterator;
      if(iterator.hasNext()) {
        next = itor.next();
      }
    }

    @Override
    public boolean hasNext() {
      return next != null;
    }

    @Override
    public E next() {
      E cur = next;
      if(itor.hasNext()) {
        next = itor.next();
      } else {
        next = null;
      }
      return cur;
    }
  }
}
