package fr.elecomte.ci.panorama.services.badges;

import fr.elecomte.ci.panorama.services.badges.providers.AuditResultCoverageProvider;
import fr.elecomte.ci.panorama.services.badges.providers.AuditResultNcssProvider;
import fr.elecomte.ci.panorama.services.badges.providers.BadgeValueProvider;
import fr.elecomte.ci.panorama.services.badges.providers.CompactDeveloperListProvider;
import fr.elecomte.ci.panorama.services.badges.providers.InlineDeveloperListProvider;
import fr.elecomte.ci.panorama.services.badges.providers.ProjectVersionProvider;
import fr.elecomte.ci.panorama.services.badges.providers.ResultSuccessProvider;
import fr.elecomte.ci.panorama.services.badges.providers.SimpleValueProvider;
import fr.elecomte.ci.panorama.services.badges.providers.TestResultCountProvider;
import fr.elecomte.ci.panorama.services.badges.providers.TestResultEvolutionProvider;
import fr.elecomte.ci.panorama.services.badges.providers.ToolLogoProvider;

/**
 * All supported badge types
 * 
 * @author elecomte
 * @since 0.1.0
 */
public enum BadgeType {

	BUILD("build.svg", new ResultSuccessProvider()),
	TEST("test.svg", new ResultSuccessProvider()),
	TEST_COUNT("test-count.svg", new TestResultCountProvider()),
	TEST_EVOLUTION("test-evolution.svg", new TestResultEvolutionProvider()),
	VERSION("version.svg", new ProjectVersionProvider()),
	VERSION_PENDING("version-pending.svg", new ProjectVersionProvider()),
	VERSION_RELEASED("version-released.svg", new ProjectVersionProvider()),
	VERSION_FRESH("version-fresh.svg", new ProjectVersionProvider()),
	VERSION_LAST("version-last.svg", new ProjectVersionProvider()),
	SERVER_VERSION("server-version.svg", new SimpleValueProvider()),
	SERVER_LOGO("server-logo.svg", new SimpleValueProvider()),
	SERVER_UPTIME("uptime.svg", new SimpleValueProvider()),
	SERVER_PROJECT_COUNT("project-count.svg", new SimpleValueProvider()),
	TOOL_LOGO("logo.svg", new ToolLogoProvider()),
	DEVELOPER_LIST_COMPACT("developers-compact.svg", new CompactDeveloperListProvider()),
	DEVELOPER_LIST_INLINE("developers-inline.svg", new InlineDeveloperListProvider()),
	AUDIT_COVERAGE("audit-coverage.svg", new AuditResultCoverageProvider()),
	AUDIT_NCSS("audit-ncss.svg", new AuditResultNcssProvider()),
	AUDIT("audit.svg", new ResultSuccessProvider());

	private final String badgeFile;
	private final BadgeValueProvider<?> provider;

	/**
	 * @param badgeFile
	 * @param title
	 * @param titleColor
	 * @param provider
	 */
	private BadgeType(String badgeFile, BadgeValueProvider<?> provider) {
		this.badgeFile = badgeFile;
		this.provider = provider;
	}

	/**
	 * @return the badgeFile
	 */
	public String getBadgeFile() {
		return this.badgeFile;
	}

	/**
	 * @return the provider
	 */
	@SuppressWarnings("unchecked")
	public <T> BadgeValueProvider<T> getProvider() {
		return (BadgeValueProvider<T>) this.provider;
	}
}