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

import static org.apache.kafka.common.message.FetchRequestData.*;

public class FetchRequestDataJsonConverter {
    public static FetchRequestData read(JsonNode _node, short _version) {
        FetchRequestData _object = new FetchRequestData();
        JsonNode _clusterIdNode = _node.get("clusterId");
        if (_clusterIdNode == null) {
            _object.clusterId = null;
        } else {
            if (_clusterIdNode.isNull()) {
                _object.clusterId = null;
            } else {
                if (!_clusterIdNode.isTextual()) {
                    throw new RuntimeException("FetchRequestData expected a string type, but got " + _node.getNodeType());
                }
                _object.clusterId = _clusterIdNode.asText();
            }
        }
        JsonNode _replicaIdNode = _node.get("replicaId");
        if (_replicaIdNode == null) {
            throw new RuntimeException("FetchRequestData: unable to locate field 'replicaId', which is mandatory in version " + _version);
        } else {
            _object.replicaId = MessageUtil.jsonNodeToInt(_replicaIdNode, "FetchRequestData");
        }
        JsonNode _maxWaitMsNode = _node.get("maxWaitMs");
        if (_maxWaitMsNode == null) {
            throw new RuntimeException("FetchRequestData: unable to locate field 'maxWaitMs', which is mandatory in version " + _version);
        } else {
            _object.maxWaitMs = MessageUtil.jsonNodeToInt(_maxWaitMsNode, "FetchRequestData");
        }
        JsonNode _minBytesNode = _node.get("minBytes");
        if (_minBytesNode == null) {
            throw new RuntimeException("FetchRequestData: unable to locate field 'minBytes', which is mandatory in version " + _version);
        } else {
            _object.minBytes = MessageUtil.jsonNodeToInt(_minBytesNode, "FetchRequestData");
        }
        JsonNode _maxBytesNode = _node.get("maxBytes");
        if (_maxBytesNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("FetchRequestData: unable to locate field 'maxBytes', which is mandatory in version " + _version);
            } else {
                _object.maxBytes = 0x7fffffff;
            }
        } else {
            _object.maxBytes = MessageUtil.jsonNodeToInt(_maxBytesNode, "FetchRequestData");
        }
        JsonNode _isolationLevelNode = _node.get("isolationLevel");
        if (_isolationLevelNode == null) {
            if (_version >= 4) {
                throw new RuntimeException("FetchRequestData: unable to locate field 'isolationLevel', which is mandatory in version " + _version);
            } else {
                _object.isolationLevel = (byte) 0;
            }
        } else {
            _object.isolationLevel = MessageUtil.jsonNodeToByte(_isolationLevelNode, "FetchRequestData");
        }
        JsonNode _sessionIdNode = _node.get("sessionId");
        if (_sessionIdNode == null) {
            if (_version >= 7) {
                throw new RuntimeException("FetchRequestData: unable to locate field 'sessionId', which is mandatory in version " + _version);
            } else {
                _object.sessionId = 0;
            }
        } else {
            _object.sessionId = MessageUtil.jsonNodeToInt(_sessionIdNode, "FetchRequestData");
        }
        JsonNode _sessionEpochNode = _node.get("sessionEpoch");
        if (_sessionEpochNode == null) {
            if (_version >= 7) {
                throw new RuntimeException("FetchRequestData: unable to locate field 'sessionEpoch', which is mandatory in version " + _version);
            } else {
                _object.sessionEpoch = -1;
            }
        } else {
            _object.sessionEpoch = MessageUtil.jsonNodeToInt(_sessionEpochNode, "FetchRequestData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("FetchRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("FetchRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<FetchTopic> _collection = new ArrayList<FetchTopic>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(FetchTopicJsonConverter.read(_element, _version));
            }
        }
        JsonNode _forgottenTopicsDataNode = _node.get("forgottenTopicsData");
        if (_forgottenTopicsDataNode == null) {
            if (_version >= 7) {
                throw new RuntimeException("FetchRequestData: unable to locate field 'forgottenTopicsData', which is mandatory in version " + _version);
            } else {
                _object.forgottenTopicsData = new ArrayList<ForgottenTopic>(0);
            }
        } else {
            if (!_forgottenTopicsDataNode.isArray()) {
                throw new RuntimeException("FetchRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<ForgottenTopic> _collection = new ArrayList<ForgottenTopic>(_forgottenTopicsDataNode.size());
            _object.forgottenTopicsData = _collection;
            for (JsonNode _element : _forgottenTopicsDataNode) {
                _collection.add(ForgottenTopicJsonConverter.read(_element, _version));
            }
        }
        JsonNode _rackIdNode = _node.get("rackId");
        if (_rackIdNode == null) {
            if (_version >= 11) {
                throw new RuntimeException("FetchRequestData: unable to locate field 'rackId', which is mandatory in version " + _version);
            } else {
                _object.rackId = "";
            }
        } else {
            if (!_rackIdNode.isTextual()) {
                throw new RuntimeException("FetchRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.rackId = _rackIdNode.asText();
        }
        return _object;
    }
    public static JsonNode write(FetchRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 12) {
            if (_object.clusterId != null) {
                _node.set("clusterId", new TextNode(_object.clusterId));
            }
        }
        _node.set("replicaId", new IntNode(_object.replicaId));
        _node.set("maxWaitMs", new IntNode(_object.maxWaitMs));
        _node.set("minBytes", new IntNode(_object.minBytes));
        if (_version >= 3) {
            _node.set("maxBytes", new IntNode(_object.maxBytes));
        }
        if (_version >= 4) {
            _node.set("isolationLevel", new ShortNode(_object.isolationLevel));
        }
        if (_version >= 7) {
            _node.set("sessionId", new IntNode(_object.sessionId));
        }
        if (_version >= 7) {
            _node.set("sessionEpoch", new IntNode(_object.sessionEpoch));
        }
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (FetchTopic _element : _object.topics) {
            _topicsArray.add(FetchTopicJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        if (_version >= 7) {
            ArrayNode _forgottenTopicsDataArray = new ArrayNode(JsonNodeFactory.instance);
            for (ForgottenTopic _element : _object.forgottenTopicsData) {
                _forgottenTopicsDataArray.add(ForgottenTopicJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("forgottenTopicsData", _forgottenTopicsDataArray);
        } else {
            if (!_object.forgottenTopicsData.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default forgottenTopicsData at version " + _version);
            }
        }
        if (_version >= 11) {
            _node.set("rackId", new TextNode(_object.rackId));
        }
        return _node;
    }
    public static JsonNode write(FetchRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class FetchPartitionJsonConverter {
        public static FetchPartition read(JsonNode _node, short _version) {
            FetchPartition _object = new FetchPartition();
            JsonNode _partitionNode = _node.get("partition");
            if (_partitionNode == null) {
                throw new RuntimeException("FetchPartition: unable to locate field 'partition', which is mandatory in version " + _version);
            } else {
                _object.partition = MessageUtil.jsonNodeToInt(_partitionNode, "FetchPartition");
            }
            JsonNode _currentLeaderEpochNode = _node.get("currentLeaderEpoch");
            if (_currentLeaderEpochNode == null) {
                if (_version >= 9) {
                    throw new RuntimeException("FetchPartition: unable to locate field 'currentLeaderEpoch', which is mandatory in version " + _version);
                } else {
                    _object.currentLeaderEpoch = -1;
                }
            } else {
                _object.currentLeaderEpoch = MessageUtil.jsonNodeToInt(_currentLeaderEpochNode, "FetchPartition");
            }
            JsonNode _fetchOffsetNode = _node.get("fetchOffset");
            if (_fetchOffsetNode == null) {
                throw new RuntimeException("FetchPartition: unable to locate field 'fetchOffset', which is mandatory in version " + _version);
            } else {
                _object.fetchOffset = MessageUtil.jsonNodeToLong(_fetchOffsetNode, "FetchPartition");
            }
            JsonNode _lastFetchedEpochNode = _node.get("lastFetchedEpoch");
            if (_lastFetchedEpochNode == null) {
                if (_version >= 12) {
                    throw new RuntimeException("FetchPartition: unable to locate field 'lastFetchedEpoch', which is mandatory in version " + _version);
                } else {
                    _object.lastFetchedEpoch = -1;
                }
            } else {
                _object.lastFetchedEpoch = MessageUtil.jsonNodeToInt(_lastFetchedEpochNode, "FetchPartition");
            }
            JsonNode _logStartOffsetNode = _node.get("logStartOffset");
            if (_logStartOffsetNode == null) {
                if (_version >= 5) {
                    throw new RuntimeException("FetchPartition: unable to locate field 'logStartOffset', which is mandatory in version " + _version);
                } else {
                    _object.logStartOffset = -1L;
                }
            } else {
                _object.logStartOffset = MessageUtil.jsonNodeToLong(_logStartOffsetNode, "FetchPartition");
            }
            JsonNode _partitionMaxBytesNode = _node.get("partitionMaxBytes");
            if (_partitionMaxBytesNode == null) {
                throw new RuntimeException("FetchPartition: unable to locate field 'partitionMaxBytes', which is mandatory in version " + _version);
            } else {
                _object.partitionMaxBytes = MessageUtil.jsonNodeToInt(_partitionMaxBytesNode, "FetchPartition");
            }
            return _object;
        }
        public static JsonNode write(FetchPartition _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partition", new IntNode(_object.partition));
            if (_version >= 9) {
                _node.set("currentLeaderEpoch", new IntNode(_object.currentLeaderEpoch));
            }
            _node.set("fetchOffset", new LongNode(_object.fetchOffset));
            if (_version >= 12) {
                _node.set("lastFetchedEpoch", new IntNode(_object.lastFetchedEpoch));
            } else {
                if (_object.lastFetchedEpoch != -1) {
                    throw new UnsupportedVersionException("Attempted to write a non-default lastFetchedEpoch at version " + _version);
                }
            }
            if (_version >= 5) {
                _node.set("logStartOffset", new LongNode(_object.logStartOffset));
            }
            _node.set("partitionMaxBytes", new IntNode(_object.partitionMaxBytes));
            return _node;
        }
        public static JsonNode write(FetchPartition _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class FetchTopicJsonConverter {
        public static FetchTopic read(JsonNode _node, short _version) {
            FetchTopic _object = new FetchTopic();
            JsonNode _topicNode = _node.get("topic");
            if (_topicNode == null) {
                throw new RuntimeException("FetchTopic: unable to locate field 'topic', which is mandatory in version " + _version);
            } else {
                if (!_topicNode.isTextual()) {
                    throw new RuntimeException("FetchTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.topic = _topicNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("FetchTopic: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("FetchTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<FetchPartition> _collection = new ArrayList<FetchPartition>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(FetchPartitionJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(FetchTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topic", new TextNode(_object.topic));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (FetchPartition _element : _object.partitions) {
                _partitionsArray.add(FetchPartitionJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(FetchTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class ForgottenTopicJsonConverter {
        public static ForgottenTopic read(JsonNode _node, short _version) {
            ForgottenTopic _object = new ForgottenTopic();
            if (_version < 7) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of ForgottenTopic");
            }
            JsonNode _topicNode = _node.get("topic");
            if (_topicNode == null) {
                throw new RuntimeException("ForgottenTopic: unable to locate field 'topic', which is mandatory in version " + _version);
            } else {
                if (!_topicNode.isTextual()) {
                    throw new RuntimeException("ForgottenTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.topic = _topicNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("ForgottenTopic: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("ForgottenTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "ForgottenTopic element"));
                }
            }
            return _object;
        }
        public static JsonNode write(ForgottenTopic _object, short _version, boolean _serializeRecords) {
            if (_version < 7) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of ForgottenTopic");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topic", new TextNode(_object.topic));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.partitions) {
                _partitionsArray.add(new IntNode(_element));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(ForgottenTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
