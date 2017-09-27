package com.imory.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.imory.bean.test.Demo;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 */
public class UnirestUtils {

    private static Logger logger = Logger.getLogger(UnirestUtils.class);

    /***
     * 获取string类型返回
     * @param url 地址
     * @param paramsMap 参数
     * @param method 方法
     * @return 返回
     */
    public static String getStringResponse(String url, Map<String, Object> paramsMap, String method)
    {
        logger.info("UnirestUtils.getStringResponse=>链接地址:[" + url + "],参数:[" + (paramsMap != null ? paramsMap.toString() : "") + "],方法:[" + method + "]");
        if (StringUtils.isBlank(method))
        {
            method = "get";
        }
        if (paramsMap == null)
        {
            paramsMap = new HashMap<>();
        }
        try
        {
            HttpResponse<String> jsonResponse = null;
            if ("get".equalsIgnoreCase(method))
            {
                jsonResponse = Unirest.get(url)
                        .queryString(paramsMap)
                        .asString();
            } else if ("post".equalsIgnoreCase(method))
            {
                jsonResponse = Unirest.post(url)
                        .fields(paramsMap)
                        .asString();
            } else if ("delete".equalsIgnoreCase(method))
            {
                jsonResponse = Unirest.delete(url)
                        .fields(paramsMap)
                        .asString();
            }
            if (jsonResponse == null)
            {
                logger.error("访问[" + url + "],参数[" + paramsMap.toString() + "]出错,返回状态:null");
                return null;
            }
            if (200 == jsonResponse.getStatus())
            {
                return jsonResponse.getBody();
            } else
            {
                logger.error("访问[" + url + "],参数[" + paramsMap.toString() + "]出错,返回状态:" + jsonResponse.getStatus());
                return null;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error("访问[" + url + "],参数[" + paramsMap.toString() + "]出错,出现异常:" + e.getMessage());
            return null;
        } finally
        {
            try
            {
                Unirest.shutdown();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取string类型返回
     *
     * @param url 地址
     * @return 返回
     */
    public static String getStringResponse(String url)
    {
        logger.info("UnirestUtils.getStringResponse=>链接地址:[" + url + "],方法:[get]");
        try
        {
            HttpResponse<String> jsonResponse = Unirest.get(url)
                    .asString();
            if (200 == jsonResponse.getStatus())
            {
                return jsonResponse.getBody();
            } else
            {
                logger.error("访问[" + url + "],返回状态:" + jsonResponse.getStatus());
                return null;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error("访问[" + url + "],出现异常:" + e.getMessage());
            return null;
        } finally
        {
            try
            {
                Unirest.shutdown();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /***
     * 获取string类型返回
     * @param url 地址
     * @return 返回
     */
    public static String postStringResponse(String url)
    {
        logger.info("UnirestUtils.postStringResponse=>链接地址:[" + url + "],方法:[post]");
        try
        {
            HttpResponse<String> jsonResponse = Unirest.post(url)
                    .asString();
            if (200 == jsonResponse.getStatus())
            {
                return jsonResponse.getBody();
            } else
            {
                logger.error("访问[" + url + "],返回状态:" + jsonResponse.getStatus());
                return null;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error("访问[" + url + "],出现异常:" + e.getMessage());
            return null;
        } finally
        {
            try
            {
                Unirest.shutdown();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /***
     * 获取JsonNode类型返回
     * @param url 地址
     * @param paramsMap 参数
     * @param method 方法
     * @return 返回
     */
    public static JsonNode getJsonNodeResponse(String url, Map<String, Object> paramsMap, String method)
    {
        logger.info("UnirestUtils.getJsonNodeResponse=>链接地址:[" + url + "],参数:[" + (paramsMap != null ? paramsMap.toString() : "") + "],方法:[" + method + "]");
        if (StringUtils.isBlank(method))
        {
            method = "get";
        }
        if (paramsMap == null)
        {
            paramsMap = new HashMap<>();
        }
        try
        {
            HttpResponse<JsonNode> jsonResponse = null;
            if ("get".equalsIgnoreCase(method))
            {
                jsonResponse = Unirest.get(url)
                        .queryString(paramsMap)
                        .asJson();
            } else if ("post".equalsIgnoreCase(method))
            {
                jsonResponse = Unirest.post(url)
                        .fields(paramsMap)
                        .asJson();
            } else if ("delete".equalsIgnoreCase(method))
            {
                jsonResponse = Unirest.delete(url)
                        .fields(paramsMap)
                        .asJson();
            }
            if (jsonResponse == null)
            {
                logger.error("访问[" + url + "],参数[" + paramsMap.toString() + "]出错,返回状态:null");
                return null;
            }
            if (200 == jsonResponse.getStatus())
            {
                return jsonResponse.getBody();
            } else
            {
                logger.error("访问[" + url + "],参数[" + paramsMap.toString() + "]出错,返回状态:" + jsonResponse.getStatus());
                return null;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error("访问[" + url + "],参数[" + paramsMap.toString() + "]出错,出现异常:" + e.getMessage());
            return null;
        } finally
        {
            try
            {
                Unirest.shutdown();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /***
     * 获取JsonNode类型返回
     * @param url 地址
     * @return 返回
     */
    public static JsonNode getJsonNodeResponse(String url)
    {
        logger.info("UnirestUtils.getJsonNodeResponse=>链接地址:[" + url + "],方法:[get]");
        try
        {
            HttpResponse<JsonNode> jsonResponse = Unirest.get(url)
                    .asJson();
            if (200 == jsonResponse.getStatus())
            {
                return jsonResponse.getBody();
            } else
            {
                logger.error("访问[" + url + "],返回状态:" + jsonResponse.getStatus());
                return null;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error("访问[" + url + "],出现异常:" + e.getMessage());
            return null;
        } finally
        {
            try
            {
                Unirest.shutdown();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /***
     * 获取JsonNode类型返回
     * @param url 地址
     * @return 返回
     */
    public static JsonNode postJsonNodeResponse(String url)
    {
        logger.info("UnirestUtils.postJsonNodeResponse=>链接地址:[" + url + "],方法:[post]");
        try
        {
            HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
                    .asJson();
            if (200 == jsonResponse.getStatus())
            {
                return jsonResponse.getBody();
            } else
            {
                logger.error("访问[" + url + "],返回状态:" + jsonResponse.getStatus());
                return null;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error("访问[" + url + "],出现异常:" + e.getMessage());
            return null;
        } finally
        {
            try
            {
                Unirest.shutdown();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /***
     * 获取对象类型返回
     * @param url 地址
     * @param paramsMap 参数
     * @param method 方法
     * @param T 类
     * @return 返回
     */
    public static Object getObjectResponse(String url, Map<String, Object> paramsMap, String method, Class T)
    {
        logger.info("UnirestUtils.getObjectResponse=>链接地址:[" + url + "],参数:[" + (paramsMap != null ? paramsMap.toString() : "") + "],方法:[" + method + "],类:[" + T + "]");
        if (StringUtils.isBlank(method))
        {
            method = "get";
        }
        if (paramsMap == null)
        {
            paramsMap = new HashMap<>();
        }
        try
        {
            setObjectMapper();
            HttpResponse jsonResponse = null;
            if ("get".equalsIgnoreCase(method))
            {
                jsonResponse = Unirest.get(url)
                        .queryString(paramsMap)
                        .asObject(T);
            } else if ("post".equalsIgnoreCase(method))
            {
                jsonResponse = Unirest.post(url)
                        .fields(paramsMap)
                        .asObject(T);
            } else if ("delete".equalsIgnoreCase(method))
            {
                jsonResponse = Unirest.delete(url)
                        .fields(paramsMap)
                        .asObject(T);
            }
            if (jsonResponse == null)
            {
                logger.error("访问[" + url + "],参数[" + paramsMap.toString() + "]出错,返回状态:" + jsonResponse);
                return null;
            }
            if (200 == jsonResponse.getStatus())
            {
                return jsonResponse.getBody();
            } else
            {
                logger.error("访问[" + url + "],参数[" + paramsMap.toString() + "]出错,返回状态:" + jsonResponse.getStatus());
                return null;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error("访问[" + url + "],参数[" + paramsMap.toString() + "]出错,出现异常:" + e.getMessage());
            return null;
        } finally
        {
            try
            {
                Unirest.shutdown();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /***
     * 获取对象类型返回
     * @param url 地址
     * @param T 类
     * @return 返回
     */
    public static Object getObjectResponse(String url, Class T)
    {
        logger.info("UnirestUtils.getObjectResponse=>链接地址:[" + url + "],方法:[get],类:[" + T + "]");
        try
        {
            setObjectMapper();
            HttpResponse jsonResponse = jsonResponse = Unirest.get(url)
                    .asObject(T);
            if (200 == jsonResponse.getStatus())
            {
                return jsonResponse.getBody();
            } else
            {
                logger.error("访问[" + url + "],返回状态:" + jsonResponse.getStatus());
                return null;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error("访问[" + url + "],出现异常:" + e.getMessage());
            return null;
        } finally
        {
            try
            {
                Unirest.shutdown();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /***
     * 获取对象类型返回
     * @param url 地址
     * @param T 类
     * @return 返回
     */
    public static Object postObjectResponse(String url, Class T)
    {
        logger.info("UnirestUtils.postObjectResponse=>链接地址:[" + url + "],方法:[post],类:[" + T + "]");
        try
        {
            setObjectMapper();
            HttpResponse jsonResponse = jsonResponse = Unirest.post(url)
                    .asObject(T);
            if (200 == jsonResponse.getStatus())
            {
                return jsonResponse.getBody();
            } else
            {
                logger.error("访问[" + url + "],返回状态:" + jsonResponse.getStatus());
                return null;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error("访问[" + url + "],出现异常:" + e.getMessage());
            return null;
        } finally
        {
            try
            {
                Unirest.shutdown();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


    private static void setObjectMapper()
    {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType)
            {
                try
                {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value)
            {
                try
                {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e)
                {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static void main(String args[]) throws Exception
    {
        try
        {
            //System.out.println(UnirestUtils.getStringResponse("http://127.0.0.1:8082/test/index", null, null));
            //JsonNode map = (JsonNode) UnirestUtils.getJsonNodeResponse("http://127.0.0.1:8082/test/map", null, null);

            Demo test = (Demo) UnirestUtils.getObjectResponse("http://127.0.0.1:8082/test/demo", null, null, Demo.class);
            System.out.println(test.getDemo());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
