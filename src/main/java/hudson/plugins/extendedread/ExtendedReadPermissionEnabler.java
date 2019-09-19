package hudson.plugins.extendedread;

import hudson.Extension;
import hudson.init.InitMilestone;
import hudson.init.Initializer;
import hudson.model.Item;

@Extension
public class ExtendedReadPermissionEnabler {
    @Initializer(after = InitMilestone.STARTED)
    public static void EnableExtendedReadPermission() {
        if (System.getProperty("hudson.security.ExtendedReadPermission") == null) {
            Item.EXTENDED_READ.setEnabled(true);
        }
    }
}