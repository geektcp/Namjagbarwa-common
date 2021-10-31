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
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.SyncGroupRequestData.*;

public class SyncGroupRequestDataJsonConverter {
    public static SyncGroupRequestData read(JsonNode _node, short _version) {
        SyncGroupRequestData _object = new SyncGroupRequestData();
        JsonNode _groupIdNode = _node.get("groupId");
        if (_groupIdNode == null) {
            throw new RuntimeException("SyncGroupRequestData: unable to locate field 'groupId', which is mandatory in version " + _version);
        } else {
            if (!_groupIdNode.isTextual()) {
                throw new RuntimeException("SyncGroupRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.groupId = _groupIdNode.asText();
        }
        JsonNode _generationIdNode = _node.get("generationId");
        if (_generationIdNode == null) {
            throw new RuntimeException("SyncGroupRequestData: unable to locate field 'generationId', which is mandatory in version " + _version);
        } else {
            _object.generationId = MessageUtil.jsonNodeToInt(_generationIdNode, "SyncGroupRequestData");
        }
        JsonNode _memberIdNode = _node.get("memberId");
        if (_memberIdNode == null) {
            throw new RuntimeException("SyncGroupRequestData: unable to locate field 'memberId', which is mandatory in version " + _version);
        } else {
            if (!_memberIdNode.isTextual()) {
                throw new RuntimeException("SyncGroupRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.memberId = _memberIdNode.asText();
        }
        JsonNode _groupInstanceIdNode = _node.get("groupInstanceId");
        if (_groupInstanceIdNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("SyncGroupRequestData: unable to locate field 'groupInstanceId', which is mandatory in version " + _version);
            } else {
                _object.groupInstanceId = null;
            }
        } else {
            if (_groupInstanceIdNode.isNull()) {
                _object.groupInstanceId = null;
            } else {
                if (!_groupInstanceIdNode.isTextual()) {
                    throw new RuntimeException("SyncGroupRequestData expected a string type, but got " + _node.getNodeType());
                }
                _object.groupInstanceId = _groupInstanceIdNode.asText();
            }
        }
        JsonNode _protocolTypeNode = _node.get("protocolType");
        if (_protocolTypeNode == null) {
            if (_version >= 5) {
                throw new RuntimeException("SyncGroupRequestData: unable to locate field 'protocolType', which is mandatory in version " + _version);
            } else {
                _object.protocolType = null;
            }
        } else {
            if (_protocolTypeNode.isNull()) {
                _object.protocolType = null;
            } else {
                if (!_protocolTypeNode.isTextual()) {
                    throw new RuntimeException("SyncGroupRequestData expected a string type, but got " + _node.getNodeType());
                }
                _object.protocolType = _protocolTypeNode.asText();
            }
        }
        JsonNode _protocolNameNode = _node.get("protocolName");
        if (_protocolNameNode == null) {
            if (_version >= 5) {
                throw new RuntimeException("SyncGroupRequestData: unable to locate field 'protocolName', which is mandatory in version " + _version);
            } else {
                _object.protocolName = null;
            }
        } else {
            if (_protocolNameNode.isNull()) {
                _object.protocolName = null;
            } else {
                if (!_protocolNameNode.isTextual()) {
                    throw new RuntimeException("SyncGroupRequestData expected a string type, but got " + _node.getNodeType());
                }
                _object.protocolName = _protocolNameNode.asText();
            }
        }
        JsonNode _assignmentsNode = _node.get("assignments");
        if (_assignmentsNode == null) {
            throw new RuntimeException("SyncGroupRequestData: unable to locate field 'assignments', which is mandatory in version " + _version);
        } else {
            if (!_assignmentsNode.isArray()) {
                throw new RuntimeException("SyncGroupRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<SyncGroupRequestAssignment> _collection = new ArrayList<SyncGroupRequestAssignment>(_assignmentsNode.size());
            _object.assignments = _collection;
            for (JsonNode _element : _assignmentsNode) {
                _collection.add(SyncGroupRequestAssignmentJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(SyncGroupRequestData _object, short _version, boolean _serializeRecords) {
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
        ArrayNode _assignmentsArray = new ArrayNode(JsonNodeFactory.instance);
        for (SyncGroupRequestAssignment _element : _object.assignments) {
            _assignmentsArray.add(SyncGroupRequestAssignmentJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("assignments", _assignmentsArray);
        return _node;
    }
    public static JsonNode write(SyncGroupRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class SyncGroupRequestAssignmentJsonConverter {
        public static SyncGroupRequestAssignment read(JsonNode _node, short _version) {
            SyncGroupRequestAssignment _object = new SyncGroupRequestAssignment();
            JsonNode _memberIdNode = _node.get("memberId");
            if (_memberIdNode == null) {
                throw new RuntimeException("SyncGroupRequestAssignment: unable to locate field 'memberId', which is mandatory in version " + _version);
            } else {
                if (!_memberIdNode.isTextual()) {
                    throw new RuntimeException("SyncGroupRequestAssignment expected a string type, but got " + _node.getNodeType());
                }
                _object.memberId = _memberIdNode.asText();
            }
            JsonNode _assignmentNode = _node.get("assignment");
            if (_assignmentNode == null) {
                throw new RuntimeException("SyncGroupRequestAssignment: unable to locate field 'assignment', which is mandatory in version " + _version);
            } else {
                _object.assignment = MessageUtil.jsonNodeToBinary(_assignmentNode, "SyncGroupRequestAssignment");
            }
            return _object;
        }
        public static JsonNode write(SyncGroupRequestAssignment _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("memberId", new TextNode(_object.memberId));
            _node.set("assignment", new BinaryNode(Arrays.copyOf(_object.assignment, _object.assignment.length)));
            return _node;
        }
        public static JsonNode write(SyncGroupRequestAssignment _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
