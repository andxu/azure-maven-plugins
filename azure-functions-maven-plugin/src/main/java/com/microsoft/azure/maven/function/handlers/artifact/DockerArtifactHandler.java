/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.maven.function.handlers.artifact;

import com.microsoft.azure.maven.deploytarget.DeployTarget;
import com.microsoft.azure.maven.handlers.artifact.ArtifactHandlerBase;

public class DockerArtifactHandler extends ArtifactHandlerBase {

    public static class Builder extends ArtifactHandlerBase.Builder<Builder> {

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public ArtifactHandlerBase build() {
            return new DockerArtifactHandler(self());
        }
    }

    protected DockerArtifactHandler(Builder builder) {
        super(builder);
    }

    @Override
    public void publish(DeployTarget deployTarget) {
        log.info("Skip deployment for docker functions");
        deployTarget.getApp().restart();
    }
}