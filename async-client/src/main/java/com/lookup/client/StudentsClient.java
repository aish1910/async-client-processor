package com.lookup.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lookup.client.model.Response;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;

public class StudentsClient {

    public Response getStudent(String id) throws IOException, InterruptedException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(new HttpPost(URI.create("http://localhost:8092/students/" + id)));
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        Response responseBody = mapper.readValue(responseString, Response.class);
        return responseBody;
    }
}
