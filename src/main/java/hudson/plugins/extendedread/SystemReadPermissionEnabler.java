package hudson.plugins.extendedread;

import hudson.Extension;
import hudson.init.InitMilestone;
import hudson.init.Initializer;
import jenkins.model.Jenkins;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

@Extension
@Restricted(NoExternalUse.class)
public class SystemReadPermissionEnabler {

    @Initializer(after = InitMilestone.PLUGINS_STARTED)
    public static void enableSystemReadPermission() {
        if (System.getProperty("jenkins.security.SystemReadPermission") == null) {
            Jenkins.SYSTEM_READ.setEnabled(true);
        }
    }
}
