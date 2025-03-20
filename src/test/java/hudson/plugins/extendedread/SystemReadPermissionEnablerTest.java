package hudson.plugins.extendedread;

import hudson.security.Permission;
import hudson.util.VersionNumber;
import jenkins.model.Jenkins;
import org.junit.jupiter.api.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.junit.jupiter.WithJenkins;

import static java.util.Objects.requireNonNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@WithJenkins
class SystemReadPermissionEnablerTest {

    @Test
    void testSystemReadPermissionEnabled(JenkinsRule j) {
        VersionNumber version = requireNonNull(Jenkins.getVersion());
        assumeTrue(version.isNewerThan(new VersionNumber("2.221")), "This test requires Jenkins core version 2.221 or newer");

        Permission systemRead = SystemReadPermission.SYSTEM_READ;

        // let's be safe and validate we aren't using the administer fallback
        assertThat(systemRead.name, is("SystemRead"));
        assertThat(systemRead.getEnabled(), is(true));
    }
}
