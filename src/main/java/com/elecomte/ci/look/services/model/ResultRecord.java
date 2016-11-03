package com.elecomte.ci.look.services.model;

import com.elecomte.ci.look.data.model.ResultType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author elecomte
 * @since 0.1.0
 */
public abstract class ResultRecord extends Record<ResultView> {

	@JsonInclude(Include.ALWAYS)
	private ProjectView project;

	/**
	 * @return the project
	 */
	public ProjectView getProject() {
		return this.project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(ProjectView project) {
		this.project = project;
	}

	/**
	 * @return
	 */
	public abstract ResultType getType();

}
