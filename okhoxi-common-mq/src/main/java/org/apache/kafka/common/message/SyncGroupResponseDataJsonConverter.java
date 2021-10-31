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
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.Arrays;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.SyncGroupResponseData.*;

public class SyncGroupResponseDataJsonConverter {
    public static SyncGroupResponseData read(JsonNode _node, short _version) {
        SyncGroupResponseData _object = new SyncGroupResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("SyncGroupResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
            } else {
                _object.throttleTimeMs = 0;
            }
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "SyncGroupResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("SyncGroupResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "SyncGroupResponseData");
        }
        JsonNode _protocolTypeNode = _node.get("protocolType");
        if (_protocolTypeNode == null) {
            if (_version >= 5) {
                throw new RuntimeException("SyncGroupResponseData: unable to locate field 'protocolType', which is mandatory in version " + _version);
            } else {
                _object.protocolType = null;
            }
        } else {
            if (_protocolTypeNode.isNull()) {
                _object.protocolType = null;
            } else {
                if (!_protocolTypeNode.isTextual()) {
                    throw new RuntimeException("SyncGroupResponseData expected a string type, but got " + _node.getNodeType());
                }
                _object.protocolType = _protocolTypeNode.asText();
            }
        }
        JsonNode _protocolNameNode = _node.get("protocolName");
        if (_protocolNameNode == null) {
            if (_version >= 5) {
                throw new RuntimeException("SyncGroupResponseData: unable to locate field 'protocolName', which is mandatory in version " + _version);
            } else {
                _object.protocolName = null;
            }
        } else {
            if (_protocolNameNode.isNull()) {
                _object.protocolName = null;
            } else {
                if (!_protocolNameNode.isTextual()) {
                    throw new RuntimeException("SyncGroupResponseData expected a string type, but got " + _node.getNodeType());
                }
                _object.protocolName = _protocolNameNode.asText();
            }
        }
        JsonNode _assignmentNode = _node.get("assignment");
        if (_assignmentNode == null) {
            throw new RuntimeException("SyncGroupResponseData: unable to locate field 'assignment', which is mandatory in version " + _version);
        } else {
            _object.assignment = MessageUtil.jsonNodeToBinary(_assignmentNode, "SyncGroupResponseData");
        }
        return _object;
    }
    public static JsonNode write(SyncGroupResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 1) {
            _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        }
        _node.set("errorCode", new ShortNode(_object.errorCode));
        if (_version >= 5) {
            if (_object.protocolType == null) {
                _node.set("protocolType", NullNode.instance);
            } else {
                _node.set("protocolType", new TextNode(_object.protocolType));
            }
        }
        if (_version >= 5) {
            if (_object.protocolName == null) {
                _node.set("protocolName", NullNode.instance);
            } else {
                _node.set("protocolName", new TextNode(_object.protocolName));
            }
        }
        _node.set("assignment", new BinaryNode(Arrays.copyOf(_object.assignment, _object.assignment.length)));
        return _node;
    }
    public static JsonNode write(SyncGroupResponseData _object, short _version) {
        return write(_object, _version, true);
    }
}
