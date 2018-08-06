package com.jude.file.base;

/**
 * @author jude
 */
public class RoutingDataSourceContext implements AutoCloseable {

    static final ThreadLocal<String> threadLocalDataSourceKey  = new ThreadLocal();

    public static String getDataSourceKey(){
        String key = threadLocalDataSourceKey.get();
        return key == null ? "masterDataSource" : key;
    }

    public RoutingDataSourceContext(String key){
        threadLocalDataSourceKey.set(key);
    }

    @Override
    public void close() throws Exception {
        threadLocalDataSourceKey.remove();
    }
}
