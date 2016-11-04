package fr.elecomte.ci.look.services.model;

import fr.elecomte.ci.look.data.model.ResultType;

/**
 * @author elecomte
 * @since 0.1.0
 */
public class DeployResultRecord extends ResultRecord {

	/**
	 * 
	 */
	public DeployResultRecord() {
		super();
	}

	@Override
	public ResultType getType() {
		return ResultType.DEPLOY;
	}

}