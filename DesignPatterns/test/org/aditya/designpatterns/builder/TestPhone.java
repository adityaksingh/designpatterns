package org.aditya.designpatterns.builder;

import org.junit.Assert;
import org.junit.Test;

public class TestPhone {

	@Test
	public void givenPhoneModelWhenBuildMethodIsInvokedThenPhoneIsBuilt()
	{
		//Given
		Phone.Builder builder = new Phone.Builder()
				.model("Vivo");
		
		//When
		Phone phone = builder.build();
		
		//Then
		Assert.assertTrue("Vivo".equals(phone.getModel()));
		Assert.assertNull(phone.getFrontCamera());
		Assert.assertNull(phone.getRearCamera());
		Assert.assertNull(phone.getProcessor());
	}
	
	@Test
	public void givenPhoneModelAndFrontCameraWhenBuildMethodIsInvokedThenPhoneIsBuilt()
	{
		//Given
		Phone.Builder builder = new Phone.Builder()
				.model("Vivo")
				.frontCamera("8MP");
		
		//When
		Phone phone = builder.build();
		
		//Then
		Assert.assertTrue("Vivo".equals(phone.getModel()));
		Assert.assertTrue("8MP".equals(phone.getFrontCamera()));
		Assert.assertNull(phone.getRearCamera());
		Assert.assertNull(phone.getProcessor());
	}
	
	@Test
	public void givenPhoneModelAndFrontAndRearCameraWhenBuildMethodIsInvokedThenPhoneIsBuilt()
	{
		//Given
		Phone.Builder builder = new Phone.Builder()
				.model("Vivo")
				.frontCamera("8MP")
				.rearCamera("16MP");
		
		//When
		Phone phone = builder.build();
		
		//Then
		Assert.assertTrue("Vivo".equals(phone.getModel()));
		Assert.assertTrue("8MP".equals(phone.getFrontCamera()));
		Assert.assertTrue("16MP".equals(phone.getRearCamera()));
		Assert.assertNull(phone.getProcessor());
	}
	
	@Test
	public void givenPhoneModelAndFrontAndRearCameraAndProcessorWhenBuildMethodIsInvokedThenPhoneIsBuilt()
	{
		//Given
		Phone.Builder builder = new Phone.Builder()
				.model("Vivo")
				.frontCamera("8MP")
				.rearCamera("16MP")
				.processor("ABCProcessor");
		
		//When
		Phone phone = builder.build();
		
		//Then
		Assert.assertTrue("Vivo".equals(phone.getModel()));
		Assert.assertTrue("8MP".equals(phone.getFrontCamera()));
		Assert.assertTrue("16MP".equals(phone.getRearCamera()));
		Assert.assertTrue("ABCProcessor".equals(phone.getProcessor()));
	}
}
