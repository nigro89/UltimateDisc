public interface MovingObject {

	/**
	 * @uml.property  name="UP" readOnly="true"
	 */
	public static final int up = 0;
	/**
	 * @uml.property  name="DOWN" readOnly="true"
	 */
	public static final int down = 1;
	/**
	 * @uml.property  name="LEFT" readOnly="true"
	 */
	public static final int left = 2;
	/**
	 * @uml.property  name="RIGHT" readOnly="true"
	 */
	public static final int right = 3;
		
		/**
		 */
		public abstract int getX();

			
			/**
			 */
			public abstract int getY();


				
				/**
				 */
				public abstract void setDirection();


					
					/**
					 */
					public abstract void update();


						
						/**
						 */
						public abstract void reset();
						
					
				
			
		

}
