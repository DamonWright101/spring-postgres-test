package com.fitchtree.postgresdemo.Endpoints;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties("application.endpoints")
public class ApiConnectors {

    private String host = "127.0.0.1";
    private String port = "80";
    private String protocol = "http";
    private String url = "invalidUrl";

    // getters and setters
	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
    }
    
	public String getPort() {
		return this.port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getProtocol() {
		return this.protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
    }

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    // functional code
    public String getJsonFromApi(String apiExtension) {
        RestTemplate restTemplate = new RestTemplate();
        if (UrlUsingDefaultValue()) setUrlFromParams();
        return restTemplate.getForObject(getUrl() + apiExtension, String.class);
    }

    private boolean UrlUsingDefaultValue() {
        if (this.url.equals("invalidUrl")) return true;
        return false;
    }

    private void setUrlFromParams() {
        this.url = this.protocol + "://" + this.host + ":" + this.port;
    }
}