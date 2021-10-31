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
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.Arrays;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.JoinGroupRequestData.*;

public class JoinGroupRequestDataJsonConverter {
    public static JoinGroupRequestData read(JsonNode _node, short _version) {
        JoinGroupRequestData _object = new JoinGroupRequestData();
        JsonNode _groupIdNode = _node.get("groupId");
        if (_groupIdNode == null) {
            throw new RuntimeException("JoinGroupRequestData: unable to locate field 'groupId', which is mandatory in version " + _version);
        } else {
            if (!_groupIdNode.isTextual()) {
                throw new RuntimeException("JoinGroupRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.groupId = _groupIdNode.asText();
        }
        JsonNode _sessionTimeoutMsNode = _node.get("sessionTimeoutMs");
        if (_sessionTimeoutMsNode == null) {
            throw new RuntimeException("JoinGroupRequestData: unable to locate field 'sessionTimeoutMs', which is mandatory in version " + _version);
        } else {
            _object.sessionTimeoutMs = MessageUtil.jsonNodeToInt(_sessionTimeoutMsNode, "JoinGroupRequestData");
        }
        JsonNode _rebalanceTimeoutMsNode = _node.get("rebalanceTimeoutMs");
        if (_rebalanceTimeoutMsNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("JoinGroupRequestData: unable to locate field 'rebalanceTimeoutMs', which is mandatory in version " + _version);
            } else {
                _object.rebalanceTimeoutMs = -1;
            }
        } else {
            _object.rebalanceTimeoutMs = MessageUtil.jsonNodeToInt(_rebalanceTimeoutMsNode, "JoinGroupRequestData");
        }
        JsonNode _memberIdNode = _node.get("memberId");
        if (_memberIdNode == null) {
            throw new RuntimeException("JoinGroupRequestData: unable to locate field 'memberId', which is mandatory in version " + _version);
        } else {
            if (!_memberIdNode.isTextual()) {
                throw new RuntimeException("JoinGroupRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.memberId = _memberIdNode.asText();
        }
        JsonNode _groupInstanceIdNode = _node.get("groupInstanceId");
        if (_groupInstanceIdNode == null) {
            if (_version >= 5) {
                throw new RuntimeException("JoinGroupRequestData: unable to locate field 'groupInstanceId', which is mandatory in version " + _version);
            } else {
                _object.groupInstanceId = null;
            }
        } else {
            if (_groupInstanceIdNode.isNull()) {
                _object.groupInstanceId = null;
            } else {
                if (!_groupInstanceIdNode.isTextual()) {
                    throw new RuntimeException("JoinGroupRequestData expected a string type, but got " + _node.getNodeType());
                }
                _object.groupInstanceId = _groupInstanceIdNode.asText();
            }
        }
        JsonNode _protocolTypeNode = _node.get("protocolType");
        if (_protocolTypeNode == null) {
            throw new RuntimeException("JoinGroupRequestData: unable to locate field 'protocolType', which is mandatory in version " + _version);
        } else {
            if (!_protocolTypeNode.isTextual()) {
                throw new RuntimeException("JoinGroupRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.protocolType = _protocolTypeNode.asText();
        }
        JsonNode _protocolsNode = _node.get("protocols");
        if (_protocolsNode == null) {
            throw new RuntimeException("JoinGroupRequestData: unable to locate field 'protocols', which is mandatory in version " + _version);
        } else {
            if (!_protocolsNode.isArray()) {
                throw new RuntimeException("JoinGroupRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            JoinGroupRequestProtocolCollection _collection = new JoinGroupRequestProtocolCollection(_protocolsNode.size());
            _object.protocols = _collection;
            for (JsonNode _element : _protocolsNode) {
                _collection.add(JoinGroupRequestProtocolJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(JoinGroupRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("groupId", new TextNode(_object.groupId));
        _node.set("sessionTimeoutMs", new IntNode(_object.sessionTimeoutMs));
        if (_version >= 1) {
            _node.set("rebalanceTimeoutMs", new IntNode(_object.rebalanceTimeoutMs));
        }
        _node.set("memberId", new TextNode(_object.memberId));
        if (_version >= 5) {
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
        _node.set("protocolType", new TextNode(_object.protocolType));
        ArrayNode _protocolsArray = new ArrayNode(JsonNodeFactory.instance);
        for (JoinGroupRequestProtocol _element : _object.protocols) {
            _protocolsArray.add(JoinGroupRequestProtocolJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("protocols", _protocolsArray);
        return _node;
    }
    public static JsonNode write(JoinGroupRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class JoinGroupRequestProtocolJsonConverter {
        public static JoinGroupRequestProtocol read(JsonNode _node, short _version) {
            JoinGroupRequestProtocol _object = new JoinGroupRequestProtocol();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("JoinGroupRequestProtocol: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("JoinGroupRequestProtocol expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _metadataNode = _node.get("metadata");
            if (_metadataNode == null) {
                throw new RuntimeException("JoinGroupRequestProtocol: unable to locate field 'metadata', which is mandatory in version " + _version);
            } else {
                _object.metadata = MessageUtil.jsonNodeToBinary(_metadataNode, "JoinGroupRequestProtocol");
            }
            return _object;
        }
        public static JsonNode write(JoinGroupRequestProtocol _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            _node.set("metadata", new BinaryNode(Arrays.copyOf(_object.metadata, _object.metadata.length)));
            return _node;
        }
        public static JsonNode write(JoinGroupRequestProtocol _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
