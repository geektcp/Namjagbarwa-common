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
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.CreateTopicsRequestData.*;

public class CreateTopicsRequestDataJsonConverter {
    public static CreateTopicsRequestData read(JsonNode _node, short _version) {
        CreateTopicsRequestData _object = new CreateTopicsRequestData();
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("CreateTopicsRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("CreateTopicsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            CreatableTopicCollection _collection = new CreatableTopicCollection(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(CreatableTopicJsonConverter.read(_element, _version));
            }
        }
        JsonNode _timeoutMsNode = _node.get("timeoutMs");
        if (_timeoutMsNode == null) {
            throw new RuntimeException("CreateTopicsRequestData: unable to locate field 'timeoutMs', which is mandatory in version " + _version);
        } else {
            _object.timeoutMs = MessageUtil.jsonNodeToInt(_timeoutMsNode, "CreateTopicsRequestData");
        }
        JsonNode _validateOnlyNode = _node.get("validateOnly");
        if (_validateOnlyNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("CreateTopicsRequestData: unable to locate field 'validateOnly', which is mandatory in version " + _version);
            } else {
                _object.validateOnly = false;
            }
        } else {
            if (!_validateOnlyNode.isBoolean()) {
                throw new RuntimeException("CreateTopicsRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.validateOnly = _validateOnlyNode.asBoolean();
        }
        return _object;
    }
    public static JsonNode write(CreateTopicsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (CreatableTopic _element : _object.topics) {
            _topicsArray.add(CreatableTopicJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        _node.set("timeoutMs", new IntNode(_object.timeoutMs));
        if (_version >= 1) {
            _node.set("validateOnly", BooleanNode.valueOf(_object.validateOnly));
        } else {
            if (_object.validateOnly) {
                throw new UnsupportedVersionException("Attempted to write a non-default validateOnly at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(CreateTopicsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class CreatableReplicaAssignmentJsonConverter {
        public static CreatableReplicaAssignment read(JsonNode _node, short _version) {
            CreatableReplicaAssignment _object = new CreatableReplicaAssignment();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("CreatableReplicaAssignment: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "CreatableReplicaAssignment");
            }
            JsonNode _brokerIdsNode = _node.get("brokerIds");
            if (_brokerIdsNode == null) {
                throw new RuntimeException("CreatableReplicaAssignment: unable to locate field 'brokerIds', which is mandatory in version " + _version);
            } else {
                if (!_brokerIdsNode.isArray()) {
                    throw new RuntimeException("CreatableReplicaAssignment expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_brokerIdsNode.size());
                _object.brokerIds = _collection;
                for (JsonNode _element : _brokerIdsNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "CreatableReplicaAssignment element"));
                }
            }
            return _object;
        }
        public static JsonNode write(CreatableReplicaAssignment _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            ArrayNode _brokerIdsArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.brokerIds) {
                _brokerIdsArray.add(new IntNode(_element));
            }
            _node.set("brokerIds", _brokerIdsArray);
            return _node;
        }
        public static JsonNode write(CreatableReplicaAssignment _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class CreatableTopicJsonConverter {
        public static CreatableTopic read(JsonNode _node, short _version) {
            CreatableTopic _object = new CreatableTopic();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("CreatableTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("CreatableTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _numPartitionsNode = _node.get("numPartitions");
            if (_numPartitionsNode == null) {
                throw new RuntimeException("CreatableTopic: unable to locate field 'numPartitions', which is mandatory in version " + _version);
            } else {
                _object.numPartitions = MessageUtil.jsonNodeToInt(_numPartitionsNode, "CreatableTopic");
            }
            JsonNode _replicationFactorNode = _node.get("replicationFactor");
            if (_replicationFactorNode == null) {
                throw new RuntimeException("CreatableTopic: unable to locate field 'replicationFactor', which is mandatory in version " + _version);
            } else {
                _object.replicationFactor = MessageUtil.jsonNodeToShort(_replicationFactorNode, "CreatableTopic");
            }
            JsonNode _assignmentsNode = _node.get("assignments");
            if (_assignmentsNode == null) {
                throw new RuntimeException("CreatableTopic: unable to locate field 'assignments', which is mandatory in version " + _version);
            } else {
                if (!_assignmentsNode.isArray()) {
                    throw new RuntimeException("CreatableTopic expected a JSON array, but got " + _node.getNodeType());
                }
                CreatableReplicaAssignmentCollection _collection = new CreatableReplicaAssignmentCollection(_assignmentsNode.size());
                _object.assignments = _collection;
                for (JsonNode _element : _assignmentsNode) {
                    _collection.add(CreatableReplicaAssignmentJsonConverter.read(_element, _version));
                }
            }
            JsonNode _configsNode = _node.get("configs");
            if (_configsNode == null) {
                throw new RuntimeException("CreatableTopic: unable to locate field 'configs', which is mandatory in version " + _version);
            } else {
                if (!_configsNode.isArray()) {
                    throw new RuntimeException("CreatableTopic expected a JSON array, but got " + _node.getNodeType());
                }
                CreateableTopicConfigCollection _collection = new CreateableTopicConfigCollection(_configsNode.size());
                _object.configs = _collection;
                for (JsonNode _element : _configsNode) {
                    _collection.add(CreateableTopicConfigJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(CreatableTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            _node.set("numPartitions", new IntNode(_object.numPartitions));
            _node.set("replicationFactor", new ShortNode(_object.replicationFactor));
            ArrayNode _assignmentsArray = new ArrayNode(JsonNodeFactory.instance);
            for (CreatableReplicaAssignment _element : _object.assignments) {
                _assignmentsArray.add(CreatableReplicaAssignmentJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("assignments", _assignmentsArray);
            ArrayNode _configsArray = new ArrayNode(JsonNodeFactory.instance);
            for (CreateableTopicConfig _element : _object.configs) {
                _configsArray.add(CreateableTopicConfigJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("configs", _configsArray);
            return _node;
        }
        public static JsonNode write(CreatableTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class CreateableTopicConfigJsonConverter {
        public static CreateableTopicConfig read(JsonNode _node, short _version) {
            CreateableTopicConfig _object = new CreateableTopicConfig();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("CreateableTopicConfig: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("CreateableTopicConfig expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _valueNode = _node.get("value");
            if (_valueNode == null) {
                throw new RuntimeException("CreateableTopicConfig: unable to locate field 'value', which is mandatory in version " + _version);
            } else {
                if (_valueNode.isNull()) {
                    _object.value = null;
                } else {
                    if (!_valueNode.isTextual()) {
                        throw new RuntimeException("CreateableTopicConfig expected a string type, but got " + _node.getNodeType());
                    }
                    _object.value = _valueNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(CreateableTopicConfig _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            if (_object.value == null) {
                _node.set("value", NullNode.instance);
            } else {
                _node.set("value", new TextNode(_object.value));
            }
            return _node;
        }
        public static JsonNode write(CreateableTopicConfig _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
