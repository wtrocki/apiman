/*
 * Copyright 2015 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.apiman.test.policies;

import io.apiman.gateway.engine.IApiConnection;
import io.apiman.gateway.engine.IApiConnectionResponse;
import io.apiman.gateway.engine.IApiConnector;
import io.apiman.gateway.engine.async.IAsyncResultHandler;
import io.apiman.gateway.engine.beans.Api;
import io.apiman.gateway.engine.beans.ApiRequest;
import io.apiman.gateway.engine.beans.exceptions.ConnectorException;

/**
 * Creates a connection to the back end API.
 *
 * @author eric.wittmann@redhat.com
 */
public class PolicyTesterConnector implements IApiConnector {

    private final Api api;

    /**
     * Constructor.
     * @param api
     */
    public PolicyTesterConnector(Api api) {
        this.api = api;
    }

    /**
     * @see io.apiman.gateway.engine.IApiConnector#connect(io.apiman.gateway.engine.beans.ApiRequest, io.apiman.gateway.engine.async.IAsyncResultHandler)
     */
    @Override
    public IApiConnection connect(ApiRequest request,
            IAsyncResultHandler<IApiConnectionResponse> handler) throws ConnectorException {
        return new PolicyTesterApiConnection(api, request, handler);
    }

}
