package com.deploygate.gradle.plugins

import com.deploygate.gradle.plugins.entities.DeployTarget
import org.junit.Test

class DeployTargetTest {
    @Test
    public void apkTest() {
        String name            = "name"
        File file              = null
        String message         = "test message"
        String distributionKey = "test distribution key"
        String releaseNote     = "test release note"
        String visibility      = "public"

        DeployTarget apk = new DeployTarget(name: name, sourceFile: file, message: message, distributionKey: distributionKey, releaseNote: releaseNote, visibility: visibility)
        checkDeployTarget(apk, name, file, message, distributionKey, releaseNote, visibility)
        checkParams(apk, message, distributionKey, releaseNote, visibility)
    }

    @Test
    public void argsNullTest() {
        String name            = "name"
        File file              = null
        String message         = ""
        String distributionKey = null
        String releaseNote     = null
        String visibility      = "private"

        DeployTarget apk = new DeployTarget(name)
        apk.sourceFile = file
        checkDeployTarget(apk, name, file, message, distributionKey, releaseNote, visibility)
        checkParams(apk, message, distributionKey, releaseNote, visibility)
    }

    public void checkDeployTarget(DeployTarget apk, String name, File file, String message, String distributionKey, String releaseNote, String visibility) {
        assert apk instanceof DeployTarget
        assert apk.name == name
        assert apk.sourceFile == file
        assert apk.message == message
        assert apk.distributionKey == distributionKey
        assert apk.releaseNote == releaseNote
        assert apk.visibility == visibility
    }

    public void checkParams(DeployTarget apk, String message, String distributionKey, String releaseNote, String visibility) {
        HashMap<String, String> params = apk.toParams()
        assert params["message"] == message
        assert params["distribution_key"] == distributionKey
        assert params["release_note"] == releaseNote
        assert params["visibility"] == visibility
    }
}
