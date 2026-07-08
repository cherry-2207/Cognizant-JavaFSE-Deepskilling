package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DifferentAppendersExample {
    private static final Logger logger = LoggerFactory.getLogger(DifferentAppendersExample.class);

    public static void main(String[] args) {
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.warn("Warning log message");
        logger.error("Error log message");
    }
}