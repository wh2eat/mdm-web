package com.idata.mdm.web.thymeleaf.custom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

@Component
public class PermissionTagProcessor extends AbstractElementTagProcessor {

    private final static Logger LOGGER = LogManager.getLogger(PermissionTagProcessor.class);

    public PermissionTagProcessor() {
        super(TemplateMode.HTML, "ct", "permission", true, null, false, 1000);
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
            IElementTagStructureHandler structureHandler) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[][doProcess][" + tag + "]");
        }

        structureHandler.removeBody();
        structureHandler.removeTags();
    }

}
