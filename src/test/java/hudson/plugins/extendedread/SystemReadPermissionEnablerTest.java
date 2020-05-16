package hudson.plugins.extendedread;

import hudson.security.Permission;
import hudson.util.VersionNumber;
import jenkins.model.Jenkins;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import static java.util.Objects.requireNonNull;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

public class SystemReadPermissionEnablerTest {
    @Rule
    public JenkinsRule j =  new JenkinsRule();

    @Test
    public void testSystemReadPermissionEnabled() {
        VersionNumber version = requireNonNull(Jenkins.getVersion());
        assumeThat("This test requires Jenkins core version 2.221 or newer", version, greaterThan(new VersionNumber("2.221")));
        
        Permission systemRead = SystemReadPermission.SYSTEM_READ;
        
        // let's be safe and validate we aren't using the administer fallback
        assertThat(systemRead.name, is("SystemRead"));
        assertThat(systemRead.getEnabled(), is(true));
    }
}
