package fr.elecomte.ci.panorama.services.processes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elecomte.ci.panorama.data.model.Tool;
import fr.elecomte.ci.panorama.data.model.ToolType;
import fr.elecomte.ci.panorama.data.model.Tool.ToolGroup;
import fr.elecomte.ci.panorama.data.repositories.ToolRepository;
import fr.elecomte.ci.panorama.services.model.ToolGroupView;
import fr.elecomte.ci.panorama.services.model.ToolView;

/**
 * @author elecomte
 * @since 0.1.0
 */
@Service
public class ToolInformationProcess {

	@Autowired
	private ToolRepository tools;

	/**
	 * @return
	 */
	public List<ToolGroupView> getAllExistingToolGroups() {
		return this.tools.findToolGroups().stream().map(ToolInformationProcess::viewFromToolGroup).collect(Collectors.toList());
	}

	/**
	 * @param toolType
	 * @return
	 */
	public List<ToolView> getAllToolsInstances(ToolType toolType) {
		return this.tools.findByTypeOrderBySemverHashAsc(toolType).stream().map(ToolInformationProcess::viewFromTool)
				.collect(Collectors.toList());
	}

	/**
	 * @param tool
	 * @return
	 */
	private static ToolGroupView viewFromToolGroup(ToolGroup toolGroup) {
		ToolGroupView view = new ToolGroupView();

		view.setKnewInstancesCount(toolGroup.getKnewInstancesCount().intValue());
		view.setType(toolGroup.getType().name());

		return view;
	}

	/**
	 * @param tool
	 * @return
	 */
	private static ToolView viewFromTool(Tool tool) {
		ToolView view = new ToolView();

		view.setName(tool.getName());
		view.setVersion(tool.getVersion());
		view.setVendorName(tool.getVendorName());

		return view;
	}
}
