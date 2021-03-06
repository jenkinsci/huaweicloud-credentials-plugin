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

import java.util.logging.Logger;

public class HWCloudAccesskeyCredentials extends BaseStandardCredentials implements HWCloudCredentials,AccessKeyCredentials{

    private static final long serialVersionUID = -3167989896315282034L;

    private static final Logger LOGGER = Logger.getLogger(HWCloudAccesskeyCredentials.class.getName());

    private final Secret accessKey;

    private final Secret secretKey;

    @DataBoundConstructor
    public HWCloudAccesskeyCredentials(@CheckForNull CredentialsScope scope, @CheckForNull String id,
                                       @CheckForNull String accessKey, @CheckForNull String secretKey, @CheckForNull String description
                              ) {
        super(scope, id, description);
        this.accessKey = Secret.fromString(secretKey);
        this.secretKey = Secret.fromString(secretKey);
    }

    @Override
    public Secret getAccessKey() {
        return accessKey;
    }

    @Override
    public Secret getSecretKey() {
        return secretKey;
    }

    public void refresh() {
        // no-op
    }

    public String getDisplayName() {
        return getId() ;
    }

    @Override
    public String getMessage() {
        return Messages.devcloud_credentials_name();
    }


    @Extension
    public static class DescriptorImpl extends CredentialsDescriptor {

        @Override
        public String getDisplayName() {
            return Messages.devcloud_credentials_name();
        }

        public FormValidation doCheckSecretKey(@QueryParameter("accessKey") final String accessKey,
                                               @QueryParameter final String secretKey) {
            if (StringUtils.isBlank(accessKey) && StringUtils.isBlank(secretKey)) {
                return FormValidation.ok();
            }
            return FormValidation.ok();
        }

    }
}
