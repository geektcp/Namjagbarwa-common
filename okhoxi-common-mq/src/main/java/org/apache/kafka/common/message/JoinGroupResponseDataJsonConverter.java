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
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.JoinGroupResponseData.*;

public class JoinGroupResponseDataJsonConverter {
    public static JoinGroupResponseData read(JsonNode _node, short _version) {
        JoinGroupResponseData _object = new JoinGroupResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            if (_version >= 2) {
                throw new RuntimeException("JoinGroupResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
            } else {
                _object.throttleTimeMs = 0;
            }
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "JoinGroupResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("JoinGroupResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "JoinGroupResponseData");
        }
        JsonNode _generationIdNode = _node.get("generationId");
        if (_generationIdNode == null) {
            throw new RuntimeException("JoinGroupResponseData: unable to locate field 'generationId', which is mandatory in version " + _version);
        } else {
            _object.generationId = MessageUtil.jsonNodeToInt(_generationIdNode, "JoinGroupResponseData");
        }
        JsonNode _protocolTypeNode = _node.get("protocolType");
        if (_protocolTypeNode == null) {
            if (_version >= 7) {
                throw new RuntimeException("JoinGroupResponseData: unable to locate field 'protocolType', which is mandatory in version " + _version);
            } else {
                _object.protocolType = null;
            }
        } else {
            if (_protocolTypeNode.isNull()) {
                _object.protocolType = null;
            } else {
                if (!_protocolTypeNode.isTextual()) {
                    throw new RuntimeException("JoinGroupResponseData expected a string type, but got " + _node.getNodeType());
                }
                _object.protocolType = _protocolTypeNode.asText();
            }
        }
        JsonNode _protocolNameNode = _node.get("protocolName");
        if (_protocolNameNode == null) {
            throw new RuntimeException("JoinGroupResponseData: unable to locate field 'protocolName', which is mandatory in version " + _version);
        } else {
            if (_protocolNameNode.isNull()) {
                _object.protocolName = null;
            } else {
                if (!_protocolNameNode.isTextual()) {
                    throw new RuntimeException("JoinGroupResponseData expected a string type, but got " + _node.getNodeType());
                }
                _object.protocolName = _protocolNameNode.asText();
            }
        }
        JsonNode _leaderNode = _node.get("leader");
        if (_leaderNode == null) {
            throw new RuntimeException("JoinGroupResponseData: unable to locate field 'leader', which is mandatory in version " + _version);
        } else {
            if (!_leaderNode.isTextual()) {
                throw new RuntimeException("JoinGroupResponseData expected a string type, but got " + _node.getNodeType());
            }
            _object.leader = _leaderNode.asText();
        }
        JsonNode _memberIdNode = _node.get("memberId");
        if (_memberIdNode == null) {
            throw new RuntimeException("JoinGroupResponseData: unable to locate field 'memberId', which is mandatory in version " + _version);
        } else {
            if (!_memberIdNode.isTextual()) {
                throw new RuntimeException("JoinGroupResponseData expected a string type, but got " + _node.getNodeType());
            }
            _object.memberId = _memberIdNode.asText();
        }
        JsonNode _membersNode = _node.get("members");
        if (_membersNode == null) {
            throw new RuntimeException("JoinGroupResponseData: unable to locate field 'members', which is mandatory in version " + _version);
        } else {
            if (!_membersNode.isArray()) {
                throw new RuntimeException("JoinGroupResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<JoinGroupResponseMember> _collection = new ArrayList<JoinGroupResponseMember>(_membersNode.size());
            _object.members = _collection;
            for (JsonNode _element : _membersNode) {
                _collection.add(JoinGroupResponseMemberJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(JoinGroupResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 2) {
            _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        }
        _node.set("errorCode", new ShortNode(_object.errorCode));
        _node.set("generationId", new IntNode(_object.generationId));
        if (_version >= 7) {
            if (_object.protocolType == null) {
                _node.set("protocolType", NullNode.instance);
            } else {
                _node.set("protocolType", new TextNode(_object.protocolType));
            }
        }
        if (_object.protocolName == null) {
            _node.set("protocolName", NullNode.instance);
        } else {
            _node.set("protocolName", new TextNode(_object.protocolName));
        }
        _node.set("leader", new TextNode(_object.leader));
        _node.set("memberId", new TextNode(_object.memberId));
        ArrayNode _membersArray = new ArrayNode(JsonNodeFactory.instance);
        for (JoinGroupResponseMember _element : _object.members) {
            _membersArray.add(JoinGroupResponseMemberJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("members", _membersArray);
        return _node;
    }
    public static JsonNode write(JoinGroupResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class JoinGroupResponseMemberJsonConverter {
        public static JoinGroupResponseMember read(JsonNode _node, short _version) {
            JoinGroupResponseMember _object = new JoinGroupResponseMember();
            JsonNode _memberIdNode = _node.get("memberId");
            if (_memberIdNode == null) {
                throw new RuntimeException("JoinGroupResponseMember: unable to locate field 'memberId', which is mandatory in version " + _version);
            } else {
                if (!_memberIdNode.isTextual()) {
                    throw new RuntimeException("JoinGroupResponseMember expected a string type, but got " + _node.getNodeType());
                }
                _object.memberId = _memberIdNode.asText();
            }
            JsonNode _groupInstanceIdNode = _node.get("groupInstanceId");
            if (_groupInstanceIdNode == null) {
                if (_version >= 5) {
                    throw new RuntimeException("JoinGroupResponseMember: unable to locate field 'groupInstanceId', which is mandatory in version " + _version);
                } else {
                    _object.groupInstanceId = null;
                }
            } else {
                if (_groupInstanceIdNode.isNull()) {
                    _object.groupInstanceId = null;
                } else {
                    if (!_groupInstanceIdNode.isTextual()) {
                        throw new RuntimeException("JoinGroupResponseMember expected a string type, but got " + _node.getNodeType());
                    }
                    _object.groupInstanceId = _groupInstanceIdNode.asText();
                }
            }
            JsonNode _metadataNode = _node.get("metadata");
            if (_metadataNode == null) {
                throw new RuntimeException("JoinGroupResponseMember: unable to locate field 'metadata', which is mandatory in version " + _version);
            } else {
                _object.metadata = MessageUtil.jsonNodeToBinary(_metadataNode, "JoinGroupResponseMember");
            }
            return _object;
        }
        public static JsonNode write(JoinGroupResponseMember _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
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
            _node.set("metadata", new BinaryNode(Arrays.copyOf(_object.metadata, _object.metadata.length)));
            return _node;
        }
        public static JsonNode write(JoinGroupResponseMember _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
