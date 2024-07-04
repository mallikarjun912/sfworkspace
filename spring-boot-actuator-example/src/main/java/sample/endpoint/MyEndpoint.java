package sample.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "myend",enableByDefault = true)
public class MyEndpoint {
	@ReadOperation
	public MyEndpointResponse features() {
		return new MyEndpointResponse(12345, "my endpoint", "active");
	}
}
