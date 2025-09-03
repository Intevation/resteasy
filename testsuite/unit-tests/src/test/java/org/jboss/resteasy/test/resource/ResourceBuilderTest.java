/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2025 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.resteasy.test.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jboss.resteasy.spi.metadata.ResourceBuilder;
import org.jboss.resteasy.spi.metadata.ResourceClass;
import org.jboss.resteasy.test.resource.resource.TestInheritResourceMethod;
import org.jboss.resteasy.test.resource.resource.TestInheritResourceMethodFromPrivateClass;
import org.jboss.resteasy.test.resource.resource.TestRootResource;
import org.junit.jupiter.api.Test;

/**
 * @tpSubChapter Resource tests
 * @tpChapter Unit tests
 * @tpTestCaseDetails Tests building resource classes from annotations.
 * @tpSince RESTEasy 7.0.0
 */
public class ResourceBuilderTest {

    /**
     * @tpTestDetails Test resource method declared in resource class.
     * @tpSince RESTEasy 7.0.0
     */
    @Test
    public void methodInResourceClass() {
        ResourceClass resource = new ResourceBuilder()
                .getRootResourceFromAnnotations(TestRootResource.class);
        assertEquals(1, resource.getResourceMethods().length);
    }

    /**
     * @tpTestDetails Test resource method declared in public parent class.
     * @tpSince RESTEasy 7.0.0
     */
    @Test
    public void inheritedMethod() {
        ResourceClass resource = new ResourceBuilder()
                .getRootResourceFromAnnotations(TestInheritResourceMethod.class);
        assertEquals(1, resource.getResourceMethods().length);
    }

    /**
     * @tpTestDetails Test resource method declared in package-private parent class.
     * @tpSince RESTEasy 7.0.0
     */
    // TODO: Fails. RESTEASY-3621
    @Test
    public void inheritedMethodFromPrivateClass() {
        ResourceClass resource = new ResourceBuilder()
                .getRootResourceFromAnnotations(TestInheritResourceMethodFromPrivateClass.class);
        assertEquals(1, resource.getResourceMethods().length);
    }
}
