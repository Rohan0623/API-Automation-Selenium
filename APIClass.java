package API;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;


public class APIClass {

    public void getAPIRequest() throws IOException {

        //Below line allows to handle http requests. It creates a threadsafe closable http client and returns a new instance HttpClient
        HttpClient client = HttpClientBuilder.create().build();

        String path = "full path of the API";
        HttpPost request = new HttpPost(path);
        request.addHeader("headerName", "value");
        request.addHeader("headerName", "value");

        //Executing the Get request
        HttpResponse response = client.execute(request);

        // Printing the status code
        System.out.println(response.getStatusLine().getStatusCode());

        // Printing the http response entity as a string
        System.out.println(EntityUtils.toString(response.getEntity()));
    }


    /* if the body is passed in json format. Use the below code for a post request */

    public void postAPIRequestJsonFormat() throws IOException{

        //Below line allows to handle http requests. It creates a threadsafe closable http client and returns a new instance HttpClient
        HttpClient client = HttpClientBuilder.create().build();

        JSONObject json = new JSONObject();
        json.put("parameter1", "value1");
        json.put("parameter2", "value2");
        json.put("parameter3", "value3");

        // below line is used to convert json parameters into string format to be passed as httpentity in request
        HttpEntity e = new StringEntity(json.toString());
        String path = "full path of the API";
        HttpPost request = new HttpPost(path);
        request.setEntity(e);
        request.addHeader("headerName", "value");
        request.addHeader("headerName", "value");

        //Executing the post request
        HttpResponse response = client.execute(request);

        // Printing the status code
        System.out.println(response.getStatusLine().getStatusCode());

        // Printing the http response entity as a string
        System.out.println(EntityUtils.toString(response.getEntity()));
    }


    /* if the body is passed in Url encoded format. Use the below code for a post request */

    public void postAPIRequestEncodedFormat() throws IOException{

        //Below line allows to handle http requests. It creates a threadsafe closable http client and returns a new instance HttpClient
        HttpClient client = HttpClientBuilder.create().build();

        ArrayList<NameValuePair> postParameters = new ArrayList<>();
        postParameters.add(new BasicNameValuePair("parameter1", "value1"));
        postParameters.add(new BasicNameValuePair("parameter1", "value1"));
        String path = "full path of the API";
        HttpPost request = new HttpPost(path);

        // below line creates a UrlEncodedFormEntity from a List of NameValuePairs and passing it is as request parameter
        request.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));

        request.addHeader("headerName", "value");
        request.addHeader("headerName", "value");
        //Executing the post request
        HttpResponse response = client.execute(request);

        // Printing the status code
        System.out.println(response.getStatusLine().getStatusCode());

        // Printing the http response entity as a string
        System.out.println(EntityUtils.toString(response.getEntity()));

    }


    public void putAPIRequest() throws IOException {

        //Below line allows to handle http requests. It creates a threadsafe closable http client and returns a new instance HttpClient
        HttpClient client = HttpClientBuilder.create().build();

        JSONObject json = new JSONObject();
        json.put("parameter1", "value1");
        json.put("parameter2", "value2");
        json.put("parameter3", "value3");
        // below line is used to convert json parameters into string format to be passed as httpentity in request
        HttpEntity e = new StringEntity(json.toString());
        String path = "full path of the API";
        HttpPut request = new HttpPut(path);
        request.setEntity(e);
        request.addHeader("headerName", "value");
        request.addHeader("headerName", "value");

        //Executing the put request
        HttpResponse response = client.execute(request);

        // Printing the status code
        System.out.println(response.getStatusLine().getStatusCode());

        // Printing the http response entity as a string
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    public void deleteAPIRequest() throws IOException {

        //Below line allows to handle http requests. It creates a threadsafe closable http client and returns a new instance HttpClient
        HttpClient client = HttpClientBuilder.create().build();

        String path = "full path of the API";
        HttpDelete request = new HttpDelete(path);
        request.addHeader("headerName", "value");
        request.addHeader("headerName", "value");

        //Executing the delete request
        HttpResponse response = client.execute(request);

        // Printing the status code
        System.out.println(response.getStatusLine().getStatusCode());

        // Printing the http response entity as a string
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

}
