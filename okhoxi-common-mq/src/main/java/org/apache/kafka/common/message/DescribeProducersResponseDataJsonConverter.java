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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DescribeProducersResponseData.*;

public class DescribeProducersResponseDataJsonConverter {
    public static DescribeProducersResponseData read(JsonNode _node, short _version) {
        DescribeProducersResponseData _object = new DescribeProducersResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("DescribeProducersResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "DescribeProducersResponseData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("DescribeProducersResponseData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("DescribeProducersResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<TopicResponse> _collection = new ArrayList<TopicResponse>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(TopicResponseJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(DescribeProducersResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (TopicResponse _element : _object.topics) {
            _topicsArray.add(TopicResponseJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        return _node;
    }
    public static JsonNode write(DescribeProducersResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class PartitionResponseJsonConverter {
        public static PartitionResponse read(JsonNode _node, short _version) {
            PartitionResponse _object = new PartitionResponse();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("PartitionResponse: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "PartitionResponse");
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("PartitionResponse: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "PartitionResponse");
            }
            JsonNode _errorMessageNode = _node.get("errorMessage");
            if (_errorMessageNode == null) {
                throw new RuntimeException("PartitionResponse: unable to locate field 'errorMessage', which is mandatory in version " + _version);
            } else {
                if (_errorMessageNode.isNull()) {
                    _object.errorMessage = null;
                } else {
                    if (!_errorMessageNode.isTextual()) {
                        throw new RuntimeException("PartitionResponse expected a string type, but got " + _node.getNodeType());
                    }
                    _object.errorMessage = _errorMessageNode.asText();
                }
            }
            JsonNode _activeProducersNode = _node.get("activeProducers");
            if (_activeProducersNode == null) {
                throw new RuntimeException("PartitionResponse: unable to locate field 'activeProducers', which is mandatory in version " + _version);
            } else {
                if (!_activeProducersNode.isArray()) {
                    throw new RuntimeException("PartitionResponse expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<ProducerState> _collection = new ArrayList<ProducerState>(_activeProducersNode.size());
                _object.activeProducers = _collection;
                for (JsonNode _element : _activeProducersNode) {
                    _collection.add(ProducerStateJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(PartitionResponse _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            if (_object.errorMessage == null) {
                _node.set("errorMessage", NullNode.instance);
            } else {
                _node.set("errorMessage", new TextNode(_object.errorMessage));
            }
            ArrayNode _activeProducersArray = new ArrayNode(JsonNodeFactory.instance);
            for (ProducerState _element : _object.activeProducers) {
                _activeProducersArray.add(ProducerStateJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("activeProducers", _activeProducersArray);
            return _node;
        }
        public static JsonNode write(PartitionResponse _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class ProducerStateJsonConverter {
        public static ProducerState read(JsonNode _node, short _version) {
            ProducerState _object = new ProducerState();
            JsonNode _producerIdNode = _node.get("producerId");
            if (_producerIdNode == null) {
                throw new RuntimeException("ProducerState: unable to locate field 'producerId', which is mandatory in version " + _version);
            } else {
                _object.producerId = MessageUtil.jsonNodeToLong(_producerIdNode, "ProducerState");
            }
            JsonNode _producerEpochNode = _node.get("producerEpoch");
            if (_producerEpochNode == null) {
                throw new RuntimeException("ProducerState: unable to locate field 'producerEpoch', which is mandatory in version " + _version);
            } else {
                _object.producerEpoch = MessageUtil.jsonNodeToInt(_producerEpochNode, "ProducerState");
            }
            JsonNode _lastSequenceNode = _node.get("lastSequence");
            if (_lastSequenceNode == null) {
                throw new RuntimeException("ProducerState: unable to locate field 'lastSequence', which is mandatory in version " + _version);
            } else {
                _object.lastSequence = MessageUtil.jsonNodeToInt(_lastSequenceNode, "ProducerState");
            }
            JsonNode _lastTimestampNode = _node.get("lastTimestamp");
            if (_lastTimestampNode == null) {
                throw new RuntimeException("ProducerState: unable to locate field 'lastTimestamp', which is mandatory in version " + _version);
            } else {
                _object.lastTimestamp = MessageUtil.jsonNodeToLong(_lastTimestampNode, "ProducerState");
            }
            JsonNode _coordinatorEpochNode = _node.get("coordinatorEpoch");
            if (_coordinatorEpochNode == null) {
                throw new RuntimeException("ProducerState: unable to locate field 'coordinatorEpoch', which is mandatory in version " + _version);
            } else {
                _object.coordinatorEpoch = MessageUtil.jsonNodeToInt(_coordinatorEpochNode, "ProducerState");
            }
            JsonNode _currentTxnStartOffsetNode = _node.get("currentTxnStartOffset");
            if (_currentTxnStartOffsetNode == null) {
                throw new RuntimeException("ProducerState: unable to locate field 'currentTxnStartOffset', which is mandatory in version " + _version);
            } else {
                _object.currentTxnStartOffset = MessageUtil.jsonNodeToLong(_currentTxnStartOffsetNode, "ProducerState");
            }
            return _object;
        }
        public static JsonNode write(ProducerState _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("producerId", new LongNode(_object.producerId));
            _node.set("producerEpoch", new IntNode(_object.producerEpoch));
            _node.set("lastSequence", new IntNode(_object.lastSequence));
            _node.set("lastTimestamp", new LongNode(_object.lastTimestamp));
            _node.set("coordinatorEpoch", new IntNode(_object.coordinatorEpoch));
            _node.set("currentTxnStartOffset", new LongNode(_object.currentTxnStartOffset));
            return _node;
        }
        public static JsonNode write(ProducerState _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class TopicResponseJsonConverter {
        public static TopicResponse read(JsonNode _node, short _version) {
            TopicResponse _object = new TopicResponse();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("TopicResponse: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("TopicResponse expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("TopicResponse: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("TopicResponse expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<PartitionResponse> _collection = new ArrayList<PartitionResponse>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(PartitionResponseJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(TopicResponse _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (PartitionResponse _element : _object.partitions) {
                _partitionsArray.add(PartitionResponseJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(TopicResponse _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
