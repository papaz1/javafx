package integration;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URL;

public class Poster {
    private final String HTTP_HEADER_ACCEPT = "Accept";
    private final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
    private final String APPLICATION_JSON = "application/json";

    private HttpClient httpClient;
    private HttpPost request;

    public Poster(String username, String password) {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
        provider.setCredentials(AuthScope.ANY, credentials);
        httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
    }

    public HttpResponse postMessage(String message, URL url) throws IOException {
        StringEntity entity = new StringEntity(message, ContentType.APPLICATION_FORM_URLENCODED);
        request = new HttpPost(String.valueOf(url));
        request.setHeader(HTTP_HEADER_CONTENT_TYPE, APPLICATION_JSON);
        request.setHeader(HTTP_HEADER_ACCEPT, APPLICATION_JSON);
        request.setEntity(entity);
        return httpClient.execute(request);
    }
}
