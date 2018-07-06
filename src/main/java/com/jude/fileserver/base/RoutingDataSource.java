package com.jude.fileserver.base;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author jude
 */
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return RoutingDataSourceContext.getDataSourceKey();
    }
}
