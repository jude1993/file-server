package com.jude.file.common;

import org.slf4j.Logger;

import com.alibaba.fastjson.JSONObject;

/**
 * 探睿全局日志打印工具类
 *
 * @author TR1
 *
 */
public class LogUtils {

    // ===================================debug================================//
    /**
     * <pre>
     * LogUtils.debug(logger, 'xxxx')
     * </pre>
     *
     * @param logger
     * @param message
     */
    public static void debug(Logger logger, String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    /**
     * debug级别日志
     * <pre>
     * LogUtils.debug(logger, 'xxxxxx : {}', msg)
     * </pre>
     * @param logger
     * @param format
     * @param msg
     */
    public static void debug(Logger logger, String format, String msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, msg);
        }
    }

    /**
     * debug级别日志，内部会对obj执行JSONObject.toJSONString处理
     * <pre>
     * LogUtils.debug(logger, 'xxxxxx : {}', obj)
     * </pre>
     *
     * @param logger
     * @param format
     * @param obj
     */
    public static void debug(Logger logger, String format, Object obj) {
        if (logger.isDebugEnabled()) {
            if(obj instanceof Throwable) {
                logger.debug(format, obj);
            } else {
                logger.debug(format, JSONObject.toJSONString(obj));
            }
        }
    }

    /**
     * <pre>
     * LogUtils.debug(logger, 'xxxxxx : {}, yyyyyy:{}', msg1, msg2)
     * </pre>
     *
     * @param logger
     * @param format
     * @param msg1
     * @param msg2
     */
    public static void debug(Logger logger, String format, String msg1, String msg2) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, msg1, msg2);
        }
    }

    /**
     * debug级别日志，内部会对obj1，obj2执行JSONObject.toJSONString处理
     * <pre>
     * LogUtils.debug(logger, 'xxxxxx : {}, yyyyyy:{}', obj1, obj2)
     * </pre>
     *
     * @param logger
     * @param format
     * @param obj1
     * @param obj2
     */
    public static void debug(Logger logger, String format, Object obj1, Object obj2) {
        if (logger.isDebugEnabled()) {
            if(obj2 instanceof Throwable) {
                logger.debug(format, JSONObject.toJSONString(obj1), obj2);
            } else {
                logger.debug(format, JSONObject.toJSONString(obj1), JSONObject.toJSONString(obj2));
            }
        }
    }

    /**
     * <pre>
     * LogUtils.debug(logger, 'xxx:{}, yyy:{}, zzz:{},...www:{}', msg1, msg2, msg3,..., msgn)
     * </pre>
     *
     * @param logger
     * @param format
     * @param msgs
     */
    public static void debug(Logger logger, String format, String... msgs) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, msgs);
        }
    }

    /**
     * debug级别日志，内部会对obj1，obj2执行JSONObject.toJSONString处理
     * <pre>
     * LogUtils.debug(logger, 'xxx:{}, yyy:{}, zzz:{},...www:{}', obj1, obj2, obj3,..., objn)
     * </pre>
     *
     * @param logger
     * @param format
     * @param objs
     */
    public static void debug(Logger logger, String format, Object... objs) {
        if (logger.isDebugEnabled()) {
            if(objs != null) {
                Object[] msgs = new Object[objs.length];
                for(int i = 0; i < objs.length; i++) {
                    if(objs[i] instanceof Throwable) {
                        msgs[i] = objs[i];
                    } else {
                        msgs[i] = JSONObject.toJSONString(objs[i]);
                    }
                }
                logger.debug(format, msgs);
            }
        }
    }

    // ===================================info================================//
    /**
     * <pre>
     * LogUtils.info(logger, 'xxxxxx')
     * </pre>
     *
     * @param logger
     * @param obj
     */
    public static void info(Logger logger, String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    /**
     * <pre>
     * LogUtils.info(logger, 'xxxxxx : {}', msg)
     * </pre>
     *
     * @param logger
     * @param format
     * @param msg
     */
    public static void info(Logger logger, String format, String msg) {
        if (logger.isInfoEnabled()) {
            logger.info(format, msg);
        }
    }

    /**
     * info级别日志，内部对obj执行JSONObject.toJSONString
     * <pre>
     * LogUtils.info(logger, 'xxxxxx : {}', obj)
     * </pre>
     *
     * @param logger
     * @param format
     * @param obj
     */
    public static void info(Logger logger, String format, Object obj) {
        if (logger.isInfoEnabled()) {
            if(obj instanceof Throwable) {
                logger.info(format, obj);
            } else {
                logger.info(format, JSONObject.toJSONString(obj));
            }
        }
    }

    /**
     * <pre>
     * LogUtils.info(logger, 'xxxxxx : {}, yyyyyy:{}', obj1, obj2)
     * </pre>
     *
     * @param logger
     * @param format
     * @param msg1
     * @param msg2
     */
    public static void info(Logger logger, String format, String msg1, String msg2) {
        if (logger.isInfoEnabled()) {
            logger.info(format, msg1, msg2);
        }
    }

    /**
     * info级别日志，内部对obj执行JSONObject.toJSONString
     * <pre>
     * LogUtils.info(logger, 'xxxxxx : {}, yyyyyy:{}', obj1, obj2)
     * </pre>
     *
     * @param logger
     * @param format
     * @param obj1
     * @param obj2
     */
    public static void info(Logger logger, String format, Object obj1, Object obj2) {
        if (logger.isInfoEnabled()) {
            if(obj2 instanceof Throwable) {
                logger.info(format, JSONObject.toJSONString(obj1), obj2);
            } else {
                logger.info(format, JSONObject.toJSONString(obj1), JSONObject.toJSONString(obj2));
            }
        }
    }

    /**
     * <pre>
     * LogUtils.info(logger, 'xxx:{}, yyy:{}, zzz:{},...www:{}', msg1, msg2, msg3,..., msgn)
     * </pre>
     *
     * @param logger
     * @param format
     * @param msgs
     */
    public static void info(Logger logger, String format, String... msgs) {
        if (logger.isInfoEnabled()) {
            logger.info(format, msgs);
        }
    }

    /**
     * info级别日志，内部对obj执行JSONObject.toJSONString
     * <pre>
     * LogUtils.info(logger, 'xxx:{}, yyy:{}, zzz:{},...www:{}', obj1, obj2, obj3,..., objn)
     * </pre>
     *
     * @param logger
     * @param format
     * @param objs
     */
    public static void info(Logger logger, String format, Object... objs) {
        if (logger.isInfoEnabled()) {
            if(objs != null) {
                Object[] msgs = new Object[objs.length];
                for(int i = 0; i < objs.length; i++) {
                    if(objs[i] instanceof Throwable) {
                        msgs[i] = objs[i];
                    } else {
                        msgs[i] = JSONObject.toJSONString(objs[i]);
                    }
                }
                logger.info(format, msgs);
            }
        }
    }

    // ==============================warn===================================//

    /**
     * <pre>
     * LogUtils.warn(logger, 'xxxxxx : {}', msg)
     * </pre>
     *
     * @param logger
     * @param format
     * @param msg
     */
    public static void warn(Logger logger, String format, String msg) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, msg);
        }
    }

    /**
     * warn级别日志，内部对obj执行JSONObject.toJSONString
     * <pre>
     * LogUtils.warn(logger, 'xxxxxx : {}', obj)
     * </pre>
     *
     * @param logger
     * @param format
     * @param obj
     */
    public static void warn(Logger logger, String format, Object obj) {
        if (logger.isWarnEnabled()) {
            if (obj instanceof Throwable) {
                logger.warn(format, obj);
            } else {
                logger.warn(format, JSONObject.toJSONString(obj));
            }
        }
    }

    /**
     * <pre>
     * LogUtils.warn(logger, 'xxxxxx : {}, yyyyyy:{}', msg1, msg2)
     * </pre>
     *
     * @param logger
     * @param format
     * @param msg1
     * @param msg2
     */
    public static void warn(Logger logger, String format, String msg1, String msg2) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, msg1, msg2);
        }
    }

    /**
     * warn级别日志，内部对obj执行JSONObject.toJSONString
     * <pre>
     * LogUtils.warn(logger, 'xxxxxx : {}, yyyyyy:{}', obj1, obj2)
     * </pre>
     *
     * @param logger
     * @param format
     * @param obj1
     * @param obj2
     */
    public static void warn(Logger logger, String format, Object obj1, Object obj2) {
        if (logger.isWarnEnabled()) {
            if (obj2 instanceof Throwable) {
                logger.warn(format, JSONObject.toJSONString(obj1), obj2);
            } else {
                logger.warn(format, JSONObject.toJSONString(obj1), JSONObject.toJSONString(obj2));
            }
        }
    }

    /**
     * <pre>
     * LogUtils.warn(logger, 'xxx:{}, yyy:{}, zzz:{},...www:{}', msg1, msg2, msg3,..., msgn)
     * </pre>
     *
     * @param logger
     * @param format
     * @param msgs
     */
    public static void warn(Logger logger, String format, String... msgs) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, msgs);
        }
    }

    /**
     * warn级别日志，内部对obj执行JSONObject.toJSONString
     * <pre>
     * LogUtils.warn(logger, 'xxx:{}, yyy:{}, zzz:{},...www:{}', obj1, obj2, obj3,..., objn)
     * </pre>
     *
     * @param logger
     * @param format
     * @param objs
     */
    public static void warn(Logger logger, String format, Object... objs) {
        if (logger.isWarnEnabled()) {
            if(objs != null) {
                Object[] msgs = new Object[objs.length];
                for(int i = 0; i < objs.length; i++) {
                    if(objs[i] instanceof Throwable) {
                        msgs[i] = objs[i];
                    } else {
                        msgs[i] = JSONObject.toJSONString(objs[i]);
                    }
                }
                logger.warn(format, msgs);
            }
        }
    }

    // ==============================error===================================//

    /**
     * <pre>
     * LogUtils.error(logger, 'xxxxxx : {}', obj)
     * </pre>
     *
     * @param logger
     * @param format
     * @param msg
     */
    public static void error(Logger logger, String format, String msg) {
        if (logger.isErrorEnabled()) {
            logger.error(format, msg);
        }
    }

    /**
     * error级别日志，内部对obj执行JSONObject.toJSONString
     * <pre>
     * LogUtils.error(logger, 'xxxxxx : {}', obj)
     * </pre>
     *
     * @param logger
     * @param format
     * @param obj
     */
    public static void error(Logger logger, String format, Object obj) {
        if (logger.isErrorEnabled()) {
            if(obj instanceof Throwable) {
                logger.error(format, obj);
            } else {
                logger.error(format, JSONObject.toJSONString(obj));
            }
        }
    }

    /**
     * <pre>
     * LogUtils.error(logger, 'xxxxxx : {}, yyyyyy:{}', msg1, msg2)
     * </pre>
     *
     * @param logger
     * @param format
     * @param msg1
     * @param msg2
     */
    public static void error(Logger logger, String format, String msg1, String msg2) {
        if (logger.isErrorEnabled()) {
            logger.error(format, msg1, msg2);
        }
    }

    /**
     * error级别日志，内部对obj执行JSONObject.toJSONString
     * <pre>
     * LogUtils.error(logger, 'xxxxxx : {}, yyyyyy:{}', obj1, obj2)
     * </pre>
     *
     * @param logger
     * @param format
     * @param obj1
     * @param obj2
     */
    public static void error(Logger logger, String format, Object obj1, Object obj2) {
        if (logger.isErrorEnabled()) {
            if (obj2 instanceof Throwable) {
                logger.error(format, JSONObject.toJSONString(obj1), obj2);
            } else {
                logger.error(format, JSONObject.toJSONString(obj1), JSONObject.toJSONString(obj2));
            }

        }
    }

    /**
     * <pre>
     * LogUtils.error(logger, 'xxx:{}, yyy:{}, zzz:{},...www:{}', msg1, msg2, msg3,..., msgn)
     * </pre>
     *
     * @param logger
     * @param format
     * @param msgs
     */
    public static void error(Logger logger, String format, String... msgs) {
        if (logger.isErrorEnabled()) {
            logger.error(format, msgs);
        }
    }

    /**
     * error级别日志，内部对obj执行JSONObject.toJSONString
     * <pre>
     * LogUtils.error(logger, 'xxx:{}, yyy:{}, zzz:{},...www:{}', obj1, obj2, obj3,..., objn)
     * </pre>
     *
     * @param logger
     * @param format
     * @param objs
     */
    public static void error(Logger logger, String format, Object... objs) {
        if (logger.isErrorEnabled()) {
            if(objs != null) {
                Object[] msgs = new Object[objs.length];
                for(int i = 0; i < objs.length; i++) {
                    if (objs[i] instanceof Throwable) {
                        msgs[i] = objs[i];
                    } else {
                        msgs[i] = JSONObject.toJSONString(objs[i]);
                    }
                }
                logger.error(format, objs);
            }
        }
    }
}
