package me.salmonmoses.core;

import java.util.LinkedList;
import java.util.function.Consumer;

public class Observable<T> {
	private T value;
	private final LinkedList<Consumer<T>> listeners = new LinkedList<>();

	public Observable(T initial) {
		setValue(initial);
	}
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
		listeners.forEach(listener -> listener.accept(value));
	}

	public void addListener(Consumer<T> listener) {
		if (listener != null) {
			listeners.add(listener);
			listener.accept(value);
		}
	}

	public void removeListener(Consumer<T> listener) {
		if (listener != null) {
			listeners.remove(listener);
		}
	}
}
