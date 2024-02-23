package com.coderhouse.java.servicios;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ServicioDeFechas {

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
    private final static String URL = "http://worldclockapi.com/api/json/utc/now";

    public LocalDateTime obtenerFechaActual() {

        LocalDateTime ahora;

        try {

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> respuesta = restTemplate.getForEntity(URL, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(respuesta.getBody());
            String fechaEnString = root.path("currentDateTime").asText();
            ahora = LocalDateTime.parse(fechaEnString, FORMATTER);

        } catch (Exception e) {
            ahora = LocalDateTime.now();
        }

        return ahora;
    }
}


