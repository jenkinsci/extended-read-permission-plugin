/**
 * Copyright (c) 2009 Yahoo! Inc.
 * All rights reserved.
 * The copyrights to the contents of this file are licensed under the MIT License
 * (http://www.opensource.org/licenses/mit-license.php)
 */

package hudson.plugins.extendedread;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import hudson.model.Item;

/**
 *
 * @author dty
 */
public class ExtendedReadPermissionTest {

    @Rule
    public JenkinsRule j =  new JenkinsRule();

    @Test
    public void testExtendedReadPermissionEnabled() throws Exception {
        assertTrue(Item.EXTENDED_READ.getEnabled());
    }
}
