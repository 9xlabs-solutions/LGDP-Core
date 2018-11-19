package com.ninexlabs.lgdp.usermodule;

public class Version {
    private String module = "UserModule";

    private String versionText = "0.1";

    private double versionCode = 0.1;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getVersionText() {
        return versionText;
    }

    public void setVersionText(String versionText) {
        this.versionText = versionText;
    }

    public double getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }
}
