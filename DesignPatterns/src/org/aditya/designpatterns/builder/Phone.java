package org.aditya.designpatterns.builder;

/**
 * Phone class represents the different types of phones that can be created with
 * different specification
 */
public class Phone {

	/*
	 * Model for the phone
	 */
	private String model;

	/*
	 * Front Camera for the phone
	 */
	private String frontCamera;

	/*
	 * Rear Camera for the phone
	 */
	private String rearCamera;

	/*
	 * Processor for the phone
	 */
	private String processor;

	/*
	 * Phone constructor to create the phone with given specification
	 * 
	 * @param model to be set for phone
	 * @param frontCamera to be set for phone
	 * @param rearCamera to be set for phone
	 * @param processor to be set for phone
	 */
	private Phone(String model, String frontCamera, String rearCamera, String processor) {
		super();
		this.model = model;
		this.frontCamera = frontCamera;
		this.rearCamera = rearCamera;
		this.processor = processor;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return the frontCamera
	 */
	public String getFrontCamera() {
		return frontCamera;
	}

	/**
	 * @return the rearCamera
	 */
	public String getRearCamera() {
		return rearCamera;
	}

	/**
	 * @return the processor
	 */
	public String getProcessor() {
		return processor;
	}

	/**
	 * Static Inner class to build the phone with given specification. This class
	 * will be used for building the phone for different specifications using the
	 * different methods provided by builder class
	 */
	public static class Builder {
		/*
		 * model for the phone to be built 
		 */
		private String model;
		
		/*
		 * frontCamera for the phone to be built 
		 */
		private String frontCamera;
		
		/*
		 * rearCamera for the phone to be built 
		 */
		private String rearCamera;
		
		/*
		 * processor for the phone to be built 
		 */
		private String processor;

		/**
		 * API to set the model in the builder to build the phone
		 * 
		 * @param model of phone to be set
		 * @return instance of builder 
		 */
		public Builder model(String model) {
			this.model = model;
			return this;
		}

		/**
		 * API to set the frontCamera in the builder to build the phone
		 * 
		 * @param frontCamera of phone to be set
		 * @return instance of builder 
		 */
		public Builder frontCamera(String frontCamera) {
			this.frontCamera = frontCamera;
			return this;
		}

		/**
		 * API to set the rearCamera in the builder to build the phone
		 * 
		 * @param rearCamera of phone to be set
		 * @return instance of builder 
		 */
		public Builder rearCamera(String rearCamera) {
			this.rearCamera = rearCamera;
			return this;
		}

		/**
		 * API to set the processor in the builder to build the phone
		 * 
		 * @param processor of phone to be set
		 * @return instance of builder 
		 */
		public Builder processor(String processor) {
			this.processor = processor;
			return this;
		}

		/**
		 * API to build the phone as per specified specifications
		 * 
		 * @return instance of Phone
		 */
		public Phone build() {
			return new Phone(model, frontCamera, rearCamera, processor);
		}
	}
}
