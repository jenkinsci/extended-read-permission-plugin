/**
 * Copyright (c) 2009 Yahoo! Inc.
 * All rights reserved.
 * The copyrights to the contents of this file are licensed under the MIT License
 * (http://www.opensource.org/licenses/mit-license.php)
 */

package hudson.plugins.extendedread;

import hudson.Plugin;
import hudson.model.Item;

/**
 *
 * @author dty
 */
public class PluginImpl extends Plugin {
    @Override
    public void start() throws Exception {
        // Only enable if not explicitly controlled by the system property
        if (System.getProperty("hudson.security.ExtendedReadPermission")==null) {
            enablePermission();
        }
    }

    private void enablePermission() throws Exception {
        try {
            Class clazz = Item.class;
            if (clazz!=null) {
                clazz.getDeclaredField("EXTENDED_READ");
            }
            Item.EXTENDED_READ.setEnabled(true);
        }
        catch (NoSuchFieldException e) {
            // Silently ignore non-existence of the permission.
        }
    }
}
