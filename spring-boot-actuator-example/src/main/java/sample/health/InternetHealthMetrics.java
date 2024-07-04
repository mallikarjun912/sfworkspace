package sample.health;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class InternetHealthMetrics implements HealthIndicator{

	@Override
	public Health health() {
		Health health = null;
		if(checkInternet() == true)
			health = Health.up().withDetail("success code", "Active Internet connection").build();
		else
			health = Health.down().withDetail("error code", "Inactive Internet connection").build();
		return health;
	} 
	
	private boolean checkInternet() {
		boolean flag = false;
		try {
			URL url = new URL("https://www.gmail.com");
			URLConnection connection = url.openConnection();
			connection.connect();
			flag = true;
		} catch (IOException e) {
				
		}
		return flag;
	}

}
