package org.aditya.designpatterns.singleton;

import java.io.Serializable;

/**
 * Singleton Design Pattern is commonly used pattern in software development
 * design. It ensures that there will be only one object for this class. It
 * needs to work fine in following scenarios: 1) Multithreading 2) Clonable 3)
 * Serialization
 *
 */
@SuppressWarnings("serial")
public class SingletonDesignPattern implements Cloneable, Serializable {

	/*
	 * Instance of SingleDesignPattern class
	 */
	private static volatile SingletonDesignPattern singletonDesignPattern = null;

	/*
	 * Private Constructor to make sure it is inaccessible from outside
	 */
	private SingletonDesignPattern() {
	}

	/**
	 * API to get singleton instance of {@link SingletonDesignPattern}. In this API,
	 * double null check logic has been applied to support singleton pattern in
	 * multi threading environment
	 * 
	 * @return instance of {@link SingletonDesignPattern}
	 */
	public static SingletonDesignPattern getInstance() {
		if (singletonDesignPattern == null) {
			synchronized (SingletonDesignPattern.class) {
				if (singletonDesignPattern == null) {
					singletonDesignPattern = new SingletonDesignPattern();
				}
			}
		}
		return singletonDesignPattern;
	}
	
	/**
	 * Overridden API clone in order to make sure there will only one object for {@link SingletonDesignPattern}
	 * 
	 * @throws CloneNotSupportedException whenever this method will be called exception will be thrown
	 */
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException("Clone operation is not supported on Singleton object");
		
	}

	/**
	 * API added to handle the serialization use case for maintaining singleton behavior
	 *  
	 * @return object after deserialization is completed
	 */
	protected Object readResolve()
	{
		return getInstance();
	}
}
