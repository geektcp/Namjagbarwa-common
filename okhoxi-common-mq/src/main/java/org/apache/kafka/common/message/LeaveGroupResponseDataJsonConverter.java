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
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.LeaveGroupResponseData.*;

public class LeaveGroupResponseDataJsonConverter {
    public static LeaveGroupResponseData read(JsonNode _node, short _version) {
        LeaveGroupResponseData _object = new LeaveGroupResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("LeaveGroupResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
            } else {
                _object.throttleTimeMs = 0;
            }
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "LeaveGroupResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("LeaveGroupResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "LeaveGroupResponseData");
        }
        JsonNode _membersNode = _node.get("members");
        if (_membersNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("LeaveGroupResponseData: unable to locate field 'members', which is mandatory in version " + _version);
            } else {
                _object.members = new ArrayList<MemberResponse>(0);
            }
        } else {
            if (!_membersNode.isArray()) {
                throw new RuntimeException("LeaveGroupResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<MemberResponse> _collection = new ArrayList<MemberResponse>(_membersNode.size());
            _object.members = _collection;
            for (JsonNode _element : _membersNode) {
                _collection.add(MemberResponseJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(LeaveGroupResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 1) {
            _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        }
        _node.set("errorCode", new ShortNode(_object.errorCode));
        if (_version >= 3) {
            ArrayNode _membersArray = new ArrayNode(JsonNodeFactory.instance);
            for (MemberResponse _element : _object.members) {
                _membersArray.add(MemberResponseJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("members", _membersArray);
        } else {
            if (!_object.members.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default members at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(LeaveGroupResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class MemberResponseJsonConverter {
        public static MemberResponse read(JsonNode _node, short _version) {
            MemberResponse _object = new MemberResponse();
            if (_version < 3) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of MemberResponse");
            }
            JsonNode _memberIdNode = _node.get("memberId");
            if (_memberIdNode == null) {
                throw new RuntimeException("MemberResponse: unable to locate field 'memberId', which is mandatory in version " + _version);
            } else {
                if (!_memberIdNode.isTextual()) {
                    throw new RuntimeException("MemberResponse expected a string type, but got " + _node.getNodeType());
                }
                _object.memberId = _memberIdNode.asText();
            }
            JsonNode _groupInstanceIdNode = _node.get("groupInstanceId");
            if (_groupInstanceIdNode == null) {
                throw new RuntimeException("MemberResponse: unable to locate field 'groupInstanceId', which is mandatory in version " + _version);
            } else {
                if (_groupInstanceIdNode.isNull()) {
                    _object.groupInstanceId = null;
                } else {
                    if (!_groupInstanceIdNode.isTextual()) {
                        throw new RuntimeException("MemberResponse expected a string type, but got " + _node.getNodeType());
                    }
                    _object.groupInstanceId = _groupInstanceIdNode.asText();
                }
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("MemberResponse: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "MemberResponse");
            }
            return _object;
        }
        public static JsonNode write(MemberResponse _object, short _version, boolean _serializeRecords) {
            if (_version < 3) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of MemberResponse");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("memberId", new TextNode(_object.memberId));
            if (_object.groupInstanceId == null) {
                _node.set("groupInstanceId", NullNode.instance);
            } else {
                _node.set("groupInstanceId", new TextNode(_object.groupInstanceId));
            }
            _node.set("errorCode", new ShortNode(_object.errorCode));
            return _node;
        }
        public static JsonNode write(MemberResponse _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
