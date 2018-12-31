package org.aditya.designpatterns.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.aditya.designpatterns.singleton.SingletonDesignPattern;
import org.junit.Assert;
import org.junit.Test;

public class TestSingletonDesignPattern {

	@Test
	public void givenSingletonObjectWhenGetInstanceCalledSecondTimeThenSameObjectIsReturned() {
		// Given
		SingletonDesignPattern object1 = SingletonDesignPattern.getInstance();

		// When
		SingletonDesignPattern object2 = SingletonDesignPattern.getInstance();

		// Then
		Assert.assertTrue(object1.equals(object2));
	}

	@Test
	public void givenTwoThreadsWhenTryingToGetInstaceThenSameInstanceIsReturned() {
		// Given
		SingletonDesignPattern object1 = null, object2 = null;
		int numOfThreads = 2;
		ExecutorService executors = Executors.newFixedThreadPool(numOfThreads);

		Future<SingletonDesignPattern> future1 = executors.submit(() -> {
			return SingletonDesignPattern.getInstance();
		});
		Future<SingletonDesignPattern> future2 = executors.submit(() -> {
			return SingletonDesignPattern.getInstance();
		});

		// When
		try {
			object1 = future1.get();
			object2 = future2.get();
		} catch (InterruptedException | ExecutionException e) {
			Assert.assertTrue(false);
		}

		// Then
		Assert.assertTrue(object1.equals(object2));

	}

	@Test
	public void givenSingletonObjectWhenCloneIsCalledThenCloneNotSupportedExceptionIsThrown() {
		// Given
		SingletonDesignPattern object1 = SingletonDesignPattern.getInstance();

		// When
		try {
			object1.clone();
			Assert.assertTrue(false);
		} catch (CloneNotSupportedException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void givenSingletonObjectSerializedWhenDeserializationIsCalledThenSameObjectIsReturned() {
		// Given
		SingletonDesignPattern singletonDesignPattern = SingletonDesignPattern.getInstance();
		boolean isSerializationSuccessful = serializeSingletonObject(singletonDesignPattern);

		// When
		SingletonDesignPattern deserializedObject = deserializeSingletonObject(singletonDesignPattern);

		// Then
		Assert.assertTrue(isSerializationSuccessful);
		Assert.assertNotNull(deserializedObject);
		Assert.assertTrue(singletonDesignPattern.equals(deserializedObject));
	}

	private boolean serializeSingletonObject(SingletonDesignPattern singletonDesignPattern) {
		boolean response;
		try (FileOutputStream fos = new FileOutputStream("file.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(singletonDesignPattern);
			response = true;
		} catch (FileNotFoundException foe) {
			System.out.println("Specified file path does not exist.");
			response = false;
		} catch (IOException ioe) {
			System.out.println("Exception occured while creating stream.");
			response = false;
		}
		return response;
	}

	private SingletonDesignPattern deserializeSingletonObject(SingletonDesignPattern singletonDesignPattern) {
		SingletonDesignPattern deserializedObject = null;
		try (FileInputStream fis = new FileInputStream("file.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			deserializedObject = (SingletonDesignPattern) ois.readObject();
		} catch (FileNotFoundException foe) {
			System.out.println("Specified file path does not exist.");
		} catch (IOException ioe) {
			System.out.println("Exception occured while creating stream.");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Specified class not found during deserialization.");
		}
		return deserializedObject;
	}
}
