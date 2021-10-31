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
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.ListOffsetsRequestData.*;

public class ListOffsetsRequestDataJsonConverter {
    public static ListOffsetsRequestData read(JsonNode _node, short _version) {
        ListOffsetsRequestData _object = new ListOffsetsRequestData();
        JsonNode _replicaIdNode = _node.get("replicaId");
        if (_replicaIdNode == null) {
            throw new RuntimeException("ListOffsetsRequestData: unable to locate field 'replicaId', which is mandatory in version " + _version);
        } else {
            _object.replicaId = MessageUtil.jsonNodeToInt(_replicaIdNode, "ListOffsetsRequestData");
        }
        JsonNode _isolationLevelNode = _node.get("isolationLevel");
        if (_isolationLevelNode == null) {
            if (_version >= 2) {
                throw new RuntimeException("ListOffsetsRequestData: unable to locate field 'isolationLevel', which is mandatory in version " + _version);
            } else {
                _object.isolationLevel = (byte) 0;
            }
        } else {
            _object.isolationLevel = MessageUtil.jsonNodeToByte(_isolationLevelNode, "ListOffsetsRequestData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("ListOffsetsRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("ListOffsetsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<ListOffsetsTopic> _collection = new ArrayList<ListOffsetsTopic>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(ListOffsetsTopicJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(ListOffsetsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("replicaId", new IntNode(_object.replicaId));
        if (_version >= 2) {
            _node.set("isolationLevel", new ShortNode(_object.isolationLevel));
        } else {
            if (_object.isolationLevel != (byte) 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default isolationLevel at version " + _version);
            }
        }
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (ListOffsetsTopic _element : _object.topics) {
            _topicsArray.add(ListOffsetsTopicJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        return _node;
    }
    public static JsonNode write(ListOffsetsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class ListOffsetsPartitionJsonConverter {
        public static ListOffsetsPartition read(JsonNode _node, short _version) {
            ListOffsetsPartition _object = new ListOffsetsPartition();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("ListOffsetsPartition: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "ListOffsetsPartition");
            }
            JsonNode _currentLeaderEpochNode = _node.get("currentLeaderEpoch");
            if (_currentLeaderEpochNode == null) {
                if (_version >= 4) {
                    throw new RuntimeException("ListOffsetsPartition: unable to locate field 'currentLeaderEpoch', which is mandatory in version " + _version);
                } else {
                    _object.currentLeaderEpoch = -1;
                }
            } else {
                _object.currentLeaderEpoch = MessageUtil.jsonNodeToInt(_currentLeaderEpochNode, "ListOffsetsPartition");
            }
            JsonNode _timestampNode = _node.get("timestamp");
            if (_timestampNode == null) {
                throw new RuntimeException("ListOffsetsPartition: unable to locate field 'timestamp', which is mandatory in version " + _version);
            } else {
                _object.timestamp = MessageUtil.jsonNodeToLong(_timestampNode, "ListOffsetsPartition");
            }
            JsonNode _maxNumOffsetsNode = _node.get("maxNumOffsets");
            if (_maxNumOffsetsNode == null) {
                if (_version <= 0) {
                    throw new RuntimeException("ListOffsetsPartition: unable to locate field 'maxNumOffsets', which is mandatory in version " + _version);
                } else {
                    _object.maxNumOffsets = 1;
                }
            } else {
                _object.maxNumOffsets = MessageUtil.jsonNodeToInt(_maxNumOffsetsNode, "ListOffsetsPartition");
            }
            return _object;
        }
        public static JsonNode write(ListOffsetsPartition _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            if (_version >= 4) {
                _node.set("currentLeaderEpoch", new IntNode(_object.currentLeaderEpoch));
            }
            _node.set("timestamp", new LongNode(_object.timestamp));
            if (_version <= 0) {
                _node.set("maxNumOffsets", new IntNode(_object.maxNumOffsets));
            } else {
                if (_object.maxNumOffsets != 1) {
                    throw new UnsupportedVersionException("Attempted to write a non-default maxNumOffsets at version " + _version);
                }
            }
            return _node;
        }
        public static JsonNode write(ListOffsetsPartition _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class ListOffsetsTopicJsonConverter {
        public static ListOffsetsTopic read(JsonNode _node, short _version) {
            ListOffsetsTopic _object = new ListOffsetsTopic();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("ListOffsetsTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("ListOffsetsTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("ListOffsetsTopic: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("ListOffsetsTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<ListOffsetsPartition> _collection = new ArrayList<ListOffsetsPartition>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(ListOffsetsPartitionJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(ListOffsetsTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (ListOffsetsPartition _element : _object.partitions) {
                _partitionsArray.add(ListOffsetsPartitionJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(ListOffsetsTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
