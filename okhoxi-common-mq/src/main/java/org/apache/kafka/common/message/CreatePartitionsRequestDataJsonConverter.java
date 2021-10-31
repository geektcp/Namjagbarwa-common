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
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.CreatePartitionsRequestData.*;

public class CreatePartitionsRequestDataJsonConverter {
    public static CreatePartitionsRequestData read(JsonNode _node, short _version) {
        CreatePartitionsRequestData _object = new CreatePartitionsRequestData();
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("CreatePartitionsRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("CreatePartitionsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            CreatePartitionsTopicCollection _collection = new CreatePartitionsTopicCollection(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(CreatePartitionsTopicJsonConverter.read(_element, _version));
            }
        }
        JsonNode _timeoutMsNode = _node.get("timeoutMs");
        if (_timeoutMsNode == null) {
            throw new RuntimeException("CreatePartitionsRequestData: unable to locate field 'timeoutMs', which is mandatory in version " + _version);
        } else {
            _object.timeoutMs = MessageUtil.jsonNodeToInt(_timeoutMsNode, "CreatePartitionsRequestData");
        }
        JsonNode _validateOnlyNode = _node.get("validateOnly");
        if (_validateOnlyNode == null) {
            throw new RuntimeException("CreatePartitionsRequestData: unable to locate field 'validateOnly', which is mandatory in version " + _version);
        } else {
            if (!_validateOnlyNode.isBoolean()) {
                throw new RuntimeException("CreatePartitionsRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.validateOnly = _validateOnlyNode.asBoolean();
        }
        return _object;
    }
    public static JsonNode write(CreatePartitionsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (CreatePartitionsTopic _element : _object.topics) {
            _topicsArray.add(CreatePartitionsTopicJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        _node.set("timeoutMs", new IntNode(_object.timeoutMs));
        _node.set("validateOnly", BooleanNode.valueOf(_object.validateOnly));
        return _node;
    }
    public static JsonNode write(CreatePartitionsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class CreatePartitionsAssignmentJsonConverter {
        public static CreatePartitionsAssignment read(JsonNode _node, short _version) {
            CreatePartitionsAssignment _object = new CreatePartitionsAssignment();
            JsonNode _brokerIdsNode = _node.get("brokerIds");
            if (_brokerIdsNode == null) {
                throw new RuntimeException("CreatePartitionsAssignment: unable to locate field 'brokerIds', which is mandatory in version " + _version);
            } else {
                if (!_brokerIdsNode.isArray()) {
                    throw new RuntimeException("CreatePartitionsAssignment expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_brokerIdsNode.size());
                _object.brokerIds = _collection;
                for (JsonNode _element : _brokerIdsNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "CreatePartitionsAssignment element"));
                }
            }
            return _object;
        }
        public static JsonNode write(CreatePartitionsAssignment _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            ArrayNode _brokerIdsArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.brokerIds) {
                _brokerIdsArray.add(new IntNode(_element));
            }
            _node.set("brokerIds", _brokerIdsArray);
            return _node;
        }
        public static JsonNode write(CreatePartitionsAssignment _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class CreatePartitionsTopicJsonConverter {
        public static CreatePartitionsTopic read(JsonNode _node, short _version) {
            CreatePartitionsTopic _object = new CreatePartitionsTopic();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("CreatePartitionsTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("CreatePartitionsTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _countNode = _node.get("count");
            if (_countNode == null) {
                throw new RuntimeException("CreatePartitionsTopic: unable to locate field 'count', which is mandatory in version " + _version);
            } else {
                _object.count = MessageUtil.jsonNodeToInt(_countNode, "CreatePartitionsTopic");
            }
            JsonNode _assignmentsNode = _node.get("assignments");
            if (_assignmentsNode == null) {
                throw new RuntimeException("CreatePartitionsTopic: unable to locate field 'assignments', which is mandatory in version " + _version);
            } else {
                if (_assignmentsNode.isNull()) {
                    _object.assignments = null;
                } else {
                    if (!_assignmentsNode.isArray()) {
                        throw new RuntimeException("CreatePartitionsTopic expected a JSON array, but got " + _node.getNodeType());
                    }
                    ArrayList<CreatePartitionsAssignment> _collection = new ArrayList<CreatePartitionsAssignment>(_assignmentsNode.size());
                    _object.assignments = _collection;
                    for (JsonNode _element : _assignmentsNode) {
                        _collection.add(CreatePartitionsAssignmentJsonConverter.read(_element, _version));
                    }
                }
            }
            return _object;
        }
        public static JsonNode write(CreatePartitionsTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            _node.set("count", new IntNode(_object.count));
            if (_object.assignments == null) {
                _node.set("assignments", NullNode.instance);
            } else {
                ArrayNode _assignmentsArray = new ArrayNode(JsonNodeFactory.instance);
                for (CreatePartitionsAssignment _element : _object.assignments) {
                    _assignmentsArray.add(CreatePartitionsAssignmentJsonConverter.write(_element, _version, _serializeRecords));
                }
                _node.set("assignments", _assignmentsArray);
            }
            return _node;
        }
        public static JsonNode write(CreatePartitionsTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
