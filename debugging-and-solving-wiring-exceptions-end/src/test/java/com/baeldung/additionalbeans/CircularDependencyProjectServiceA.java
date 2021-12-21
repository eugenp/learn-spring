package com.baeldung.additionalbeans;

import org.springframework.stereotype.Service;

@Service
public class CircularDependencyProjectServiceA {

	private CircularDependencyProjectServiceB projectServiceB;

	public CircularDependencyProjectServiceA(CircularDependencyProjectServiceB projectServiceB) {
		this.projectServiceB = projectServiceB;
	}

}
