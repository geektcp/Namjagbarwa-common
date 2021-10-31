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
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.MetadataResponseData.*;

public class MetadataResponseDataJsonConverter {
    public static MetadataResponseData read(JsonNode _node, short _version) {
        MetadataResponseData _object = new MetadataResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("MetadataResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
            } else {
                _object.throttleTimeMs = 0;
            }
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "MetadataResponseData");
        }
        JsonNode _brokersNode = _node.get("brokers");
        if (_brokersNode == null) {
            throw new RuntimeException("MetadataResponseData: unable to locate field 'brokers', which is mandatory in version " + _version);
        } else {
            if (!_brokersNode.isArray()) {
                throw new RuntimeException("MetadataResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            MetadataResponseBrokerCollection _collection = new MetadataResponseBrokerCollection(_brokersNode.size());
            _object.brokers = _collection;
            for (JsonNode _element : _brokersNode) {
                _collection.add(MetadataResponseBrokerJsonConverter.read(_element, _version));
            }
        }
        JsonNode _clusterIdNode = _node.get("clusterId");
        if (_clusterIdNode == null) {
            if (_version >= 2) {
                throw new RuntimeException("MetadataResponseData: unable to locate field 'clusterId', which is mandatory in version " + _version);
            } else {
                _object.clusterId = null;
            }
        } else {
            if (_clusterIdNode.isNull()) {
                _object.clusterId = null;
            } else {
                if (!_clusterIdNode.isTextual()) {
                    throw new RuntimeException("MetadataResponseData expected a string type, but got " + _node.getNodeType());
                }
                _object.clusterId = _clusterIdNode.asText();
            }
        }
        JsonNode _controllerIdNode = _node.get("controllerId");
        if (_controllerIdNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("MetadataResponseData: unable to locate field 'controllerId', which is mandatory in version " + _version);
            } else {
                _object.controllerId = -1;
            }
        } else {
            _object.controllerId = MessageUtil.jsonNodeToInt(_controllerIdNode, "MetadataResponseData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("MetadataResponseData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("MetadataResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            MetadataResponseTopicCollection _collection = new MetadataResponseTopicCollection(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(MetadataResponseTopicJsonConverter.read(_element, _version));
            }
        }
        JsonNode _clusterAuthorizedOperationsNode = _node.get("clusterAuthorizedOperations");
        if (_clusterAuthorizedOperationsNode == null) {
            if ((_version >= 8) && (_version <= 10)) {
                throw new RuntimeException("MetadataResponseData: unable to locate field 'clusterAuthorizedOperations', which is mandatory in version " + _version);
            } else {
                _object.clusterAuthorizedOperations = -2147483648;
            }
        } else {
            _object.clusterAuthorizedOperations = MessageUtil.jsonNodeToInt(_clusterAuthorizedOperationsNode, "MetadataResponseData");
        }
        return _object;
    }
    public static JsonNode write(MetadataResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 3) {
            _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        }
        ArrayNode _brokersArray = new ArrayNode(JsonNodeFactory.instance);
        for (MetadataResponseBroker _element : _object.brokers) {
            _brokersArray.add(MetadataResponseBrokerJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("brokers", _brokersArray);
        if (_version >= 2) {
            if (_object.clusterId == null) {
                _node.set("clusterId", NullNode.instance);
            } else {
                _node.set("clusterId", new TextNode(_object.clusterId));
            }
        }
        if (_version >= 1) {
            _node.set("controllerId", new IntNode(_object.controllerId));
        }
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (MetadataResponseTopic _element : _object.topics) {
            _topicsArray.add(MetadataResponseTopicJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        if ((_version >= 8) && (_version <= 10)) {
            _node.set("clusterAuthorizedOperations", new IntNode(_object.clusterAuthorizedOperations));
        } else {
            if (_object.clusterAuthorizedOperations != -2147483648) {
                throw new UnsupportedVersionException("Attempted to write a non-default clusterAuthorizedOperations at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(MetadataResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class MetadataResponseBrokerJsonConverter {
        public static MetadataResponseBroker read(JsonNode _node, short _version) {
            MetadataResponseBroker _object = new MetadataResponseBroker();
            JsonNode _nodeIdNode = _node.get("nodeId");
            if (_nodeIdNode == null) {
                throw new RuntimeException("MetadataResponseBroker: unable to locate field 'nodeId', which is mandatory in version " + _version);
            } else {
                _object.nodeId = MessageUtil.jsonNodeToInt(_nodeIdNode, "MetadataResponseBroker");
            }
            JsonNode _hostNode = _node.get("host");
            if (_hostNode == null) {
                throw new RuntimeException("MetadataResponseBroker: unable to locate field 'host', which is mandatory in version " + _version);
            } else {
                if (!_hostNode.isTextual()) {
                    throw new RuntimeException("MetadataResponseBroker expected a string type, but got " + _node.getNodeType());
                }
                _object.host = _hostNode.asText();
            }
            JsonNode _portNode = _node.get("port");
            if (_portNode == null) {
                throw new RuntimeException("MetadataResponseBroker: unable to locate field 'port', which is mandatory in version " + _version);
            } else {
                _object.port = MessageUtil.jsonNodeToInt(_portNode, "MetadataResponseBroker");
            }
            JsonNode _rackNode = _node.get("rack");
            if (_rackNode == null) {
                if (_version >= 1) {
                    throw new RuntimeException("MetadataResponseBroker: unable to locate field 'rack', which is mandatory in version " + _version);
                } else {
                    _object.rack = null;
                }
            } else {
                if (_rackNode.isNull()) {
                    _object.rack = null;
                } else {
                    if (!_rackNode.isTextual()) {
                        throw new RuntimeException("MetadataResponseBroker expected a string type, but got " + _node.getNodeType());
                    }
                    _object.rack = _rackNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(MetadataResponseBroker _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("nodeId", new IntNode(_object.nodeId));
            _node.set("host", new TextNode(_object.host));
            _node.set("port", new IntNode(_object.port));
            if (_version >= 1) {
                if (_object.rack == null) {
                    _node.set("rack", NullNode.instance);
                } else {
                    _node.set("rack", new TextNode(_object.rack));
                }
            }
            return _node;
        }
        public static JsonNode write(MetadataResponseBroker _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class MetadataResponsePartitionJsonConverter {
        public static MetadataResponsePartition read(JsonNode _node, short _version) {
            MetadataResponsePartition _object = new MetadataResponsePartition();
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("MetadataResponsePartition: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "MetadataResponsePartition");
            }
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("MetadataResponsePartition: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "MetadataResponsePartition");
            }
            JsonNode _leaderIdNode = _node.get("leaderId");
            if (_leaderIdNode == null) {
                throw new RuntimeException("MetadataResponsePartition: unable to locate field 'leaderId', which is mandatory in version " + _version);
            } else {
                _object.leaderId = MessageUtil.jsonNodeToInt(_leaderIdNode, "MetadataResponsePartition");
            }
            JsonNode _leaderEpochNode = _node.get("leaderEpoch");
            if (_leaderEpochNode == null) {
                if (_version >= 7) {
                    throw new RuntimeException("MetadataResponsePartition: unable to locate field 'leaderEpoch', which is mandatory in version " + _version);
                } else {
                    _object.leaderEpoch = -1;
                }
            } else {
                _object.leaderEpoch = MessageUtil.jsonNodeToInt(_leaderEpochNode, "MetadataResponsePartition");
            }
            JsonNode _replicaNodesNode = _node.get("replicaNodes");
            if (_replicaNodesNode == null) {
                throw new RuntimeException("MetadataResponsePartition: unable to locate field 'replicaNodes', which is mandatory in version " + _version);
            } else {
                if (!_replicaNodesNode.isArray()) {
                    throw new RuntimeException("MetadataResponsePartition expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_replicaNodesNode.size());
                _object.replicaNodes = _collection;
                for (JsonNode _element : _replicaNodesNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "MetadataResponsePartition element"));
                }
            }
            JsonNode _isrNodesNode = _node.get("isrNodes");
            if (_isrNodesNode == null) {
                throw new RuntimeException("MetadataResponsePartition: unable to locate field 'isrNodes', which is mandatory in version " + _version);
            } else {
                if (!_isrNodesNode.isArray()) {
                    throw new RuntimeException("MetadataResponsePartition expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_isrNodesNode.size());
                _object.isrNodes = _collection;
                for (JsonNode _element : _isrNodesNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "MetadataResponsePartition element"));
                }
            }
            JsonNode _offlineReplicasNode = _node.get("offlineReplicas");
            if (_offlineReplicasNode == null) {
                if (_version >= 5) {
                    throw new RuntimeException("MetadataResponsePartition: unable to locate field 'offlineReplicas', which is mandatory in version " + _version);
                } else {
                    _object.offlineReplicas = new ArrayList<Integer>(0);
                }
            } else {
                if (!_offlineReplicasNode.isArray()) {
                    throw new RuntimeException("MetadataResponsePartition expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_offlineReplicasNode.size());
                _object.offlineReplicas = _collection;
                for (JsonNode _element : _offlineReplicasNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "MetadataResponsePartition element"));
                }
            }
            return _object;
        }
        public static JsonNode write(MetadataResponsePartition _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("errorCode", new ShortNode(_object.errorCode));
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("leaderId", new IntNode(_object.leaderId));
            if (_version >= 7) {
                _node.set("leaderEpoch", new IntNode(_object.leaderEpoch));
            }
            ArrayNode _replicaNodesArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.replicaNodes) {
                _replicaNodesArray.add(new IntNode(_element));
            }
            _node.set("replicaNodes", _replicaNodesArray);
            ArrayNode _isrNodesArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.isrNodes) {
                _isrNodesArray.add(new IntNode(_element));
            }
            _node.set("isrNodes", _isrNodesArray);
            if (_version >= 5) {
                ArrayNode _offlineReplicasArray = new ArrayNode(JsonNodeFactory.instance);
                for (Integer _element : _object.offlineReplicas) {
                    _offlineReplicasArray.add(new IntNode(_element));
                }
                _node.set("offlineReplicas", _offlineReplicasArray);
            }
            return _node;
        }
        public static JsonNode write(MetadataResponsePartition _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class MetadataResponseTopicJsonConverter {
        public static MetadataResponseTopic read(JsonNode _node, short _version) {
            MetadataResponseTopic _object = new MetadataResponseTopic();
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("MetadataResponseTopic: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "MetadataResponseTopic");
            }
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("MetadataResponseTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("MetadataResponseTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _topicIdNode = _node.get("topicId");
            if (_topicIdNode == null) {
                if (_version >= 10) {
                    throw new RuntimeException("MetadataResponseTopic: unable to locate field 'topicId', which is mandatory in version " + _version);
                } else {
                    _object.topicId = Uuid.ZERO_UUID;
                }
            } else {
                if (!_topicIdNode.isTextual()) {
                    throw new RuntimeException("MetadataResponseTopic expected a JSON string type, but got " + _node.getNodeType());
                }
                _object.topicId = Uuid.fromString(_topicIdNode.asText());
            }
            JsonNode _isInternalNode = _node.get("isInternal");
            if (_isInternalNode == null) {
                if (_version >= 1) {
                    throw new RuntimeException("MetadataResponseTopic: unable to locate field 'isInternal', which is mandatory in version " + _version);
                } else {
                    _object.isInternal = false;
                }
            } else {
                if (!_isInternalNode.isBoolean()) {
                    throw new RuntimeException("MetadataResponseTopic expected Boolean type, but got " + _node.getNodeType());
                }
                _object.isInternal = _isInternalNode.asBoolean();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("MetadataResponseTopic: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("MetadataResponseTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<MetadataResponsePartition> _collection = new ArrayList<MetadataResponsePartition>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(MetadataResponsePartitionJsonConverter.read(_element, _version));
                }
            }
            JsonNode _topicAuthorizedOperationsNode = _node.get("topicAuthorizedOperations");
            if (_topicAuthorizedOperationsNode == null) {
                if (_version >= 8) {
                    throw new RuntimeException("MetadataResponseTopic: unable to locate field 'topicAuthorizedOperations', which is mandatory in version " + _version);
                } else {
                    _object.topicAuthorizedOperations = -2147483648;
                }
            } else {
                _object.topicAuthorizedOperations = MessageUtil.jsonNodeToInt(_topicAuthorizedOperationsNode, "MetadataResponseTopic");
            }
            return _object;
        }
        public static JsonNode write(MetadataResponseTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("errorCode", new ShortNode(_object.errorCode));
            _node.set("name", new TextNode(_object.name));
            if (_version >= 10) {
                _node.set("topicId", new TextNode(_object.topicId.toString()));
            }
            if (_version >= 1) {
                _node.set("isInternal", BooleanNode.valueOf(_object.isInternal));
            }
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (MetadataResponsePartition _element : _object.partitions) {
                _partitionsArray.add(MetadataResponsePartitionJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            if (_version >= 8) {
                _node.set("topicAuthorizedOperations", new IntNode(_object.topicAuthorizedOperations));
            } else {
                if (_object.topicAuthorizedOperations != -2147483648) {
                    throw new UnsupportedVersionException("Attempted to write a non-default topicAuthorizedOperations at version " + _version);
                }
            }
            return _node;
        }
        public static JsonNode write(MetadataResponseTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
