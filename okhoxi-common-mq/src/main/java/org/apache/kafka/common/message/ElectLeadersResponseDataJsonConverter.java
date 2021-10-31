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

import static org.apache.kafka.common.message.ElectLeadersResponseData.*;

public class ElectLeadersResponseDataJsonConverter {
    public static ElectLeadersResponseData read(JsonNode _node, short _version) {
        ElectLeadersResponseData _object = new ElectLeadersResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("ElectLeadersResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "ElectLeadersResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("ElectLeadersResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = (short) 0;
            }
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "ElectLeadersResponseData");
        }
        JsonNode _replicaElectionResultsNode = _node.get("replicaElectionResults");
        if (_replicaElectionResultsNode == null) {
            throw new RuntimeException("ElectLeadersResponseData: unable to locate field 'replicaElectionResults', which is mandatory in version " + _version);
        } else {
            if (!_replicaElectionResultsNode.isArray()) {
                throw new RuntimeException("ElectLeadersResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<ReplicaElectionResult> _collection = new ArrayList<ReplicaElectionResult>(_replicaElectionResultsNode.size());
            _object.replicaElectionResults = _collection;
            for (JsonNode _element : _replicaElectionResultsNode) {
                _collection.add(ReplicaElectionResultJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(ElectLeadersResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        if (_version >= 1) {
            _node.set("errorCode", new ShortNode(_object.errorCode));
        } else {
            if (_object.errorCode != (short) 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default errorCode at version " + _version);
            }
        }
        ArrayNode _replicaElectionResultsArray = new ArrayNode(JsonNodeFactory.instance);
        for (ReplicaElectionResult _element : _object.replicaElectionResults) {
            _replicaElectionResultsArray.add(ReplicaElectionResultJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("replicaElectionResults", _replicaElectionResultsArray);
        return _node;
    }
    public static JsonNode write(ElectLeadersResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class PartitionResultJsonConverter {
        public static PartitionResult read(JsonNode _node, short _version) {
            PartitionResult _object = new PartitionResult();
            JsonNode _partitionIdNode = _node.get("partitionId");
            if (_partitionIdNode == null) {
                throw new RuntimeException("PartitionResult: unable to locate field 'partitionId', which is mandatory in version " + _version);
            } else {
                _object.partitionId = MessageUtil.jsonNodeToInt(_partitionIdNode, "PartitionResult");
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("PartitionResult: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "PartitionResult");
            }
            JsonNode _errorMessageNode = _node.get("errorMessage");
            if (_errorMessageNode == null) {
                throw new RuntimeException("PartitionResult: unable to locate field 'errorMessage', which is mandatory in version " + _version);
            } else {
                if (_errorMessageNode.isNull()) {
                    _object.errorMessage = null;
                } else {
                    if (!_errorMessageNode.isTextual()) {
                        throw new RuntimeException("PartitionResult expected a string type, but got " + _node.getNodeType());
                    }
                    _object.errorMessage = _errorMessageNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(PartitionResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionId", new IntNode(_object.partitionId));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            if (_object.errorMessage == null) {
                _node.set("errorMessage", NullNode.instance);
            } else {
                _node.set("errorMessage", new TextNode(_object.errorMessage));
            }
            return _node;
        }
        public static JsonNode write(PartitionResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class ReplicaElectionResultJsonConverter {
        public static ReplicaElectionResult read(JsonNode _node, short _version) {
            ReplicaElectionResult _object = new ReplicaElectionResult();
            JsonNode _topicNode = _node.get("topic");
            if (_topicNode == null) {
                throw new RuntimeException("ReplicaElectionResult: unable to locate field 'topic', which is mandatory in version " + _version);
            } else {
                if (!_topicNode.isTextual()) {
                    throw new RuntimeException("ReplicaElectionResult expected a string type, but got " + _node.getNodeType());
                }
                _object.topic = _topicNode.asText();
            }
            JsonNode _partitionResultNode = _node.get("partitionResult");
            if (_partitionResultNode == null) {
                throw new RuntimeException("ReplicaElectionResult: unable to locate field 'partitionResult', which is mandatory in version " + _version);
            } else {
                if (!_partitionResultNode.isArray()) {
                    throw new RuntimeException("ReplicaElectionResult expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<PartitionResult> _collection = new ArrayList<PartitionResult>(_partitionResultNode.size());
                _object.partitionResult = _collection;
                for (JsonNode _element : _partitionResultNode) {
                    _collection.add(PartitionResultJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(ReplicaElectionResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topic", new TextNode(_object.topic));
            ArrayNode _partitionResultArray = new ArrayNode(JsonNodeFactory.instance);
            for (PartitionResult _element : _object.partitionResult) {
                _partitionResultArray.add(PartitionResultJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitionResult", _partitionResultArray);
            return _node;
        }
        public static JsonNode write(ReplicaElectionResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
