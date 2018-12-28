

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> {
	private E [] a;
	private int size = 0;
	public int length;
	MyArrayList(int arraySize){
		a =  (E[])new Object[arraySize];
		length = arraySize;
	}
	public boolean add(E e) {
		if(a.length>size) {
			a[size++]= e;
			return true;
		}
		else {
			a=Arrays.copyOf(a, 2*a.length);
			a[size++] = e;
			return true;
		}
	}
	public int size() {
		return size;
	}
	public E remove(int index) {
		if(index>=0) {
			E b = a[size];
			a[size--] = null;
			return b;
		}
		return null;
	}
	public E get(int index) {
		if(index>=0) {
			return a[index];
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public boolean equals(Object otherObject) {
		if(otherObject == this)return true;
		if(otherObject==null)return false;
		if(this.getClass()!=otherObject.getClass())return false;
		MyArrayList<E> other = (MyArrayList<E>)otherObject;
		for(int i=0;i<size+1;i++) {
			if(this.get(i)!=other.get(i))return false;
		}
		return true;
		
	}
	public static Object MycopyOf(Object a,int newLength) {
		Class cl = a.getClass();
		if(!cl.isArray())return null;
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
	}
	public String toString() {
		String s="[";
		for(int i=0;i<size();i++) {
			s+=get(i);
			if(i<size-1)s+=",";
		}
		return s+"]";
		
	}
	public static void main(String[] args) {
		MyArrayList<Integer> ai = new MyArrayList<Integer>(10);
		for(int i=0;i<ai.length;i++) {
			ai.add(i);
		}	
		System.out.println(ai);
		
	}
}
