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

import static org.apache.kafka.common.message.DescribeGroupsResponseData.*;

public class DescribeGroupsResponseDataJsonConverter {
    public static DescribeGroupsResponseData read(JsonNode _node, short _version) {
        DescribeGroupsResponseData _object = new DescribeGroupsResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("DescribeGroupsResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
            } else {
                _object.throttleTimeMs = 0;
            }
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "DescribeGroupsResponseData");
        }
        JsonNode _groupsNode = _node.get("groups");
        if (_groupsNode == null) {
            throw new RuntimeException("DescribeGroupsResponseData: unable to locate field 'groups', which is mandatory in version " + _version);
        } else {
            if (!_groupsNode.isArray()) {
                throw new RuntimeException("DescribeGroupsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<DescribedGroup> _collection = new ArrayList<DescribedGroup>(_groupsNode.size());
            _object.groups = _collection;
            for (JsonNode _element : _groupsNode) {
                _collection.add(DescribedGroupJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(DescribeGroupsResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 1) {
            _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        }
        ArrayNode _groupsArray = new ArrayNode(JsonNodeFactory.instance);
        for (DescribedGroup _element : _object.groups) {
            _groupsArray.add(DescribedGroupJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("groups", _groupsArray);
        return _node;
    }
    public static JsonNode write(DescribeGroupsResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DescribedGroupJsonConverter {
        public static DescribedGroup read(JsonNode _node, short _version) {
            DescribedGroup _object = new DescribedGroup();
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("DescribedGroup: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "DescribedGroup");
            }
            JsonNode _groupIdNode = _node.get("groupId");
            if (_groupIdNode == null) {
                throw new RuntimeException("DescribedGroup: unable to locate field 'groupId', which is mandatory in version " + _version);
            } else {
                if (!_groupIdNode.isTextual()) {
                    throw new RuntimeException("DescribedGroup expected a string type, but got " + _node.getNodeType());
                }
                _object.groupId = _groupIdNode.asText();
            }
            JsonNode _groupStateNode = _node.get("groupState");
            if (_groupStateNode == null) {
                throw new RuntimeException("DescribedGroup: unable to locate field 'groupState', which is mandatory in version " + _version);
            } else {
                if (!_groupStateNode.isTextual()) {
                    throw new RuntimeException("DescribedGroup expected a string type, but got " + _node.getNodeType());
                }
                _object.groupState = _groupStateNode.asText();
            }
            JsonNode _protocolTypeNode = _node.get("protocolType");
            if (_protocolTypeNode == null) {
                throw new RuntimeException("DescribedGroup: unable to locate field 'protocolType', which is mandatory in version " + _version);
            } else {
                if (!_protocolTypeNode.isTextual()) {
                    throw new RuntimeException("DescribedGroup expected a string type, but got " + _node.getNodeType());
                }
                _object.protocolType = _protocolTypeNode.asText();
            }
            JsonNode _protocolDataNode = _node.get("protocolData");
            if (_protocolDataNode == null) {
                throw new RuntimeException("DescribedGroup: unable to locate field 'protocolData', which is mandatory in version " + _version);
            } else {
                if (!_protocolDataNode.isTextual()) {
                    throw new RuntimeException("DescribedGroup expected a string type, but got " + _node.getNodeType());
                }
                _object.protocolData = _protocolDataNode.asText();
            }
            JsonNode _membersNode = _node.get("members");
            if (_membersNode == null) {
                throw new RuntimeException("DescribedGroup: unable to locate field 'members', which is mandatory in version " + _version);
            } else {
                if (!_membersNode.isArray()) {
                    throw new RuntimeException("DescribedGroup expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<DescribedGroupMember> _collection = new ArrayList<DescribedGroupMember>(_membersNode.size());
                _object.members = _collection;
                for (JsonNode _element : _membersNode) {
                    _collection.add(DescribedGroupMemberJsonConverter.read(_element, _version));
                }
            }
            JsonNode _authorizedOperationsNode = _node.get("authorizedOperations");
            if (_authorizedOperationsNode == null) {
                if (_version >= 3) {
                    throw new RuntimeException("DescribedGroup: unable to locate field 'authorizedOperations', which is mandatory in version " + _version);
                } else {
                    _object.authorizedOperations = -2147483648;
                }
            } else {
                _object.authorizedOperations = MessageUtil.jsonNodeToInt(_authorizedOperationsNode, "DescribedGroup");
            }
            return _object;
        }
        public static JsonNode write(DescribedGroup _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("errorCode", new ShortNode(_object.errorCode));
            _node.set("groupId", new TextNode(_object.groupId));
            _node.set("groupState", new TextNode(_object.groupState));
            _node.set("protocolType", new TextNode(_object.protocolType));
            _node.set("protocolData", new TextNode(_object.protocolData));
            ArrayNode _membersArray = new ArrayNode(JsonNodeFactory.instance);
            for (DescribedGroupMember _element : _object.members) {
                _membersArray.add(DescribedGroupMemberJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("members", _membersArray);
            if (_version >= 3) {
                _node.set("authorizedOperations", new IntNode(_object.authorizedOperations));
            } else {
                if (_object.authorizedOperations != -2147483648) {
                    throw new UnsupportedVersionException("Attempted to write a non-default authorizedOperations at version " + _version);
                }
            }
            return _node;
        }
        public static JsonNode write(DescribedGroup _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class DescribedGroupMemberJsonConverter {
        public static DescribedGroupMember read(JsonNode _node, short _version) {
            DescribedGroupMember _object = new DescribedGroupMember();
            JsonNode _memberIdNode = _node.get("memberId");
            if (_memberIdNode == null) {
                throw new RuntimeException("DescribedGroupMember: unable to locate field 'memberId', which is mandatory in version " + _version);
            } else {
                if (!_memberIdNode.isTextual()) {
                    throw new RuntimeException("DescribedGroupMember expected a string type, but got " + _node.getNodeType());
                }
                _object.memberId = _memberIdNode.asText();
            }
            JsonNode _groupInstanceIdNode = _node.get("groupInstanceId");
            if (_groupInstanceIdNode == null) {
                if (_version >= 4) {
                    throw new RuntimeException("DescribedGroupMember: unable to locate field 'groupInstanceId', which is mandatory in version " + _version);
                } else {
                    _object.groupInstanceId = null;
                }
            } else {
                if (_groupInstanceIdNode.isNull()) {
                    _object.groupInstanceId = null;
                } else {
                    if (!_groupInstanceIdNode.isTextual()) {
                        throw new RuntimeException("DescribedGroupMember expected a string type, but got " + _node.getNodeType());
                    }
                    _object.groupInstanceId = _groupInstanceIdNode.asText();
                }
            }
            JsonNode _clientIdNode = _node.get("clientId");
            if (_clientIdNode == null) {
                throw new RuntimeException("DescribedGroupMember: unable to locate field 'clientId', which is mandatory in version " + _version);
            } else {
                if (!_clientIdNode.isTextual()) {
                    throw new RuntimeException("DescribedGroupMember expected a string type, but got " + _node.getNodeType());
                }
                _object.clientId = _clientIdNode.asText();
            }
            JsonNode _clientHostNode = _node.get("clientHost");
            if (_clientHostNode == null) {
                throw new RuntimeException("DescribedGroupMember: unable to locate field 'clientHost', which is mandatory in version " + _version);
            } else {
                if (!_clientHostNode.isTextual()) {
                    throw new RuntimeException("DescribedGroupMember expected a string type, but got " + _node.getNodeType());
                }
                _object.clientHost = _clientHostNode.asText();
            }
            JsonNode _memberMetadataNode = _node.get("memberMetadata");
            if (_memberMetadataNode == null) {
                throw new RuntimeException("DescribedGroupMember: unable to locate field 'memberMetadata', which is mandatory in version " + _version);
            } else {
                _object.memberMetadata = MessageUtil.jsonNodeToBinary(_memberMetadataNode, "DescribedGroupMember");
            }
            JsonNode _memberAssignmentNode = _node.get("memberAssignment");
            if (_memberAssignmentNode == null) {
                throw new RuntimeException("DescribedGroupMember: unable to locate field 'memberAssignment', which is mandatory in version " + _version);
            } else {
                _object.memberAssignment = MessageUtil.jsonNodeToBinary(_memberAssignmentNode, "DescribedGroupMember");
            }
            return _object;
        }
        public static JsonNode write(DescribedGroupMember _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("memberId", new TextNode(_object.memberId));
            if (_version >= 4) {
                if (_object.groupInstanceId == null) {
                    _node.set("groupInstanceId", NullNode.instance);
                } else {
                    _node.set("groupInstanceId", new TextNode(_object.groupInstanceId));
                }
            }
            _node.set("clientId", new TextNode(_object.clientId));
            _node.set("clientHost", new TextNode(_object.clientHost));
            _node.set("memberMetadata", new BinaryNode(Arrays.copyOf(_object.memberMetadata, _object.memberMetadata.length)));
            _node.set("memberAssignment", new BinaryNode(Arrays.copyOf(_object.memberAssignment, _object.memberAssignment.length)));
            return _node;
        }
        public static JsonNode write(DescribedGroupMember _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
