package com.kyleruss.collector.mobile.comms;

import java.util.HashMap;
import java.util.Map;

public class HTTPAsync
{
    private String url;
    private Map params;

    public HTTPAsync()
    {
        url     =   "";
        params  =   new HashMap();
    }

    public HTTPAsync(String url, Map params)
    {
        this.url    =   url;
        this.params =   params;
    }

    public String getUrl()
    {
        return url;
    }

    public Map getParams()
    {
        return params;
    }

    public void addParam(String name, Object value)
    {
        params.put(name, value);
    }
}
