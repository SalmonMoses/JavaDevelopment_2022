package me.salmonmoses.core;

import java.util.LinkedList;
import java.util.function.Consumer;

public class Observable<T> {
	private T value;
	private final LinkedList<Consumer<T>> listeners = new LinkedList<>();

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
		}
	}

	public void removeListener(Consumer<T> listener) {
		if (listener != null) {
			listeners.remove(listener);
		}
	}
}
