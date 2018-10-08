package com.huawei.devcloud.credentials;

import com.cloudbees.plugins.credentials.CredentialsNameProvider;
import com.cloudbees.plugins.credentials.NameWith;
import com.cloudbees.plugins.credentials.common.StandardCredentials;
import hudson.Util;

@NameWith(HWCloudCredentials.NameProvider.class)
public interface HWCloudCredentials extends StandardCredentials {

    public String getMessage();

    class NameProvider extends CredentialsNameProvider<HWCloudCredentials> {
        @Override
        public String getName(HWCloudCredentials c) {
            String description = Util.fixEmptyAndTrim(c.getDescription());
            return c.getMessage() + (description != null ? " (" + description + ")" : "");
        }
    }
}
