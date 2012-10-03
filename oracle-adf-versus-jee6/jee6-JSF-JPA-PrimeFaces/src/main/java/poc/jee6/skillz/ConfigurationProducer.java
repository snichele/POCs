package poc.jee6.skillz;

import java.io.IOException;
import java.util.Properties;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import lombok.extern.slf4j.Slf4j;

/**
 * A bean that load application configuration properties file and expose the
 * properties using the @Produces CDI annotation.
 *
 * @author snichele
 */
@Slf4j
public class ConfigurationProducer {

    private final static Properties configProperties = new Properties();
    public static final String propertiesFilePath = "/config/application.properties";

    static {
        try {
            log.debug("Finding " + propertiesFilePath);
            log.debug("ConfigurationProducer.class.getResourceAsStream(propertiesFilePath) = " + ConfigurationProducer.class.getResourceAsStream(propertiesFilePath));
            configProperties.load(ConfigurationProducer.class.getResourceAsStream(propertiesFilePath));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Config
    @Produces
    public String getConfiguration(InjectionPoint p) {

        String configKey = p.getMember().getDeclaringClass().getName() + "." + p.getMember().getName();
        if (configProperties.getProperty(configKey) == null) {
            configKey = p.getMember().getDeclaringClass().getSimpleName() + "." + p.getMember().getName();
            if (configProperties.getProperty(configKey) == null) {
                configKey = p.getMember().getName();
            }
        }

        return configProperties.getProperty(configKey);
    }
}
