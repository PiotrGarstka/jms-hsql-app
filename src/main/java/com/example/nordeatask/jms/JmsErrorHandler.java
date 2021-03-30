package com.example.nordeatask.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

public class JmsErrorHandler implements ErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(JmsErrorHandler.class);

    @Override
    public void handleError(Throwable t) {
        LOG.warn("In default jms error handler...");
        LOG.error("Error Message : {}", t.getMessage());
    }

}
