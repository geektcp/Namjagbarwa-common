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
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.HeartbeatRequestData.*;

public class HeartbeatRequestDataJsonConverter {
    public static HeartbeatRequestData read(JsonNode _node, short _version) {
        HeartbeatRequestData _object = new HeartbeatRequestData();
        JsonNode _groupIdNode = _node.get("groupId");
        if (_groupIdNode == null) {
            throw new RuntimeException("HeartbeatRequestData: unable to locate field 'groupId', which is mandatory in version " + _version);
        } else {
            if (!_groupIdNode.isTextual()) {
                throw new RuntimeException("HeartbeatRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.groupId = _groupIdNode.asText();
        }
        JsonNode _generationIdNode = _node.get("generationId");
        if (_generationIdNode == null) {
            throw new RuntimeException("HeartbeatRequestData: unable to locate field 'generationId', which is mandatory in version " + _version);
        } else {
            _object.generationId = MessageUtil.jsonNodeToInt(_generationIdNode, "HeartbeatRequestData");
        }
        JsonNode _memberIdNode = _node.get("memberId");
        if (_memberIdNode == null) {
            throw new RuntimeException("HeartbeatRequestData: unable to locate field 'memberId', which is mandatory in version " + _version);
        } else {
            if (!_memberIdNode.isTextual()) {
                throw new RuntimeException("HeartbeatRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.memberId = _memberIdNode.asText();
        }
        JsonNode _groupInstanceIdNode = _node.get("groupInstanceId");
        if (_groupInstanceIdNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("HeartbeatRequestData: unable to locate field 'groupInstanceId', which is mandatory in version " + _version);
            } else {
                _object.groupInstanceId = null;
            }
        } else {
            if (_groupInstanceIdNode.isNull()) {
                _object.groupInstanceId = null;
            } else {
                if (!_groupInstanceIdNode.isTextual()) {
                    throw new RuntimeException("HeartbeatRequestData expected a string type, but got " + _node.getNodeType());
                }
                _object.groupInstanceId = _groupInstanceIdNode.asText();
            }
        }
        return _object;
    }
    public static JsonNode write(HeartbeatRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("groupId", new TextNode(_object.groupId));
        _node.set("generationId", new IntNode(_object.generationId));
        _node.set("memberId", new TextNode(_object.memberId));
        if (_version >= 3) {
            if (_object.groupInstanceId == null) {
                _node.set("groupInstanceId", NullNode.instance);
            } else {
                _node.set("groupInstanceId", new TextNode(_object.groupInstanceId));
            }
        } else {
            if (_object.groupInstanceId != null) {
                throw new UnsupportedVersionException("Attempted to write a non-default groupInstanceId at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(HeartbeatRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
