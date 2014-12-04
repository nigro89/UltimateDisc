package it.unical.mat.igpe.graphics;

import javax.swing.JProgressBar;

public class ProgressBar extends JProgressBar {
	private static final long serialVersionUID = 1L;
	int value = 5;

	public ProgressBar(){
		this.setOrientation(VERTICAL);
		this.setValue(0);
		this.setMinimum(5);
		this.setMaximum(40);
	}
	
	public void increment(int value){
		this.value+=value;
		setValue(this.value);
	}
	public void reset() {
		this.value=0;
		this.setValue(0);
	}
	
}
