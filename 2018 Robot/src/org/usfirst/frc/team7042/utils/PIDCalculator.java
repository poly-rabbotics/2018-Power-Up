package org.usfirst.frc.team7042.utils;

import java.util.ArrayList;

public class PIDCalculator extends Thread {
	
	ArrayList<MomentumPID> controllers;
	
	public PIDCalculator(MomentumPID[] controllers) {
		super();
		this.controllers = new ArrayList<MomentumPID>(controllers.length);
		for(MomentumPID cont : controllers)
			this.controllers.add(cont);
		setName("PID Calculator");
	}
	
	@Override
	public void run() {
		
		while(!Thread.interrupted()) {
			for(MomentumPID cont : controllers) {
				if(cont.isEnabled())
					cont.calculate();
			}
		}
		// Safety measure - When the controller is disabled, set its output to zero
		for(MomentumPID cont : controllers) {
			cont.writeZero();
		}
	}
	
	public void addController(MomentumPID cont) {
		controllers.add(cont);
	}
}
