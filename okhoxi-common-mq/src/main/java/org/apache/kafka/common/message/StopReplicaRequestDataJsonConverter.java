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
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.StopReplicaRequestData.*;

public class StopReplicaRequestDataJsonConverter {
    public static StopReplicaRequestData read(JsonNode _node, short _version) {
        StopReplicaRequestData _object = new StopReplicaRequestData();
        JsonNode _controllerIdNode = _node.get("controllerId");
        if (_controllerIdNode == null) {
            throw new RuntimeException("StopReplicaRequestData: unable to locate field 'controllerId', which is mandatory in version " + _version);
        } else {
            _object.controllerId = MessageUtil.jsonNodeToInt(_controllerIdNode, "StopReplicaRequestData");
        }
        JsonNode _controllerEpochNode = _node.get("controllerEpoch");
        if (_controllerEpochNode == null) {
            throw new RuntimeException("StopReplicaRequestData: unable to locate field 'controllerEpoch', which is mandatory in version " + _version);
        } else {
            _object.controllerEpoch = MessageUtil.jsonNodeToInt(_controllerEpochNode, "StopReplicaRequestData");
        }
        JsonNode _brokerEpochNode = _node.get("brokerEpoch");
        if (_brokerEpochNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("StopReplicaRequestData: unable to locate field 'brokerEpoch', which is mandatory in version " + _version);
            } else {
                _object.brokerEpoch = -1L;
            }
        } else {
            _object.brokerEpoch = MessageUtil.jsonNodeToLong(_brokerEpochNode, "StopReplicaRequestData");
        }
        JsonNode _deletePartitionsNode = _node.get("deletePartitions");
        if (_deletePartitionsNode == null) {
            if (_version <= 2) {
                throw new RuntimeException("StopReplicaRequestData: unable to locate field 'deletePartitions', which is mandatory in version " + _version);
            } else {
                _object.deletePartitions = false;
            }
        } else {
            if (!_deletePartitionsNode.isBoolean()) {
                throw new RuntimeException("StopReplicaRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.deletePartitions = _deletePartitionsNode.asBoolean();
        }
        JsonNode _ungroupedPartitionsNode = _node.get("ungroupedPartitions");
        if (_ungroupedPartitionsNode == null) {
            if (_version <= 0) {
                throw new RuntimeException("StopReplicaRequestData: unable to locate field 'ungroupedPartitions', which is mandatory in version " + _version);
            } else {
                _object.ungroupedPartitions = new ArrayList<StopReplicaPartitionV0>(0);
            }
        } else {
            if (!_ungroupedPartitionsNode.isArray()) {
                throw new RuntimeException("StopReplicaRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<StopReplicaPartitionV0> _collection = new ArrayList<StopReplicaPartitionV0>(_ungroupedPartitionsNode.size());
            _object.ungroupedPartitions = _collection;
            for (JsonNode _element : _ungroupedPartitionsNode) {
                _collection.add(StopReplicaPartitionV0JsonConverter.read(_element, _version));
            }
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            if ((_version >= 1) && (_version <= 2)) {
                throw new RuntimeException("StopReplicaRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
            } else {
                _object.topics = new ArrayList<StopReplicaTopicV1>(0);
            }
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("StopReplicaRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<StopReplicaTopicV1> _collection = new ArrayList<StopReplicaTopicV1>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(StopReplicaTopicV1JsonConverter.read(_element, _version));
            }
        }
        JsonNode _topicStatesNode = _node.get("topicStates");
        if (_topicStatesNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("StopReplicaRequestData: unable to locate field 'topicStates', which is mandatory in version " + _version);
            } else {
                _object.topicStates = new ArrayList<StopReplicaTopicState>(0);
            }
        } else {
            if (!_topicStatesNode.isArray()) {
                throw new RuntimeException("StopReplicaRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<StopReplicaTopicState> _collection = new ArrayList<StopReplicaTopicState>(_topicStatesNode.size());
            _object.topicStates = _collection;
            for (JsonNode _element : _topicStatesNode) {
                _collection.add(StopReplicaTopicStateJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(StopReplicaRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("controllerId", new IntNode(_object.controllerId));
        _node.set("controllerEpoch", new IntNode(_object.controllerEpoch));
        if (_version >= 1) {
            _node.set("brokerEpoch", new LongNode(_object.brokerEpoch));
        }
        if (_version <= 2) {
            _node.set("deletePartitions", BooleanNode.valueOf(_object.deletePartitions));
        } else {
            if (_object.deletePartitions) {
                throw new UnsupportedVersionException("Attempted to write a non-default deletePartitions at version " + _version);
            }
        }
        if (_version <= 0) {
            ArrayNode _ungroupedPartitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (StopReplicaPartitionV0 _element : _object.ungroupedPartitions) {
                _ungroupedPartitionsArray.add(StopReplicaPartitionV0JsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("ungroupedPartitions", _ungroupedPartitionsArray);
        } else {
            if (!_object.ungroupedPartitions.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default ungroupedPartitions at version " + _version);
            }
        }
        if ((_version >= 1) && (_version <= 2)) {
            ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
            for (StopReplicaTopicV1 _element : _object.topics) {
                _topicsArray.add(StopReplicaTopicV1JsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topics", _topicsArray);
        } else {
            if (!_object.topics.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topics at version " + _version);
            }
        }
        if (_version >= 3) {
            ArrayNode _topicStatesArray = new ArrayNode(JsonNodeFactory.instance);
            for (StopReplicaTopicState _element : _object.topicStates) {
                _topicStatesArray.add(StopReplicaTopicStateJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topicStates", _topicStatesArray);
        } else {
            if (!_object.topicStates.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topicStates at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(StopReplicaRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class StopReplicaPartitionStateJsonConverter {
        public static StopReplicaPartitionState read(JsonNode _node, short _version) {
            StopReplicaPartitionState _object = new StopReplicaPartitionState();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("StopReplicaPartitionState: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "StopReplicaPartitionState");
            }
            JsonNode _leaderEpochNode = _node.get("leaderEpoch");
            if (_leaderEpochNode == null) {
                throw new RuntimeException("StopReplicaPartitionState: unable to locate field 'leaderEpoch', which is mandatory in version " + _version);
            } else {
                _object.leaderEpoch = MessageUtil.jsonNodeToInt(_leaderEpochNode, "StopReplicaPartitionState");
            }
            JsonNode _deletePartitionNode = _node.get("deletePartition");
            if (_deletePartitionNode == null) {
                throw new RuntimeException("StopReplicaPartitionState: unable to locate field 'deletePartition', which is mandatory in version " + _version);
            } else {
                if (!_deletePartitionNode.isBoolean()) {
                    throw new RuntimeException("StopReplicaPartitionState expected Boolean type, but got " + _node.getNodeType());
                }
                _object.deletePartition = _deletePartitionNode.asBoolean();
            }
            return _object;
        }
        public static JsonNode write(StopReplicaPartitionState _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("leaderEpoch", new IntNode(_object.leaderEpoch));
            _node.set("deletePartition", BooleanNode.valueOf(_object.deletePartition));
            return _node;
        }
        public static JsonNode write(StopReplicaPartitionState _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class StopReplicaPartitionV0JsonConverter {
        public static StopReplicaPartitionV0 read(JsonNode _node, short _version) {
            StopReplicaPartitionV0 _object = new StopReplicaPartitionV0();
            if (_version > 0) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of StopReplicaPartitionV0");
            }
            JsonNode _topicNameNode = _node.get("topicName");
            if (_topicNameNode == null) {
                throw new RuntimeException("StopReplicaPartitionV0: unable to locate field 'topicName', which is mandatory in version " + _version);
            } else {
                if (!_topicNameNode.isTextual()) {
                    throw new RuntimeException("StopReplicaPartitionV0 expected a string type, but got " + _node.getNodeType());
                }
                _object.topicName = _topicNameNode.asText();
            }
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("StopReplicaPartitionV0: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "StopReplicaPartitionV0");
            }
            return _object;
        }
        public static JsonNode write(StopReplicaPartitionV0 _object, short _version, boolean _serializeRecords) {
            if (_version > 0) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of StopReplicaPartitionV0");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topicName", new TextNode(_object.topicName));
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            return _node;
        }
        public static JsonNode write(StopReplicaPartitionV0 _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class StopReplicaTopicStateJsonConverter {
        public static StopReplicaTopicState read(JsonNode _node, short _version) {
            StopReplicaTopicState _object = new StopReplicaTopicState();
            if (_version < 3) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of StopReplicaTopicState");
            }
            JsonNode _topicNameNode = _node.get("topicName");
            if (_topicNameNode == null) {
                throw new RuntimeException("StopReplicaTopicState: unable to locate field 'topicName', which is mandatory in version " + _version);
            } else {
                if (!_topicNameNode.isTextual()) {
                    throw new RuntimeException("StopReplicaTopicState expected a string type, but got " + _node.getNodeType());
                }
                _object.topicName = _topicNameNode.asText();
            }
            JsonNode _partitionStatesNode = _node.get("partitionStates");
            if (_partitionStatesNode == null) {
                throw new RuntimeException("StopReplicaTopicState: unable to locate field 'partitionStates', which is mandatory in version " + _version);
            } else {
                if (!_partitionStatesNode.isArray()) {
                    throw new RuntimeException("StopReplicaTopicState expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<StopReplicaPartitionState> _collection = new ArrayList<StopReplicaPartitionState>(_partitionStatesNode.size());
                _object.partitionStates = _collection;
                for (JsonNode _element : _partitionStatesNode) {
                    _collection.add(StopReplicaPartitionStateJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(StopReplicaTopicState _object, short _version, boolean _serializeRecords) {
            if (_version < 3) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of StopReplicaTopicState");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topicName", new TextNode(_object.topicName));
            ArrayNode _partitionStatesArray = new ArrayNode(JsonNodeFactory.instance);
            for (StopReplicaPartitionState _element : _object.partitionStates) {
                _partitionStatesArray.add(StopReplicaPartitionStateJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitionStates", _partitionStatesArray);
            return _node;
        }
        public static JsonNode write(StopReplicaTopicState _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class StopReplicaTopicV1JsonConverter {
        public static StopReplicaTopicV1 read(JsonNode _node, short _version) {
            StopReplicaTopicV1 _object = new StopReplicaTopicV1();
            if ((_version < 1) || (_version > 2)) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of StopReplicaTopicV1");
            }
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("StopReplicaTopicV1: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("StopReplicaTopicV1 expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionIndexesNode = _node.get("partitionIndexes");
            if (_partitionIndexesNode == null) {
                throw new RuntimeException("StopReplicaTopicV1: unable to locate field 'partitionIndexes', which is mandatory in version " + _version);
            } else {
                if (!_partitionIndexesNode.isArray()) {
                    throw new RuntimeException("StopReplicaTopicV1 expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_partitionIndexesNode.size());
                _object.partitionIndexes = _collection;
                for (JsonNode _element : _partitionIndexesNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "StopReplicaTopicV1 element"));
                }
            }
            return _object;
        }
        public static JsonNode write(StopReplicaTopicV1 _object, short _version, boolean _serializeRecords) {
            if ((_version < 1) || (_version > 2)) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of StopReplicaTopicV1");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionIndexesArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.partitionIndexes) {
                _partitionIndexesArray.add(new IntNode(_element));
            }
            _node.set("partitionIndexes", _partitionIndexesArray);
            return _node;
        }
        public static JsonNode write(StopReplicaTopicV1 _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
