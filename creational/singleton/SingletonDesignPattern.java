package org.aditya.designpatterns;

/**
 * Singleton Design Pattern is commonly used pattern in software development
 * design. It ensures that there will be only one object for this class. It
 * needs to work fine in following scenarios: 1) Multithreading 2) Clonable 3)
 * Serialization 4)
 *
 */
public class SingletonDesignPattern {

	/*
	 * Instance of SingleDesignPattern class
	 */
	private static SingletonDesignPattern singletonDesignPattern;

	/*
	 * Private Constructor to make sure it is inaccessible from outside
	 */
	private SingletonDesignPattern() {
	}

	/**
	 * API to get singleton instance of {@link SingletonDesignPattern}
	 * 
	 * @return instance of {@link SingletonDesignPattern}
	 */
	public SingletonDesignPattern getInstance() {
		if (singletonDesignPattern == null) {
			singletonDesignPattern = new SingletonDesignPattern();
		}
		return singletonDesignPattern;
	}
}
