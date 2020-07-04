package push;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import utility.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class PushForIBReg {
    InputStream inputStream;
    int responseCode;


    public static String mobilePIN=Util.generateRandomPUSH();
    public int PushApi() throws URISyntaxException, IOException, InterruptedException, NullPointerException {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            String burl = prop.getProperty("PUSH_Api");
            String loginId = Util.readConfigData()[10];
            String loginPass = mobilePIN;


            URI uri = new URIBuilder(burl)
                    .setParameter("Authorization", "Basic c2FsbWFuOjY1NDMyMQ==")
                    .setParameter("Content-Type", "application/json")
                    .addParameter("mobile", loginId)
                    .addParameter("text", loginPass)
                    .build();

            @SuppressWarnings("resource")
            HttpClient client = new DefaultHttpClient();
            HttpGet axw = new HttpGet(uri);
            HttpResponse response = client.execute(axw);
            int responseCode = response.getStatusLine().getStatusCode();

            System.out.println("Response Code: " + burl + loginId + loginPass);
            System.out.println("Response Code: " + responseCode);
            //Thread.sleep(3000);
            //return responseCode;
        }catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return responseCode;
        }

    }
