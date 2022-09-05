package me.salmonmoses.lab1;

import java.util.Optional;

public record Segment(double start, double finish) {
	public Segment {
		if (finish < start) {
			throw new IllegalArgumentException("Відрізок повинен закінчуватися правіше кінця");
		}
	}

	public boolean contains(Segment other) {
		return this.start <= other.start && this.finish >= other.finish;
	}

	public boolean includedIn(Segment other) {
		return this.start >= other.start && this.finish <= other.finish;
	}

	public boolean intersectsWithButNotIncluded(Segment other) {
		if (this.start <= other.start) {
			return this.finish > other.start && this.finish < other.finish;
		} else if (this.start >= other.start) {
			return this.finish < other.start && this.finish > other.finish;
		}

		return false;
	}

	public double length() {
		return finish - start;
	}

	public Optional<Segment> intersection(Segment other) {
		if (contains(other)) {
			return Optional.of(other);
		} else if (includedIn(other)) {
			return Optional.of(this);
		} else if (intersectsWithButNotIncluded(other)) {
			return Optional.of(new Segment(Math.max(start, other.start), Math.min(finish, other.finish)));
		} else {
			return Optional.empty();
		}
	}
}
