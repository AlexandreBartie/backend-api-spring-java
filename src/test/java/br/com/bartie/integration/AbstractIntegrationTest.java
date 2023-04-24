package br.com.bartie.integration;

import java.util.Map;
import java.util.stream.Stream;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.lifecycle.Startables;

@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {


    public class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:latest");

        private static void startContainers() {
            Startables.deepStart(Stream.of(mysql)).join();
        }

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        public void initialize(ConfigurableApplicationContext context) {

            startContainers();

            ConfigurableEnvironment env = context.getEnvironment();

            MapPropertySource container = new MapPropertySource("testcontainers", (Map) connectionDB());

            env.getPropertySources().addFirst(container);

        }

		private static Map<String, String> connectionDB() {
			return Map.of(
				"spring.datasource.url", mysql.getJdbcUrl(),
				"spring.datasource.username", mysql.getUsername(),
				"spring.datasource.password", mysql.getPassword()
			);
		}

    }


}

