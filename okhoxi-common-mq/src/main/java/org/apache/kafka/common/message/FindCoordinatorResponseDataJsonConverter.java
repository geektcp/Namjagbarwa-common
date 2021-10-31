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

import static org.apache.kafka.common.message.FindCoordinatorResponseData.*;

public class FindCoordinatorResponseDataJsonConverter {
    public static FindCoordinatorResponseData read(JsonNode _node, short _version) {
        FindCoordinatorResponseData _object = new FindCoordinatorResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("FindCoordinatorResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
            } else {
                _object.throttleTimeMs = 0;
            }
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "FindCoordinatorResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("FindCoordinatorResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "FindCoordinatorResponseData");
        }
        JsonNode _errorMessageNode = _node.get("errorMessage");
        if (_errorMessageNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("FindCoordinatorResponseData: unable to locate field 'errorMessage', which is mandatory in version " + _version);
            } else {
                _object.errorMessage = "";
            }
        } else {
            if (_errorMessageNode.isNull()) {
                _object.errorMessage = null;
            } else {
                if (!_errorMessageNode.isTextual()) {
                    throw new RuntimeException("FindCoordinatorResponseData expected a string type, but got " + _node.getNodeType());
                }
                _object.errorMessage = _errorMessageNode.asText();
            }
        }
        JsonNode _nodeIdNode = _node.get("nodeId");
        if (_nodeIdNode == null) {
            throw new RuntimeException("FindCoordinatorResponseData: unable to locate field 'nodeId', which is mandatory in version " + _version);
        } else {
            _object.nodeId = MessageUtil.jsonNodeToInt(_nodeIdNode, "FindCoordinatorResponseData");
        }
        JsonNode _hostNode = _node.get("host");
        if (_hostNode == null) {
            throw new RuntimeException("FindCoordinatorResponseData: unable to locate field 'host', which is mandatory in version " + _version);
        } else {
            if (!_hostNode.isTextual()) {
                throw new RuntimeException("FindCoordinatorResponseData expected a string type, but got " + _node.getNodeType());
            }
            _object.host = _hostNode.asText();
        }
        JsonNode _portNode = _node.get("port");
        if (_portNode == null) {
            throw new RuntimeException("FindCoordinatorResponseData: unable to locate field 'port', which is mandatory in version " + _version);
        } else {
            _object.port = MessageUtil.jsonNodeToInt(_portNode, "FindCoordinatorResponseData");
        }
        return _object;
    }
    public static JsonNode write(FindCoordinatorResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 1) {
            _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        }
        _node.set("errorCode", new ShortNode(_object.errorCode));
        if (_version >= 1) {
            if (_object.errorMessage == null) {
                _node.set("errorMessage", NullNode.instance);
            } else {
                _node.set("errorMessage", new TextNode(_object.errorMessage));
            }
        }
        _node.set("nodeId", new IntNode(_object.nodeId));
        _node.set("host", new TextNode(_object.host));
        _node.set("port", new IntNode(_object.port));
        return _node;
    }
    public static JsonNode write(FindCoordinatorResponseData _object, short _version) {
        return write(_object, _version, true);
    }
}
