package io.tus.java.client;

import java.net.HttpCookie;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class URLDetail {

    private URL url;

    private Set<HttpCookie> cookies;

    public URLDetail() {
    }

    public URLDetail(URL url) {
        this.url = url;
        this.cookies = new HashSet<>();
    }

    public URLDetail(URL url, Set<HttpCookie> cookies) {
        this.url = url;
        this.cookies = cookies;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Set<HttpCookie> getCookies() {
        return cookies;
    }

    public void setCookies(Set<HttpCookie> cookies) {
        this.cookies = cookies;
    }
}
