package com.huawei.devcloud.credentials;

import hudson.util.Secret;

public interface BasicCredentials {
    Secret getPassword();

    Secret getUserName();

}
