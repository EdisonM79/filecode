package com.jzsk.filecode.model.value;

import java.util.List;

public class CodeValue {

	private List<TypeValue> types;
	private List<FunctionValue> functions;
	private List<ProjectInfoValue> projects;

	public List<TypeValue> getTypes() {
		return types;
	}

	public void setTypes(List<TypeValue> types) {
		this.types = types;
	}

	public List<FunctionValue> getFunctions() {
		return functions;
	}

	public void setFunctions(List<FunctionValue> functions) {
		this.functions = functions;
	}

	public List<ProjectInfoValue> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectInfoValue> projects) {
		this.projects = projects;
	}

}
