# clock-jsf-test

Simple ear for testing JSF/CDI issues.

1. Build by running `mvn install` at the project root
2. Deploy the clock-ear.ear by running `mvn wildfly:run` from within the **clock-ear** subproject
3. Test the ear with the default JSF based contexts by running `mvn test` from within the **clock-test** subproject
4. Change the clock-web/src/main/java/example/clock/Clock.java class annotations from the JSF style to the CDI style:
	import javax.enterprise.context.ApplicationScoped;
	import javax.inject.Named;
	@Named
	@ApplicationScoped
5. Rebuild the ear by running `mvn install` at the project root
6. Redeploy the ear by running `mvn wildfly:redeploy` from the **clock-ear** subproject
7. Retest the ear by running `mvn test` from the **clock-test** subproject

##Error Seen from step 3
    19:15:08,599 SEVERE [javax.enterprise.resource.webcontainer.jsf.application] (default task-1) Error Rendering View[/index.xhtml]: java.lang.IllegalStateException: WELD-000340: A request must be associated with the context in order to load the known conversations
    at org.jboss.weld.context.AbstractConversationContext.checkIsAssociated(AbstractConversationContext.java:416) [weld-core-impl-2.1.2.Final.jar:2014-01-09 09:23]
    at org.jboss.weld.context.AbstractConversationContext.getCurrentConversation(AbstractConversationContext.java:431) [weld-core-impl-2.1.2.Final.jar:2014-01-09 09:23]
    at org.jboss.weld.jsf.ConversationAwareViewHandler.getActionURL(ConversationAwareViewHandler.java:110) [weld-core-jsf-2.1.2.Final.jar:2014-01-09 09:23]
    at javax.faces.application.ViewHandlerWrapper.getActionURL(ViewHandlerWrapper.java:189) [jboss-jsf-api_2.2_spec-2.2.5.jar:2.2.5]
    at com.sun.faces.application.view.MultiViewHandler.getBookmarkableURL(MultiViewHandler.java:407) [jsf-impl-2.2.5-jbossorg-3.jar:]
    at javax.faces.application.ViewHandlerWrapper.getBookmarkableURL(ViewHandlerWrapper.java:272) [jboss-jsf-api_2.2_spec-2.2.5.jar:2.2.5]
    at org.jboss.weld.jsf.ConversationAwareViewHandler.getBookmarkableURL(ConversationAwareViewHandler.java:132) [weld-core-jsf-2.1.2.Final.jar:2014-01-09 09:23]
    at javax.faces.application.ViewHandlerWrapper.getBookmarkableURL(ViewHandlerWrapper.java:272) [jboss-jsf-api_2.2_spec-2.2.5.jar:2.2.5]
    at com.sun.faces.renderkit.html_basic.OutcomeTargetRenderer.getEncodedTargetURL(OutcomeTargetRenderer.java:194) [jsf-impl-2.2.5-jbossorg-3.jar:]
    at com.sun.faces.renderkit.html_basic.OutcomeTargetLinkRenderer.renderAsActive(OutcomeTargetLinkRenderer.java:158) [jsf-impl-2.2.5-jbossorg-3.jar:]
    at com.sun.faces.renderkit.html_basic.OutcomeTargetLinkRenderer.encodeBegin(OutcomeTargetLinkRenderer.java:96) [jsf-impl-2.2.5-jbossorg-3.jar:]
    at javax.faces.component.UIComponentBase.encodeBegin(UIComponentBase.java:864) [jboss-jsf-api_2.2_spec-2.2.5.jar:2.2.5]
    at javax.faces.component.UIComponent.encodeAll(UIComponent.java:1854) [jboss-jsf-api_2.2_spec-2.2.5.jar:2.2.5]
    at javax.faces.component.UIComponent.encodeAll(UIComponent.java:1859) [jboss-jsf-api_2.2_spec-2.2.5.jar:2.2.5]
    at javax.faces.component.UIComponent.encodeAll(UIComponent.java:1859) [jboss-jsf-api_2.2_spec-2.2.5.jar:2.2.5]
    at com.sun.faces.application.view.FaceletViewHandlingStrategy.renderView(FaceletViewHandlingStrategy.java:461) [jsf-impl-2.2.5-jbossorg-3.jar:]
    at com.sun.faces.application.view.MultiViewHandler.renderView(MultiViewHandler.java:133) [jsf-impl-2.2.5-jbossorg-3.jar:]
    at javax.faces.application.ViewHandlerWrapper.renderView(ViewHandlerWrapper.java:337) [jboss-jsf-api_2.2_spec-2.2.5.jar:2.2.5]
    at javax.faces.application.ViewHandlerWrapper.renderView(ViewHandlerWrapper.java:337) [jboss-jsf-api_2.2_spec-2.2.5.jar:2.2.5]
    at com.sun.faces.lifecycle.RenderResponsePhase.execute(RenderResponsePhase.java:120) [jsf-impl-2.2.5-jbossorg-3.jar:]
	at com.sun.faces.lifecycle.Phase.doPhase(Phase.java:101) [jsf-impl-2.2.5-jbossorg-3.jar:]
	at com.sun.faces.lifecycle.LifecycleImpl.render(LifecycleImpl.java:219) [jsf-impl-2.2.5-jbossorg-3.jar:]
	at javax.faces.webapp.FacesServlet.service(FacesServlet.java:647) [jboss-jsf-api_2.2_spec-2.2.5.jar:2.2.5]
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:85) [undertow-servlet-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:61) [undertow-servlet-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36) [undertow-servlet-1.0.0.Final.jar:1.0.0.Final]
	at org.wildfly.extension.undertow.security.SecurityContextAssociationHandler.handleRequest(SecurityContextAssociationHandler.java:78)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:25) [undertow-core-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:113) [undertow-servlet-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.security.handlers.AuthenticationCallHandler.handleRequest(AuthenticationCallHandler.java:52) [undertow-core-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:45) [undertow-core-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:61) [undertow-servlet-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:70) [undertow-servlet-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.security.handlers.SecurityInitialHandler.handleRequest(SecurityInitialHandler.java:76) [undertow-core-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:25) [undertow-core-1.0.0.Final.jar:1.0.0.Final]
	at org.wildfly.extension.undertow.security.jacc.JACCContextIdHandler.handleRequest(JACCContextIdHandler.java:61)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:25) [undertow-core-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:25) [undertow-core-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:240) [undertow-servlet-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:227) [undertow-servlet-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.servlet.handlers.ServletInitialHandler.access$000(ServletInitialHandler.java:73) [undertow-servlet-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:146) [undertow-servlet-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:168) [undertow-core-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:687) [undertow-core-1.0.0.Final.jar:1.0.0.Final]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [rt.jar:1.8.0]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [rt.jar:1.8.0]
	at java.lang.Thread.run(Thread.java:744) [rt.jar:1.8.0]`
