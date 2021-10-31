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
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.AlterPartitionReassignmentsRequestData.*;

public class AlterPartitionReassignmentsRequestDataJsonConverter {
    public static AlterPartitionReassignmentsRequestData read(JsonNode _node, short _version) {
        AlterPartitionReassignmentsRequestData _object = new AlterPartitionReassignmentsRequestData();
        JsonNode _timeoutMsNode = _node.get("timeoutMs");
        if (_timeoutMsNode == null) {
            throw new RuntimeException("AlterPartitionReassignmentsRequestData: unable to locate field 'timeoutMs', which is mandatory in version " + _version);
        } else {
            _object.timeoutMs = MessageUtil.jsonNodeToInt(_timeoutMsNode, "AlterPartitionReassignmentsRequestData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("AlterPartitionReassignmentsRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("AlterPartitionReassignmentsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<ReassignableTopic> _collection = new ArrayList<ReassignableTopic>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(ReassignableTopicJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(AlterPartitionReassignmentsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("timeoutMs", new IntNode(_object.timeoutMs));
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (ReassignableTopic _element : _object.topics) {
            _topicsArray.add(ReassignableTopicJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        return _node;
    }
    public static JsonNode write(AlterPartitionReassignmentsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class ReassignablePartitionJsonConverter {
        public static ReassignablePartition read(JsonNode _node, short _version) {
            ReassignablePartition _object = new ReassignablePartition();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("ReassignablePartition: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "ReassignablePartition");
            }
            JsonNode _replicasNode = _node.get("replicas");
            if (_replicasNode == null) {
                throw new RuntimeException("ReassignablePartition: unable to locate field 'replicas', which is mandatory in version " + _version);
            } else {
                if (_replicasNode.isNull()) {
                    _object.replicas = null;
                } else {
                    if (!_replicasNode.isArray()) {
                        throw new RuntimeException("ReassignablePartition expected a JSON array, but got " + _node.getNodeType());
                    }
                    ArrayList<Integer> _collection = new ArrayList<Integer>(_replicasNode.size());
                    _object.replicas = _collection;
                    for (JsonNode _element : _replicasNode) {
                        _collection.add(MessageUtil.jsonNodeToInt(_element, "ReassignablePartition element"));
                    }
                }
            }
            return _object;
        }
        public static JsonNode write(ReassignablePartition _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            if (_object.replicas == null) {
                _node.set("replicas", NullNode.instance);
            } else {
                ArrayNode _replicasArray = new ArrayNode(JsonNodeFactory.instance);
                for (Integer _element : _object.replicas) {
                    _replicasArray.add(new IntNode(_element));
                }
                _node.set("replicas", _replicasArray);
            }
            return _node;
        }
        public static JsonNode write(ReassignablePartition _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class ReassignableTopicJsonConverter {
        public static ReassignableTopic read(JsonNode _node, short _version) {
            ReassignableTopic _object = new ReassignableTopic();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("ReassignableTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("ReassignableTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("ReassignableTopic: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("ReassignableTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<ReassignablePartition> _collection = new ArrayList<ReassignablePartition>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(ReassignablePartitionJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(ReassignableTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (ReassignablePartition _element : _object.partitions) {
                _partitionsArray.add(ReassignablePartitionJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(ReassignableTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
