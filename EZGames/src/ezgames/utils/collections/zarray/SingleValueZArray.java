package ezgames.utils.collections.zarray;

import java.util.Iterator;
import java.util.Optional;
import ezgames.annotations.Immutable;
import ezgames.math.hashing.HashGenerator;

@Immutable
final class SingleValueZArray<E> implements ZArray<E>
{
	//***************************************************************************
	// Public constructors
	//***************************************************************************
	public SingleValueZArray(E o)
	{
		item = o;
	}
	
	//***************************************************************************
	// Public API methods
	//***************************************************************************
	@SuppressWarnings("unchecked")
	public E[] asArray()
	{
		Object[] arr = {item};
		return (E[]) arr;
	}
	
	public boolean contains(E obj)
	{
		return item.equals(obj);
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object o)
	{
		// quick check
		if (o == item)
		{
			return true;
		}
		
		// type check
		SingleValueZArray<E> other;
		if (o instanceof SingleValueZArray<?>)
		{
			other = (SingleValueZArray<E>) o;
			return item.equals(other.item);
		}
		else
		{
			return false;
		}
	}
	
	public E get(int index)
	{
		if (index != 0)
		{
			throw new IndexOutOfBoundsException();
		}
		return item;
	}
	
	public int hashCode()
	{
		HashGenerator hasher = HashGenerator.createWithDefaultHashAlgorithm();
		int curr = hasher.getStartingValue();
		return hasher.hash(item, curr);
	}
	
	public Optional<Integer> indexOf(E obj)
	{
		if(item.equals(obj))
		{
			return Optional.of(0);
		}
		else
		{
			return Optional.empty();
		}
	}
	
	public Iterator<E> iterator()
	{
		return new SingleValueArrayIterator<E>(this);
	}
	
	public int size()
	{
		return 1;
	}
	
	// TODO toString()
	//***************************************************************************
	// Private fields
	//***************************************************************************
	private final E item;
	
	//***************************************************************************
	// Private Iterator Class
	//***************************************************************************
	private static final class SingleValueArrayIterator<T> implements Iterator<T>
	{
		private final SingleValueZArray<T> arr;
		private boolean hasNext = true;
		
		public SingleValueArrayIterator(SingleValueZArray<T> inArr)
		{
			arr = inArr;
		}
		
		
		public boolean hasNext()
		{
			return hasNext;
		}
		
		
		public T next()
		{
			if (hasNext)
			{
				hasNext = false;
				return arr.item;
			}
			return null;
		}
		
		
		public void remove()
		{
			throw new UnsupportedOperationException("ZArray is Immutable and does not allow removing elements");
		}
	}
}
