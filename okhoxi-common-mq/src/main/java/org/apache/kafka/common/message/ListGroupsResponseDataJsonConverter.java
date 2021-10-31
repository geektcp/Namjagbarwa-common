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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.ListGroupsResponseData.*;

public class ListGroupsResponseDataJsonConverter {
    public static ListGroupsResponseData read(JsonNode _node, short _version) {
        ListGroupsResponseData _object = new ListGroupsResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("ListGroupsResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
            } else {
                _object.throttleTimeMs = 0;
            }
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "ListGroupsResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("ListGroupsResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "ListGroupsResponseData");
        }
        JsonNode _groupsNode = _node.get("groups");
        if (_groupsNode == null) {
            throw new RuntimeException("ListGroupsResponseData: unable to locate field 'groups', which is mandatory in version " + _version);
        } else {
            if (!_groupsNode.isArray()) {
                throw new RuntimeException("ListGroupsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<ListedGroup> _collection = new ArrayList<ListedGroup>(_groupsNode.size());
            _object.groups = _collection;
            for (JsonNode _element : _groupsNode) {
                _collection.add(ListedGroupJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(ListGroupsResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 1) {
            _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        }
        _node.set("errorCode", new ShortNode(_object.errorCode));
        ArrayNode _groupsArray = new ArrayNode(JsonNodeFactory.instance);
        for (ListedGroup _element : _object.groups) {
            _groupsArray.add(ListedGroupJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("groups", _groupsArray);
        return _node;
    }
    public static JsonNode write(ListGroupsResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class ListedGroupJsonConverter {
        public static ListedGroup read(JsonNode _node, short _version) {
            ListedGroup _object = new ListedGroup();
            JsonNode _groupIdNode = _node.get("groupId");
            if (_groupIdNode == null) {
                throw new RuntimeException("ListedGroup: unable to locate field 'groupId', which is mandatory in version " + _version);
            } else {
                if (!_groupIdNode.isTextual()) {
                    throw new RuntimeException("ListedGroup expected a string type, but got " + _node.getNodeType());
                }
                _object.groupId = _groupIdNode.asText();
            }
            JsonNode _protocolTypeNode = _node.get("protocolType");
            if (_protocolTypeNode == null) {
                throw new RuntimeException("ListedGroup: unable to locate field 'protocolType', which is mandatory in version " + _version);
            } else {
                if (!_protocolTypeNode.isTextual()) {
                    throw new RuntimeException("ListedGroup expected a string type, but got " + _node.getNodeType());
                }
                _object.protocolType = _protocolTypeNode.asText();
            }
            JsonNode _groupStateNode = _node.get("groupState");
            if (_groupStateNode == null) {
                if (_version >= 4) {
                    throw new RuntimeException("ListedGroup: unable to locate field 'groupState', which is mandatory in version " + _version);
                } else {
                    _object.groupState = "";
                }
            } else {
                if (!_groupStateNode.isTextual()) {
                    throw new RuntimeException("ListedGroup expected a string type, but got " + _node.getNodeType());
                }
                _object.groupState = _groupStateNode.asText();
            }
            return _object;
        }
        public static JsonNode write(ListedGroup _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("groupId", new TextNode(_object.groupId));
            _node.set("protocolType", new TextNode(_object.protocolType));
            if (_version >= 4) {
                _node.set("groupState", new TextNode(_object.groupState));
            }
            return _node;
        }
        public static JsonNode write(ListedGroup _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
