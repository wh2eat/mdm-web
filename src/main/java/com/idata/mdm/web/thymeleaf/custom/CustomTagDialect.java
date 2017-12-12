package com.idata.mdm.web.thymeleaf.custom;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;

@Component
public class CustomTagDialect extends AbstractProcessorDialect {

    private final static Logger LOGGER = LogManager.getLogger(CustomTagDialect.class);

    private final static String name = "customTag";

    private final static String prefix = "ct";

    private final static int processorPrecedence = 1000;

    public CustomTagDialect() {
        super(name, prefix, processorPrecedence);
    }

    @Autowired
    private PermissionTagProcessor permissionTagProcessor;

    @Autowired
    private PermissionAttributeProcessor permissionAttributeProcessor;

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[][getProcessors][" + dialectPrefix + "]");
        }

        Set<IProcessor> processors = new HashSet<>();
        processors.add(permissionTagProcessor);
        processors.add(permissionAttributeProcessor);

        return processors;
    }

}
