package br.com.fase3.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class StatusComponent {
    
    private final Properties properties;

    public StatusComponent() throws IOException{
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.yml");
        properties.load(inputStream);
    }

    public String getStatus() {
        return "Running on port: " + properties.get("port");
    }
}
