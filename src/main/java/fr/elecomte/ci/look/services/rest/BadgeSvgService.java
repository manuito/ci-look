package fr.elecomte.ci.look.services.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.elecomte.ci.look.services.processes.BadgeInformationProcess;
import fr.elecomte.ci.look.services.processes.ProcessException;

/**
 * @author elecomte
 * @since 0.1.0
 */
@RestController
@RequestMapping(Constants.BADGES_ROOT)
public class BadgeSvgService {

	@Autowired
	private BadgeInformationProcess badges;

	/**
	 * @param record
	 * @throws ProcessException
	 */
	@RequestMapping(value = "/{projectCodeName}/{projectVersion}/build.svg", method = GET, produces = "image/svg+xml ")
	@ResponseBody
	public String build(@PathVariable String projectCodeName, @PathVariable String projectVersion) throws ProcessException {
		return this.badges.getBuildBadge(projectCodeName, projectVersion);
	}

	/**
	 * @param record
	 * @throws ProcessException
	 */
	@RequestMapping(value = "/{projectCodeName}/{projectVersion}/version.svg", method = GET, produces = "image/svg+xml ")
	@ResponseBody
	public String version(@PathVariable String projectCodeName, @PathVariable String projectVersion) throws ProcessException {
		return this.badges.getVersionBadge(projectCodeName, projectVersion);
	}

	/**
	 * @param record
	 * @throws ProcessException
	 */
	@RequestMapping(value = "/{projectCodeName}/{projectVersion}/test.svg", method = GET, produces = "image/svg+xml ")
	@ResponseBody
	public String test(@PathVariable String projectCodeName, @PathVariable String projectVersion) throws ProcessException {
		return this.badges.getTestBadge(projectCodeName, projectVersion);
	}

	/**
	 * @param record
	 * @throws ProcessException
	 */
	@RequestMapping(value = "/{projectCodeName}/{projectVersion}/test-count.svg", method = GET, produces = "image/svg+xml ")
	@ResponseBody
	public String testCount(@PathVariable String projectCodeName, @PathVariable String projectVersion) throws ProcessException {
		return this.badges.getTestCountBadge(projectCodeName, projectVersion);
	}

	/**
	 * @param record
	 * @throws ProcessException
	 */
	@RequestMapping(value = "/{projectCodeName}/{projectVersion}/test-evolution.svg", method = GET, produces = "image/svg+xml ")
	@ResponseBody
	public String testEvolution(@PathVariable String projectCodeName, @PathVariable String projectVersion) throws ProcessException {
		return this.badges.getTestEvolutionBadge(projectCodeName, projectVersion);
	}
}
