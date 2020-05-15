package hudson.plugins.extendedread;

import hudson.model.Computer;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

import hudson.Extension;
import hudson.init.InitMilestone;
import hudson.init.Initializer;
import hudson.model.Item;

@Extension
@Restricted(NoExternalUse.class)
public class ExtendedReadPermissionEnabler {
    @Initializer(after = InitMilestone.PLUGINS_STARTED)
    public static void enableExtendedReadPermission() {
        if (System.getProperty("hudson.security.ExtendedReadPermission") == null) {
            Item.EXTENDED_READ.setEnabled(true);
            Computer.EXTENDED_READ.setEnabled(true);
        }
    }
}
