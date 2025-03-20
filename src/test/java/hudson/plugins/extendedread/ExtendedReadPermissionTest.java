/**
 * Copyright (c) 2009 Yahoo! Inc.
 * All rights reserved.
 * The copyrights to the contents of this file are licensed under the MIT License
 * (http://www.opensource.org/licenses/mit-license.php)
 */

package hudson.plugins.extendedread;

import hudson.model.Computer;
import hudson.model.Item;
import org.junit.jupiter.api.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.junit.jupiter.WithJenkins;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author dty
 */
@WithJenkins
class ExtendedReadPermissionTest {


    @Test
    void testItemExtendedReadPermissionEnabled(JenkinsRule j) {
        assertTrue(Item.EXTENDED_READ.getEnabled());
    }

    @Test
    void testComputerExtendedReadPermissionEnabled(JenkinsRule j) {
        assertTrue(Computer.EXTENDED_READ.getEnabled());
    }
}
