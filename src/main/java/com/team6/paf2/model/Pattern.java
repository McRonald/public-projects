package com.team6.paf2.model;

import java.io.File;

public class Pattern {
	private int id;
	private String name;
	private String context;
	private String problems;
	private String forces;
	private String solution;
	private String description;
	private String consequences;
	private File diagram;
	private String participants;
	
	public Pattern() {}

	public Pattern(int id, String name, String context, String problems,
			String forces, String solution, String description,
			String consequences, File diagram, String participants) {
		super();
		this.id = id;
		this.name = name;
		this.context = context;
		this.problems = problems;
		this.forces = forces;
		this.solution = solution;
		this.description = description;
		this.consequences = consequences;
		this.diagram = diagram;
		this.participants = participants;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getProblems() {
		return problems;
	}

	public void setProblems(String problems) {
		this.problems = problems;
	}

	public String getForces() {
		return forces;
	}

	public void setForces(String forces) {
		this.forces = forces;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConsequences() {
		return consequences;
	}

	public void setConsequences(String consequences) {
		this.consequences = consequences;
	}

	public File getDiagram() {
		return diagram;
	}

	public void setDiagram(File diagram) {
		this.diagram = diagram;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}
}
