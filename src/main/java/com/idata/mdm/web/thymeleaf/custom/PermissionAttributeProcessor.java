package com.idata.mdm.web.thymeleaf.custom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

@Component
public class PermissionAttributeProcessor extends AbstractAttributeTagProcessor {

    private final static Logger LOGGER = LogManager.getLogger(PermissionAttributeProcessor.class);

    protected PermissionAttributeProcessor() {
        super(TemplateMode.HTML, null, null, false, "permission", false, 1000, false);
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName,
            String attributeValue, IElementTagStructureHandler structureHandler) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[][doProcess][" + tag + ";" + attributeName + ":" + attributeValue + ";]");
        }

    }

}
