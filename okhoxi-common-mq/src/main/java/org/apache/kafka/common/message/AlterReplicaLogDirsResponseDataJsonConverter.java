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

import static org.apache.kafka.common.message.AlterReplicaLogDirsResponseData.*;

public class AlterReplicaLogDirsResponseDataJsonConverter {
    public static AlterReplicaLogDirsResponseData read(JsonNode _node, short _version) {
        AlterReplicaLogDirsResponseData _object = new AlterReplicaLogDirsResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("AlterReplicaLogDirsResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "AlterReplicaLogDirsResponseData");
        }
        JsonNode _resultsNode = _node.get("results");
        if (_resultsNode == null) {
            throw new RuntimeException("AlterReplicaLogDirsResponseData: unable to locate field 'results', which is mandatory in version " + _version);
        } else {
            if (!_resultsNode.isArray()) {
                throw new RuntimeException("AlterReplicaLogDirsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<AlterReplicaLogDirTopicResult> _collection = new ArrayList<AlterReplicaLogDirTopicResult>(_resultsNode.size());
            _object.results = _collection;
            for (JsonNode _element : _resultsNode) {
                _collection.add(AlterReplicaLogDirTopicResultJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(AlterReplicaLogDirsResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        ArrayNode _resultsArray = new ArrayNode(JsonNodeFactory.instance);
        for (AlterReplicaLogDirTopicResult _element : _object.results) {
            _resultsArray.add(AlterReplicaLogDirTopicResultJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("results", _resultsArray);
        return _node;
    }
    public static JsonNode write(AlterReplicaLogDirsResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class AlterReplicaLogDirPartitionResultJsonConverter {
        public static AlterReplicaLogDirPartitionResult read(JsonNode _node, short _version) {
            AlterReplicaLogDirPartitionResult _object = new AlterReplicaLogDirPartitionResult();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("AlterReplicaLogDirPartitionResult: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "AlterReplicaLogDirPartitionResult");
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("AlterReplicaLogDirPartitionResult: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "AlterReplicaLogDirPartitionResult");
            }
            return _object;
        }
        public static JsonNode write(AlterReplicaLogDirPartitionResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            return _node;
        }
        public static JsonNode write(AlterReplicaLogDirPartitionResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class AlterReplicaLogDirTopicResultJsonConverter {
        public static AlterReplicaLogDirTopicResult read(JsonNode _node, short _version) {
            AlterReplicaLogDirTopicResult _object = new AlterReplicaLogDirTopicResult();
            JsonNode _topicNameNode = _node.get("topicName");
            if (_topicNameNode == null) {
                throw new RuntimeException("AlterReplicaLogDirTopicResult: unable to locate field 'topicName', which is mandatory in version " + _version);
            } else {
                if (!_topicNameNode.isTextual()) {
                    throw new RuntimeException("AlterReplicaLogDirTopicResult expected a string type, but got " + _node.getNodeType());
                }
                _object.topicName = _topicNameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("AlterReplicaLogDirTopicResult: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("AlterReplicaLogDirTopicResult expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<AlterReplicaLogDirPartitionResult> _collection = new ArrayList<AlterReplicaLogDirPartitionResult>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(AlterReplicaLogDirPartitionResultJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(AlterReplicaLogDirTopicResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topicName", new TextNode(_object.topicName));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (AlterReplicaLogDirPartitionResult _element : _object.partitions) {
                _partitionsArray.add(AlterReplicaLogDirPartitionResultJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(AlterReplicaLogDirTopicResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
