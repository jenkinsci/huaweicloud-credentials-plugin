package com.huawei.devcloud.credentials;

import com.cloudbees.plugins.credentials.CredentialsDescriptor;
import com.cloudbees.plugins.credentials.CredentialsScope;
import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;
import edu.umd.cs.findbugs.annotations.CheckForNull;
import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.util.FormValidation;
import hudson.util.Secret;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

public class HWCloudTokenCredentialsImpl extends BaseStandardCredentials  implements HWCloudTokenCredentials {
    private final Secret token;

    @DataBoundConstructor
    public HWCloudTokenCredentialsImpl(@CheckForNull CredentialsScope scope, @CheckForNull String id,@CheckForNull String description, @CheckForNull String token) {
        super(id, description);
        this.token = Secret.fromString(token);
    }

    @Override
    public Secret getToken() {
        return token;
    }

    @Extension
    public static class DescriptorImpl extends CredentialsDescriptor {

        @Override
        public String getDisplayName() {
            return Messages.devcloud_iam_Token_name();
        }

        public FormValidation doCheckSecretKey(@QueryParameter("token") final String token){
            if (StringUtils.isBlank(token)) {
                return FormValidation.ok();
            }
            return FormValidation.ok();
        }

    }
}
