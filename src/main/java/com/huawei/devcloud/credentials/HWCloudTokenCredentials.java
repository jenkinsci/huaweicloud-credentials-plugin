package com.huawei.devcloud.credentials;

import com.cloudbees.plugins.credentials.CredentialsNameProvider;
import com.cloudbees.plugins.credentials.NameWith;
import com.cloudbees.plugins.credentials.common.StandardCredentials;
import hudson.Util;
import hudson.util.Secret;

@NameWith(HWCloudTokenCredentials.NameProvider.class)
public interface HWCloudTokenCredentials extends StandardCredentials {
    Secret getToken();
    class NameProvider extends CredentialsNameProvider<HWCloudCredentials> {
        @Override
        public String getName(HWCloudCredentials c) {
            String description = Util.fixEmptyAndTrim(c.getDescription());
            return Messages.devcloud_iam_Token_name() + (description != null ? " (" + description + ")" : "");
        }
    }
}
