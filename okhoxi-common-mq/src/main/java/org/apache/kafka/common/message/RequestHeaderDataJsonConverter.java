/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.message;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.RequestHeaderData.*;

public class RequestHeaderDataJsonConverter {
    public static RequestHeaderData read(JsonNode _node, short _version) {
        RequestHeaderData _object = new RequestHeaderData();
        JsonNode _requestApiKeyNode = _node.get("requestApiKey");
        if (_requestApiKeyNode == null) {
            throw new RuntimeException("RequestHeaderData: unable to locate field 'requestApiKey', which is mandatory in version " + _version);
        } else {
            _object.requestApiKey = MessageUtil.jsonNodeToShort(_requestApiKeyNode, "RequestHeaderData");
        }
        JsonNode _requestApiVersionNode = _node.get("requestApiVersion");
        if (_requestApiVersionNode == null) {
            throw new RuntimeException("RequestHeaderData: unable to locate field 'requestApiVersion', which is mandatory in version " + _version);
        } else {
            _object.requestApiVersion = MessageUtil.jsonNodeToShort(_requestApiVersionNode, "RequestHeaderData");
        }
        JsonNode _correlationIdNode = _node.get("correlationId");
        if (_correlationIdNode == null) {
            throw new RuntimeException("RequestHeaderData: unable to locate field 'correlationId', which is mandatory in version " + _version);
        } else {
            _object.correlationId = MessageUtil.jsonNodeToInt(_correlationIdNode, "RequestHeaderData");
        }
        JsonNode _clientIdNode = _node.get("clientId");
        if (_clientIdNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("RequestHeaderData: unable to locate field 'clientId', which is mandatory in version " + _version);
            } else {
                _object.clientId = "";
            }
        } else {
            if (_clientIdNode.isNull()) {
                _object.clientId = null;
            } else {
                if (!_clientIdNode.isTextual()) {
                    throw new RuntimeException("RequestHeaderData expected a string type, but got " + _node.getNodeType());
                }
                _object.clientId = _clientIdNode.asText();
            }
        }
        return _object;
    }
    public static JsonNode write(RequestHeaderData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("requestApiKey", new ShortNode(_object.requestApiKey));
        _node.set("requestApiVersion", new ShortNode(_object.requestApiVersion));
        _node.set("correlationId", new IntNode(_object.correlationId));
        if (_version >= 1) {
            if (_object.clientId == null) {
                _node.set("clientId", NullNode.instance);
            } else {
                _node.set("clientId", new TextNode(_object.clientId));
            }
        }
        return _node;
    }
    public static JsonNode write(RequestHeaderData _object, short _version) {
        return write(_object, _version, true);
    }
}
