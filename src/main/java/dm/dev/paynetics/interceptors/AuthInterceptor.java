package dm.dev.paynetics.interceptors;

import com.google.common.hash.Hashing;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.UUID;


@Component
public class AuthInterceptor implements RequestInterceptor {

    private final String apiKey = "x-api-key";
    private final String secretKey = "secretKey";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String ts = Long.toString(System.currentTimeMillis());
        String operation = requestTemplate.headers().remove("X-Operation").iterator().next();

        requestTemplate.header("x-api-key", apiKey);
        requestTemplate.header("x-timestamp", ts);
        requestTemplate.header("x-hash", getHash(ts, operation, new String(requestTemplate.body())));
        requestTemplate.header("X-Request-Id", UUID.randomUUID().toString());
    }

    private String getHash(String ts, String operation, String body) {
        String input = apiKey + ts + operation + body;

        return Hashing.hmacSha256(secretKey.getBytes(StandardCharsets.UTF_8))
                .hashString(input, StandardCharsets.UTF_8)
                .toString();

    }
}
