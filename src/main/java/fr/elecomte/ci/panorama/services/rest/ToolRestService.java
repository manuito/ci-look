package fr.elecomte.ci.panorama.services.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.elecomte.ci.panorama.data.model.ToolType;
import fr.elecomte.ci.panorama.services.model.ToolGroupView;
import fr.elecomte.ci.panorama.services.model.ToolView;
import fr.elecomte.ci.panorama.services.processes.ToolInformationProcess;

/**
 * @author elecomte
 * @since 0.1.0
 */
@RestController
@RequestMapping(Constants.API_ROOT + "/tools")
public class ToolRestService {

	@Autowired
	private ToolInformationProcess tools;

	/**
	 * @return
	 */
	@RequestMapping(value = "/groups", method = GET)
	@ResponseBody
	public List<ToolGroupView> groups() {

		return this.tools.getAllExistingToolGroups();
	}

	/**
	 * @param anyType
	 * @return
	 */
	@RequestMapping(value = "/{anyType}", method = GET)
	@ResponseBody
	public List<ToolView> tools(@PathVariable String anyType) {

		return this.tools.getAllToolsInstances(ToolType.detectToolTypeFromValue(anyType.toLowerCase()));
	}

}
