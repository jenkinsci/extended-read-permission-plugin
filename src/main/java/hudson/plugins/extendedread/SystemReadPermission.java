package hudson.plugins.extendedread;

import hudson.security.Permission;
import hudson.util.ReflectionUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jenkins.model.Jenkins;

import static jenkins.model.Jenkins.ADMINISTER;

public class SystemReadPermission {

    private static final Logger LOGGER = Logger.getLogger(SystemReadPermission.class.getName());

    public static final Permission SYSTEM_READ;

    static {
        Permission systemRead;
        try {
            systemRead = (Permission) ReflectionUtils.getPublicProperty(Jenkins.getInstance(), "SYSTEM_READ");
        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            LOGGER.log(Level.FINE, "Couldn't find system read permission, falling back to ADMINISTER", e);
            systemRead = ADMINISTER;
        }

        SYSTEM_READ = systemRead;
    }
}