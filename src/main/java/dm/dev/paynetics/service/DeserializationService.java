package dm.dev.paynetics.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class DeserializationService {
    private final ObjectMapper objectMapper;

    public <T> T deserialize(String pathToFile, Class<T> tClass) throws IOException {
        var resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(pathToFile);
        return objectMapper.readValue(resourceAsStream, tClass);
    }
}
