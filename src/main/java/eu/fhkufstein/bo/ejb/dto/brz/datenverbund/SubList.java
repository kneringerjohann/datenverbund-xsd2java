package eu.fhkufstein.bo.ejb.dto.brz.datenverbund;

import java.io.Serializable;
import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Delegate-List. Sorgt daf&uuml;r, dass aus einer Liste mit unterschiedlichen
 * Datentypen nur jene mit einem bestimmten Typ sichtbar sind. Es k&ouml;nnen
 * Einzelelemente zur Liste hinzugef&uuml;gt werden. Alle anderen &Auml;nderungsoperationen
 * sind gesperrt.
 * 
 * @author Bundesrechenzentrum GmbH
 *
 * @param <S> Jener Datentyp, der in der Liste sichtbar ist.
 */
public class SubList<S> extends LinkedList<S> {
	
	private final List<Serializable> master;
	private final Class<? extends Serializable> childs;
	
	private final static long serialVersionUID = 2934875029384570L;
	
	@SuppressWarnings("unchecked")
	private void refresh() {
		super.clear();
		for (Serializable item : master) {
			if (item.getClass().equals(childs))
				super.add((S) item);
		}
//		super.addAll((List<S>) master.stream().filter(s -> (s.class.equals(childs)))
//				.collect(java.util.stream.Collectors.toList()));
	}
	
	public SubList(List<Serializable> master, Class<? extends Serializable> childs) {
		this.master = master;
		this.childs = childs;
		refresh();
	}

	@Override
	public boolean add(Object e) {
		return master.add((Serializable) e);
	}

	@Override
	public boolean addAll(Collection<? extends S> c) {
        return addAll(0, c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean addAll(int index, Collection<? extends S> c) {
		if ( master.addAll(index, (Collection<? extends Serializable>) c)) {
			refresh();
			return true;
		}
		return false;
	}

	@Override
	public void replaceAll(UnaryOperator<S> operator) {
        throw new UnsupportedOperationException();
	}

	@Override
	public void sort(Comparator<? super S> c) {
        throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(IntFunction<T[]> generator) {
        throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeIf(Predicate<? super S> filter) {
        throw new UnsupportedOperationException();
	}

	@Override
	public S removeFirst() {
        throw new UnsupportedOperationException();
	}

	@Override
	public S removeLast() {
        throw new UnsupportedOperationException();
	}

	@Override
	public void addFirst(S e) {
        throw new UnsupportedOperationException();
	}

	@Override
	public void addLast(S e) {
        throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
        throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
        throw new UnsupportedOperationException();
	}

	@Override
	public S set(int index, S element) {
        throw new UnsupportedOperationException();
	}

	@Override
	public S remove(int index) {
        throw new UnsupportedOperationException();
	}

	@Override
	public S remove() {
        throw new UnsupportedOperationException();
	}

	@Override
	public void push(S e) {
        throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
        throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
        throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<S> descendingIterator() {
        throw new UnsupportedOperationException();
	}

	@Override
	public Object clone() {
        throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
        throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
	}

	@Override
	public Spliterator<S> spliterator() {
        throw new UnsupportedOperationException();
	}

	@Override
	public List<S> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
	}
}
