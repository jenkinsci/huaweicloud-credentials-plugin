package com.huawei.devcloud.credentials;

import com.cloudbees.plugins.credentials.CredentialsDescriptor;
import com.cloudbees.plugins.credentials.CredentialsScope;
import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;
import edu.umd.cs.findbugs.annotations.CheckForNull;
import hudson.Extension;
import hudson.util.FormValidation;
import hudson.util.Secret;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

/**
 *
 */
public class HWCloudIAMUserCredentials extends BaseStandardCredentials implements HWCloudCredentials,BasicCredentials{
    private final Secret password;
    private final Secret userName;
    private final String iamUrl;

    @DataBoundConstructor
    public HWCloudIAMUserCredentials(@CheckForNull CredentialsScope scope, @CheckForNull String id, @CheckForNull String description, @CheckForNull String userName, @CheckForNull String password,@CheckForNull String iamUrl) {
        super(id, description);
        this.userName = Secret.fromString(userName);
        this.password = Secret.fromString(password);
        this.iamUrl= iamUrl;
    }

    @Override
    public Secret getPassword() {
        return password;
    }

    @Override
    public Secret getUserName() {
        return userName;
    }

    public String getIamUrl() {
        return iamUrl;
    }

    public String getDisplayName() {
        return userName.getPlainText() ;
    }

    @Override
    public String getMessage() {
        return Messages.devcloud_basic_credentials_name();
    }

    @Extension
    public static class DescriptorImpl extends CredentialsDescriptor {

        @Override
        public String getDisplayName() {
            return Messages.devcloud_basic_credentials_name();
        }

        public FormValidation doCheckSecretKey(@QueryParameter("userName") final String userName,
                                               @QueryParameter("password") final String password) {
            if (StringUtils.isBlank(userName) && StringUtils.isBlank(password)) {
                return FormValidation.ok();
            }
            return FormValidation.ok();
        }

    }
}
