package org.kuali.rice.kew.service;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;
import org.kuali.rice.core.config.NodeSettings;
import org.kuali.rice.core.resourceloader.GlobalResourceLoader;
import org.kuali.rice.core.resourceloader.RiceResourceLoaderFactory;
import org.kuali.rice.core.service.EncryptionService;
import org.kuali.rice.kew.actionlist.service.ActionListService;
import org.kuali.rice.kew.actionrequest.service.ActionRequestService;
import org.kuali.rice.kew.actions.ActionRegistry;
import org.kuali.rice.kew.actiontaken.service.ActionTakenService;
import org.kuali.rice.kew.batch.XmlDigesterService;
import org.kuali.rice.kew.batch.XmlIngesterService;
import org.kuali.rice.kew.batch.XmlPollerService;
import org.kuali.rice.kew.docsearch.service.DocumentSearchService;
import org.kuali.rice.kew.doctype.service.DocumentSecurityService;
import org.kuali.rice.kew.doctype.service.DocumentTypePermissionService;
import org.kuali.rice.kew.doctype.service.DocumentTypeService;
import org.kuali.rice.kew.edl.extract.ExtractService;
import org.kuali.rice.kew.edl.service.EDocLiteService;
import org.kuali.rice.kew.edl.service.StyleService;
import org.kuali.rice.kew.engine.WorkflowEngine;
import org.kuali.rice.kew.engine.node.service.BranchService;
import org.kuali.rice.kew.engine.node.service.RouteNodeService;
import org.kuali.rice.kew.exception.WorkflowDocumentExceptionRoutingService;
import org.kuali.rice.kew.help.service.HelpService;
import org.kuali.rice.kew.identity.service.IdentityHelperService;
import org.kuali.rice.kew.mail.service.ActionListEmailService;
import org.kuali.rice.kew.mail.service.EmailContentService;
import org.kuali.rice.kew.mail.service.EmailService;
import org.kuali.rice.kew.notes.service.NoteService;
import org.kuali.rice.kew.notification.service.NotificationService;
import org.kuali.rice.kew.preferences.service.PreferencesService;
import org.kuali.rice.kew.removereplace.service.RemoveReplaceDocumentService;
import org.kuali.rice.kew.responsibility.service.ResponsibilityIdService;
import org.kuali.rice.kew.role.service.RoleService;
import org.kuali.rice.kew.routeheader.service.RouteHeaderService;
import org.kuali.rice.kew.routeheader.service.WorkflowDocumentService;
import org.kuali.rice.kew.routemodule.service.RouteModuleService;
import org.kuali.rice.kew.routemodule.service.RoutingReportService;
import org.kuali.rice.kew.rule.service.RuleAttributeService;
import org.kuali.rice.kew.rule.service.RuleDelegationService;
import org.kuali.rice.kew.rule.service.RuleService;
import org.kuali.rice.kew.rule.service.RuleTemplateService;
import org.kuali.rice.kew.useroptions.UserOptionsService;
import org.kuali.rice.kew.util.KEWConstants;
import org.kuali.rice.kew.xml.export.XmlExporterService;
import org.kuali.rice.ksb.cache.RiceCacheAdministrator;
import org.springframework.transaction.PlatformTransactionManager;


/**
 * Convenience class that holds service names and provide methods to acquire services.  Defaults to
 * GLR for actual service acquisition.  Used to be responsible for loading and holding spring
 * application context (when it was SpringServiceLocator) but those responsibilities have been
 * moved to the SpringLoader.
 *
 * @author Kuali Rice Team (kuali-rice@googlegroups.com)
 *
 */
public final class KEWServiceLocator {

	private static final Logger LOG = Logger.getLogger(KEWServiceLocator.class);

	public static final String DATASOURCE = "enWorkflowDataSource";

	public static final String QUICK_LINKS_SERVICE = "enQuickLinksService";

	public static final String DOCUMENT_SEARCH_SERVICE = "enDocumentSearchService";

	public static final String ACTION_TAKEN_SRV = "enActionTakenService";

	public static final String ACTION_REQUEST_SRV = "enActionRequestService";

	public static final String ACTION_LIST_SRV = "enActionListService";

	public static final String DOC_ROUTE_HEADER_SRV = "enDocumentRouteHeaderService";

	public static final String DOCUMENT_TYPE_GROUP_SERVICE = "enDocumentTypeGroupService";

	public static final String DOCUMENT_TYPE_SERVICE = "enDocumentTypeService";
	
	public static final String DOCUMENT_TYPE_PERMISSION_SERVICE = "enDocumentTypePermissionService";

	public static final String DOCUMENT_SECURITY_SERVICE = "enDocumentSecurityService";

	public static final String USER_OPTIONS_SRV = "enUserOptionsService";

	public static final String DOCUMENT_CHANGE_HISTORY_SRV = "enDocumentChangeHistoryService";

	public static final String DOCUMENT_VALUE_INDEX_SRV = "enDocumentValueIndexService";

	public static final String ROUTE_LEVEL_SERVICE = "enRouteLevelService";

	public static final String CONSTANTS_SERVICE = "enApplicationConstantsService";

	public static final String PREFERENCES_SERVICE = "enPreferencesService";

	public static final String ROUTE_LOG_SERVICE = "enRouteLogService";

	public static final String RULE_TEMPLATE_SERVICE = "enRuleTemplateService";

	public static final String RULE_SERVICE = "enRuleService";

	public static final String RULE_ATTRIBUTE_SERVICE = "enRuleAttributeService";

	public static final String RULE_TEMPLATE_ATTRIBUTE_SERVICE = "enRuleTemplateAttributeService";

	public static final String ROLE_SERVICE = "enRoleService";

	public static final String RESPONSIBILITY_ID_SERVICE = "enResponsibilityIdService";

	public static final String STATS_SERVICE = "enStatsService";

	public static final String ROUTE_MANAGER_QUEUE_SERVICE = "enRouteManagerQueueService";

	public static final String ROUTE_MANAGER_CONTROLLER = "enRouteManagerController";

	public static final String RULE_DELEGATION_SERVICE = "enRuleDelegationService";

	public static final String ROUTE_MANAGER_DRIVER = "enRouteManagerDriver";

	public static final String OPTIMISTIC_LOCK_FAILURE_SERVICE = "enOptimisticLockFailureService";

	public static final String NOTE_SERVICE = "enNoteService";

	public static final String ROUTING_REPORT_SERVICE = "enRoutingReportService";

	public static final String ROUTE_MODULE_SERVICE = "enRouteModuleService";

	public static final String EXCEPTION_ROUTING_SERVICE = "enExceptionRoutingService";

	public static final String ACTION_REGISTRY = "enActionRegistry";

	public static final String BRANCH_SERVICE = "enBranchService";

	public static final String WORKFLOW_MBEAN = "workflowMBean";

	public static final String NODE_SETTINGS = "nodeSettings";

	public static final String APPLICATION_CONSTANTS_CACHE = "applicationConstantsCache";

	public static final String JTA_TRANSACTION_MANAGER = "jtaTransactionManager";

	public static final String USER_TRANSACTION = "userTransaction";

	public static final String CACHE_ADMINISTRATOR = "enCacheAdministrator";

	public static final String SCHEDULER = "enScheduler";

	/**
	 * Polls for xml files on disk
	 */
	public static final String XML_POLLER_SERVICE = "enXmlPollerService";

	/**
	 * Ingests xml docs containers
	 */
	public static final String XML_INGESTER_SERVICE = "enXmlIngesterService";

	/**
	 * Delegates xml doc parsing
	 */
	public static final String XML_DIGESTER_SERVICE = "enXmlDigesterService";

	/**
	 * Exports xml data
	 */
	public static final String XML_EXPORTER_SERVICE = "enXmlExporterService";

	public static final String DB_TABLES_LOADER = "enDbTablesLoader";

	public static final String ROUTE_NODE_SERVICE = "enRouteNodeService";

	public static final String WORKFLOW_ENGINE = "workflowEngine";

	public static final String EDOCLITE_SERVICE = "enEDocLiteService";

    public static final String STYLE_SERVICE = "enStyleService";

	public static final String ACTION_LIST_EMAIL_SERVICE = "enActionListEmailService";

	public static final String IMMEDIATE_EMAIL_REMINDER_SERVICE = "enImmediateEmailReminderService";
	
	public static final String EMAIL_SERVICE = "enEmailService";

    public static final String EMAIL_CONTENT_SERVICE = "enEmailContentService";

	public static final String NOTIFICATION_SERVICE = "enNotificationService";

	public static final String TRANSACTION_MANAGER = "transactionManager";

	public static final String TRANSACTION_TEMPLATE = "transactionTemplate";

	public static final String HELP_SERVICE = "enHelpService";

	public static final String WORKFLOW_DOCUMENT_SERVICE = "enWorkflowDocumentService";

	public static final String EXTENSION_SERVICE = "enExtensionService";

	public static final String TRANSFORMATION_SERVICE = "enTransformationService";

	public static final String ENCRYPTION_SERVICE = "enEncryptionService";

	public static final String REMOVE_REPLACE_DOCUMENT_SERVICE = "enRemoveReplaceDocumentService";

	public static final String EXTRACT_SERVICE = "enExtractService";
	
	public static final String IDENTITY_HELPER_SERVICE = "kewIdentityHelperService";

	public static final String ENTITY_MANAGER_FACTORY = "kewEntityManagerFactory";


    public static EntityManagerFactory getEntityManagerFactory() {
        return (EntityManagerFactory) getService(ENTITY_MANAGER_FACTORY);
    }
	
	
	/**
	 * @param serviceName
	 *            the name of the service bean
	 * @return the service
	 */
	public static Object getService(String serviceName) {
		return getBean(serviceName);
	}
	
	public static Object getBean(String serviceName) {
		LOG.debug("Fetching service " + serviceName);
		return GlobalResourceLoader.getResourceLoader().getService(new QName(serviceName));
	}

	public static WorkflowUtility getWorkflowUtilityService() {
		return (WorkflowUtility) getBean(KEWConstants.WORKFLOW_UTILITY_SERVICE);
	}

	public static WorkflowDocumentActions getWorkflowDocumentActionsService() {
		return (WorkflowDocumentActions) getBean(KEWConstants.WORKFLOW_DOCUMENT_ACTIONS_SERVICE);
	}

	public static DocumentTypeService getDocumentTypeService() {
		return (DocumentTypeService) getBean(DOCUMENT_TYPE_SERVICE);
	}

	public static DocumentTypePermissionService getDocumentTypePermissionService() {
		return (DocumentTypePermissionService) getBean(DOCUMENT_TYPE_PERMISSION_SERVICE);
	}
	
    public static DocumentSecurityService getDocumentSecurityService() {
    	return (DocumentSecurityService) getBean(DOCUMENT_SECURITY_SERVICE);
    }


	public static ActionRequestService getActionRequestService() {
		return (ActionRequestService) getBean(ACTION_REQUEST_SRV);
	}

	public static ActionTakenService getActionTakenService() {
		return (ActionTakenService) getBean(ACTION_TAKEN_SRV);
	}

	public static ResponsibilityIdService getResponsibilityIdService() {
		return (ResponsibilityIdService) getBean(RESPONSIBILITY_ID_SERVICE);
	}

	public static RouteHeaderService getRouteHeaderService() {
		return (RouteHeaderService) getBean(DOC_ROUTE_HEADER_SRV);
	}

	public static RuleTemplateService getRuleTemplateService() {
		return (RuleTemplateService) getBean(RULE_TEMPLATE_SERVICE);
	}

	public static RuleAttributeService getRuleAttributeService() {
		return (RuleAttributeService) getBean(RULE_ATTRIBUTE_SERVICE);
	}

	public static WorkflowDocumentService getWorkflowDocumentService() {
		return (WorkflowDocumentService) getBean(WORKFLOW_DOCUMENT_SERVICE);
	}

	public static RouteModuleService getRouteModuleService() {
		return (RouteModuleService) getBean(ROUTE_MODULE_SERVICE);
	}

	public static RoleService getRoleService() {
		return (RoleService) getBean(ROLE_SERVICE);
	}

	public static RuleService getRuleService() {
		return (RuleService) getBean(RULE_SERVICE);
	}

	public static RuleDelegationService getRuleDelegationService() {
		return (RuleDelegationService) getBean(RULE_DELEGATION_SERVICE);
	}

	public static HelpService getHelpService() {
		return (HelpService) getBean(HELP_SERVICE);
	}

	public static RoutingReportService getRoutingReportService() {
		return (RoutingReportService) getBean(ROUTING_REPORT_SERVICE);
	}

	public static PreferencesService getPreferencesService() {
		return (PreferencesService) getBean(PREFERENCES_SERVICE);
	}

	public static XmlPollerService getXmlPollerService() {
		return (XmlPollerService) getBean(XML_POLLER_SERVICE);
	}

	public static XmlIngesterService getXmlIngesterService() {
		return (XmlIngesterService) getBean(XML_INGESTER_SERVICE);
	}

	public static XmlDigesterService getXmlDigesterService() {
		return (XmlDigesterService) getBean(XML_DIGESTER_SERVICE);
	}

	public static XmlExporterService getXmlExporterService() {
		return (XmlExporterService) getBean(XML_EXPORTER_SERVICE);
	}

	public static UserOptionsService getUserOptionsService() {
		return (UserOptionsService) getBean(USER_OPTIONS_SRV);
	}

	public static ActionListService getActionListService() {
		return (ActionListService) getBean(ACTION_LIST_SRV);
	}

	public static RouteNodeService getRouteNodeService() {
		return (RouteNodeService) getBean(ROUTE_NODE_SERVICE);
	}

	public static WorkflowEngine getWorkflowEngine() {
		return (WorkflowEngine) getBean(WORKFLOW_ENGINE);
	}

	public static EDocLiteService getEDocLiteService() {
		return (EDocLiteService) getBean(EDOCLITE_SERVICE);
	}

    public static StyleService getStyleService() {
        return (StyleService) getBean(STYLE_SERVICE);
    }

	public static WorkflowDocumentExceptionRoutingService getExceptionRoutingService() {
		return (WorkflowDocumentExceptionRoutingService) getBean(EXCEPTION_ROUTING_SERVICE);
	}

	public static ActionListEmailService getActionListEmailService() {
		return (ActionListEmailService) getBean(KEWServiceLocator.ACTION_LIST_EMAIL_SERVICE);
	}

	public static EmailService getEmailService() {
		return (EmailService) getBean(KEWServiceLocator.EMAIL_SERVICE);
	}

    public static EmailContentService getEmailContentService() {
        return (EmailContentService) getBean(KEWServiceLocator.EMAIL_CONTENT_SERVICE);
    }

    public static NotificationService getNotificationService() {
		return (NotificationService) getBean(KEWServiceLocator.NOTIFICATION_SERVICE);
	}

	public static TransactionManager getTransactionManager() {
		return (TransactionManager) getBean(JTA_TRANSACTION_MANAGER);
	}

	public static UserTransaction getUserTransaction() {
		return (UserTransaction) getBean(USER_TRANSACTION);
	}

	public static NoteService getNoteService() {
		return (NoteService) getBean(NOTE_SERVICE);
	}

	public static ActionRegistry getActionRegistry() {
		return (ActionRegistry) getBean(ACTION_REGISTRY);
	}

	public static NodeSettings getNodeSettings() {
		return (NodeSettings) getBean(NODE_SETTINGS);
	}

	public static RiceCacheAdministrator getCacheAdministrator() {
		return (RiceCacheAdministrator) getBean(CACHE_ADMINISTRATOR);
	}

	public static EncryptionService getEncryptionService() {
		return (EncryptionService) getBean(ENCRYPTION_SERVICE);
	}

    public static BranchService getBranchService() {
        return (BranchService) getBean(BRANCH_SERVICE);
    }

    public static DocumentSearchService getDocumentSearchService() {
    	return (DocumentSearchService) getBean(DOCUMENT_SEARCH_SERVICE);
    }

    public static RemoveReplaceDocumentService getRemoveReplaceDocumentService() {
	return (RemoveReplaceDocumentService) getBean(REMOVE_REPLACE_DOCUMENT_SERVICE);
    }

    public static ExtractService getExtractService() {
	return (ExtractService) getBean(EXTRACT_SERVICE);
    }

    public static IdentityHelperService getIdentityHelperService() {
    	return (IdentityHelperService) getBean(IDENTITY_HELPER_SERVICE);
    }
    
    /**
     * For the following methods, we go directly to the SpringLoader because we do NOT want them to
     * be wrapped in any sort of proxy.
     */

    public static DataSource getDataSource() {
	return (DataSource) RiceResourceLoaderFactory.getSpringResourceLoader().getContext().getBean(DATASOURCE);
    }

    public static PlatformTransactionManager getPlatformTransactionManager() {
	return (PlatformTransactionManager) RiceResourceLoaderFactory.getSpringResourceLoader().getContext().getBean(TRANSACTION_MANAGER);
    }
}