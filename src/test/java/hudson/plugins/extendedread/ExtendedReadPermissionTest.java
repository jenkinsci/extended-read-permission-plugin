/**
 * Copyright (c) 2009 Yahoo! Inc.
 * All rights reserved.
 * The copyrights to the contents of this file are licensed under the MIT License
 * (http://www.opensource.org/licenses/mit-license.php)
 */

package hudson.plugins.extendedread;

import hudson.model.Item;

import org.jvnet.hudson.test.HudsonTestCase;

/**
 *
 * @author dty
 */
public class ExtendedReadPermissionTest extends HudsonTestCase {
    public void testExtendedReadPermissionEnabled() throws Exception {
        assertTrue(Item.EXTENDED_READ.getEnabled());
    }
}
