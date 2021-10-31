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
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.BrokerHeartbeatResponseData.*;

public class BrokerHeartbeatResponseDataJsonConverter {
    public static BrokerHeartbeatResponseData read(JsonNode _node, short _version) {
        BrokerHeartbeatResponseData _object = new BrokerHeartbeatResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("BrokerHeartbeatResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "BrokerHeartbeatResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("BrokerHeartbeatResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "BrokerHeartbeatResponseData");
        }
        JsonNode _isCaughtUpNode = _node.get("isCaughtUp");
        if (_isCaughtUpNode == null) {
            throw new RuntimeException("BrokerHeartbeatResponseData: unable to locate field 'isCaughtUp', which is mandatory in version " + _version);
        } else {
            if (!_isCaughtUpNode.isBoolean()) {
                throw new RuntimeException("BrokerHeartbeatResponseData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.isCaughtUp = _isCaughtUpNode.asBoolean();
        }
        JsonNode _isFencedNode = _node.get("isFenced");
        if (_isFencedNode == null) {
            throw new RuntimeException("BrokerHeartbeatResponseData: unable to locate field 'isFenced', which is mandatory in version " + _version);
        } else {
            if (!_isFencedNode.isBoolean()) {
                throw new RuntimeException("BrokerHeartbeatResponseData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.isFenced = _isFencedNode.asBoolean();
        }
        JsonNode _shouldShutDownNode = _node.get("shouldShutDown");
        if (_shouldShutDownNode == null) {
            throw new RuntimeException("BrokerHeartbeatResponseData: unable to locate field 'shouldShutDown', which is mandatory in version " + _version);
        } else {
            if (!_shouldShutDownNode.isBoolean()) {
                throw new RuntimeException("BrokerHeartbeatResponseData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.shouldShutDown = _shouldShutDownNode.asBoolean();
        }
        return _object;
    }
    public static JsonNode write(BrokerHeartbeatResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        _node.set("errorCode", new ShortNode(_object.errorCode));
        _node.set("isCaughtUp", BooleanNode.valueOf(_object.isCaughtUp));
        _node.set("isFenced", BooleanNode.valueOf(_object.isFenced));
        _node.set("shouldShutDown", BooleanNode.valueOf(_object.shouldShutDown));
        return _node;
    }
    public static JsonNode write(BrokerHeartbeatResponseData _object, short _version) {
        return write(_object, _version, true);
    }
}
