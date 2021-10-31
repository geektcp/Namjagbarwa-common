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
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.UpdateMetadataRequestData.*;

public class UpdateMetadataRequestDataJsonConverter {
    public static UpdateMetadataRequestData read(JsonNode _node, short _version) {
        UpdateMetadataRequestData _object = new UpdateMetadataRequestData();
        JsonNode _controllerIdNode = _node.get("controllerId");
        if (_controllerIdNode == null) {
            throw new RuntimeException("UpdateMetadataRequestData: unable to locate field 'controllerId', which is mandatory in version " + _version);
        } else {
            _object.controllerId = MessageUtil.jsonNodeToInt(_controllerIdNode, "UpdateMetadataRequestData");
        }
        JsonNode _controllerEpochNode = _node.get("controllerEpoch");
        if (_controllerEpochNode == null) {
            throw new RuntimeException("UpdateMetadataRequestData: unable to locate field 'controllerEpoch', which is mandatory in version " + _version);
        } else {
            _object.controllerEpoch = MessageUtil.jsonNodeToInt(_controllerEpochNode, "UpdateMetadataRequestData");
        }
        JsonNode _brokerEpochNode = _node.get("brokerEpoch");
        if (_brokerEpochNode == null) {
            if (_version >= 5) {
                throw new RuntimeException("UpdateMetadataRequestData: unable to locate field 'brokerEpoch', which is mandatory in version " + _version);
            } else {
                _object.brokerEpoch = -1L;
            }
        } else {
            _object.brokerEpoch = MessageUtil.jsonNodeToLong(_brokerEpochNode, "UpdateMetadataRequestData");
        }
        JsonNode _ungroupedPartitionStatesNode = _node.get("ungroupedPartitionStates");
        if (_ungroupedPartitionStatesNode == null) {
            if (_version <= 4) {
                throw new RuntimeException("UpdateMetadataRequestData: unable to locate field 'ungroupedPartitionStates', which is mandatory in version " + _version);
            } else {
                _object.ungroupedPartitionStates = new ArrayList<UpdateMetadataPartitionState>(0);
            }
        } else {
            if (!_ungroupedPartitionStatesNode.isArray()) {
                throw new RuntimeException("UpdateMetadataRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<UpdateMetadataPartitionState> _collection = new ArrayList<UpdateMetadataPartitionState>(_ungroupedPartitionStatesNode.size());
            _object.ungroupedPartitionStates = _collection;
            for (JsonNode _element : _ungroupedPartitionStatesNode) {
                _collection.add(UpdateMetadataPartitionStateJsonConverter.read(_element, _version));
            }
        }
        JsonNode _topicStatesNode = _node.get("topicStates");
        if (_topicStatesNode == null) {
            if (_version >= 5) {
                throw new RuntimeException("UpdateMetadataRequestData: unable to locate field 'topicStates', which is mandatory in version " + _version);
            } else {
                _object.topicStates = new ArrayList<UpdateMetadataTopicState>(0);
            }
        } else {
            if (!_topicStatesNode.isArray()) {
                throw new RuntimeException("UpdateMetadataRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<UpdateMetadataTopicState> _collection = new ArrayList<UpdateMetadataTopicState>(_topicStatesNode.size());
            _object.topicStates = _collection;
            for (JsonNode _element : _topicStatesNode) {
                _collection.add(UpdateMetadataTopicStateJsonConverter.read(_element, _version));
            }
        }
        JsonNode _liveBrokersNode = _node.get("liveBrokers");
        if (_liveBrokersNode == null) {
            throw new RuntimeException("UpdateMetadataRequestData: unable to locate field 'liveBrokers', which is mandatory in version " + _version);
        } else {
            if (!_liveBrokersNode.isArray()) {
                throw new RuntimeException("UpdateMetadataRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<UpdateMetadataBroker> _collection = new ArrayList<UpdateMetadataBroker>(_liveBrokersNode.size());
            _object.liveBrokers = _collection;
            for (JsonNode _element : _liveBrokersNode) {
                _collection.add(UpdateMetadataBrokerJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(UpdateMetadataRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("controllerId", new IntNode(_object.controllerId));
        _node.set("controllerEpoch", new IntNode(_object.controllerEpoch));
        if (_version >= 5) {
            _node.set("brokerEpoch", new LongNode(_object.brokerEpoch));
        }
        if (_version <= 4) {
            ArrayNode _ungroupedPartitionStatesArray = new ArrayNode(JsonNodeFactory.instance);
            for (UpdateMetadataPartitionState _element : _object.ungroupedPartitionStates) {
                _ungroupedPartitionStatesArray.add(UpdateMetadataPartitionStateJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("ungroupedPartitionStates", _ungroupedPartitionStatesArray);
        } else {
            if (!_object.ungroupedPartitionStates.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default ungroupedPartitionStates at version " + _version);
            }
        }
        if (_version >= 5) {
            ArrayNode _topicStatesArray = new ArrayNode(JsonNodeFactory.instance);
            for (UpdateMetadataTopicState _element : _object.topicStates) {
                _topicStatesArray.add(UpdateMetadataTopicStateJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topicStates", _topicStatesArray);
        } else {
            if (!_object.topicStates.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topicStates at version " + _version);
            }
        }
        ArrayNode _liveBrokersArray = new ArrayNode(JsonNodeFactory.instance);
        for (UpdateMetadataBroker _element : _object.liveBrokers) {
            _liveBrokersArray.add(UpdateMetadataBrokerJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("liveBrokers", _liveBrokersArray);
        return _node;
    }
    public static JsonNode write(UpdateMetadataRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class UpdateMetadataBrokerJsonConverter {
        public static UpdateMetadataBroker read(JsonNode _node, short _version) {
            UpdateMetadataBroker _object = new UpdateMetadataBroker();
            JsonNode _idNode = _node.get("id");
            if (_idNode == null) {
                throw new RuntimeException("UpdateMetadataBroker: unable to locate field 'id', which is mandatory in version " + _version);
            } else {
                _object.id = MessageUtil.jsonNodeToInt(_idNode, "UpdateMetadataBroker");
            }
            JsonNode _v0HostNode = _node.get("v0Host");
            if (_v0HostNode == null) {
                if (_version <= 0) {
                    throw new RuntimeException("UpdateMetadataBroker: unable to locate field 'v0Host', which is mandatory in version " + _version);
                } else {
                    _object.v0Host = "";
                }
            } else {
                if (!_v0HostNode.isTextual()) {
                    throw new RuntimeException("UpdateMetadataBroker expected a string type, but got " + _node.getNodeType());
                }
                _object.v0Host = _v0HostNode.asText();
            }
            JsonNode _v0PortNode = _node.get("v0Port");
            if (_v0PortNode == null) {
                if (_version <= 0) {
                    throw new RuntimeException("UpdateMetadataBroker: unable to locate field 'v0Port', which is mandatory in version " + _version);
                } else {
                    _object.v0Port = 0;
                }
            } else {
                _object.v0Port = MessageUtil.jsonNodeToInt(_v0PortNode, "UpdateMetadataBroker");
            }
            JsonNode _endpointsNode = _node.get("endpoints");
            if (_endpointsNode == null) {
                if (_version >= 1) {
                    throw new RuntimeException("UpdateMetadataBroker: unable to locate field 'endpoints', which is mandatory in version " + _version);
                } else {
                    _object.endpoints = new ArrayList<UpdateMetadataEndpoint>(0);
                }
            } else {
                if (!_endpointsNode.isArray()) {
                    throw new RuntimeException("UpdateMetadataBroker expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<UpdateMetadataEndpoint> _collection = new ArrayList<UpdateMetadataEndpoint>(_endpointsNode.size());
                _object.endpoints = _collection;
                for (JsonNode _element : _endpointsNode) {
                    _collection.add(UpdateMetadataEndpointJsonConverter.read(_element, _version));
                }
            }
            JsonNode _rackNode = _node.get("rack");
            if (_rackNode == null) {
                if (_version >= 2) {
                    throw new RuntimeException("UpdateMetadataBroker: unable to locate field 'rack', which is mandatory in version " + _version);
                } else {
                    _object.rack = "";
                }
            } else {
                if (_rackNode.isNull()) {
                    _object.rack = null;
                } else {
                    if (!_rackNode.isTextual()) {
                        throw new RuntimeException("UpdateMetadataBroker expected a string type, but got " + _node.getNodeType());
                    }
                    _object.rack = _rackNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(UpdateMetadataBroker _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("id", new IntNode(_object.id));
            if (_version <= 0) {
                _node.set("v0Host", new TextNode(_object.v0Host));
            }
            if (_version <= 0) {
                _node.set("v0Port", new IntNode(_object.v0Port));
            }
            if (_version >= 1) {
                ArrayNode _endpointsArray = new ArrayNode(JsonNodeFactory.instance);
                for (UpdateMetadataEndpoint _element : _object.endpoints) {
                    _endpointsArray.add(UpdateMetadataEndpointJsonConverter.write(_element, _version, _serializeRecords));
                }
                _node.set("endpoints", _endpointsArray);
            }
            if (_version >= 2) {
                if (_object.rack == null) {
                    _node.set("rack", NullNode.instance);
                } else {
                    _node.set("rack", new TextNode(_object.rack));
                }
            }
            return _node;
        }
        public static JsonNode write(UpdateMetadataBroker _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class UpdateMetadataEndpointJsonConverter {
        public static UpdateMetadataEndpoint read(JsonNode _node, short _version) {
            UpdateMetadataEndpoint _object = new UpdateMetadataEndpoint();
            if (_version < 1) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of UpdateMetadataEndpoint");
            }
            JsonNode _portNode = _node.get("port");
            if (_portNode == null) {
                throw new RuntimeException("UpdateMetadataEndpoint: unable to locate field 'port', which is mandatory in version " + _version);
            } else {
                _object.port = MessageUtil.jsonNodeToInt(_portNode, "UpdateMetadataEndpoint");
            }
            JsonNode _hostNode = _node.get("host");
            if (_hostNode == null) {
                throw new RuntimeException("UpdateMetadataEndpoint: unable to locate field 'host', which is mandatory in version " + _version);
            } else {
                if (!_hostNode.isTextual()) {
                    throw new RuntimeException("UpdateMetadataEndpoint expected a string type, but got " + _node.getNodeType());
                }
                _object.host = _hostNode.asText();
            }
            JsonNode _listenerNode = _node.get("listener");
            if (_listenerNode == null) {
                if (_version >= 3) {
                    throw new RuntimeException("UpdateMetadataEndpoint: unable to locate field 'listener', which is mandatory in version " + _version);
                } else {
                    _object.listener = "";
                }
            } else {
                if (!_listenerNode.isTextual()) {
                    throw new RuntimeException("UpdateMetadataEndpoint expected a string type, but got " + _node.getNodeType());
                }
                _object.listener = _listenerNode.asText();
            }
            JsonNode _securityProtocolNode = _node.get("securityProtocol");
            if (_securityProtocolNode == null) {
                throw new RuntimeException("UpdateMetadataEndpoint: unable to locate field 'securityProtocol', which is mandatory in version " + _version);
            } else {
                _object.securityProtocol = MessageUtil.jsonNodeToShort(_securityProtocolNode, "UpdateMetadataEndpoint");
            }
            return _object;
        }
        public static JsonNode write(UpdateMetadataEndpoint _object, short _version, boolean _serializeRecords) {
            if (_version < 1) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of UpdateMetadataEndpoint");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("port", new IntNode(_object.port));
            _node.set("host", new TextNode(_object.host));
            if (_version >= 3) {
                _node.set("listener", new TextNode(_object.listener));
            }
            _node.set("securityProtocol", new ShortNode(_object.securityProtocol));
            return _node;
        }
        public static JsonNode write(UpdateMetadataEndpoint _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class UpdateMetadataPartitionStateJsonConverter {
        public static UpdateMetadataPartitionState read(JsonNode _node, short _version) {
            UpdateMetadataPartitionState _object = new UpdateMetadataPartitionState();
            JsonNode _topicNameNode = _node.get("topicName");
            if (_topicNameNode == null) {
                if (_version <= 4) {
                    throw new RuntimeException("UpdateMetadataPartitionState: unable to locate field 'topicName', which is mandatory in version " + _version);
                } else {
                    _object.topicName = "";
                }
            } else {
                if (!_topicNameNode.isTextual()) {
                    throw new RuntimeException("UpdateMetadataPartitionState expected a string type, but got " + _node.getNodeType());
                }
                _object.topicName = _topicNameNode.asText();
            }
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("UpdateMetadataPartitionState: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "UpdateMetadataPartitionState");
            }
            JsonNode _controllerEpochNode = _node.get("controllerEpoch");
            if (_controllerEpochNode == null) {
                throw new RuntimeException("UpdateMetadataPartitionState: unable to locate field 'controllerEpoch', which is mandatory in version " + _version);
            } else {
                _object.controllerEpoch = MessageUtil.jsonNodeToInt(_controllerEpochNode, "UpdateMetadataPartitionState");
            }
            JsonNode _leaderNode = _node.get("leader");
            if (_leaderNode == null) {
                throw new RuntimeException("UpdateMetadataPartitionState: unable to locate field 'leader', which is mandatory in version " + _version);
            } else {
                _object.leader = MessageUtil.jsonNodeToInt(_leaderNode, "UpdateMetadataPartitionState");
            }
            JsonNode _leaderEpochNode = _node.get("leaderEpoch");
            if (_leaderEpochNode == null) {
                throw new RuntimeException("UpdateMetadataPartitionState: unable to locate field 'leaderEpoch', which is mandatory in version " + _version);
            } else {
                _object.leaderEpoch = MessageUtil.jsonNodeToInt(_leaderEpochNode, "UpdateMetadataPartitionState");
            }
            JsonNode _isrNode = _node.get("isr");
            if (_isrNode == null) {
                throw new RuntimeException("UpdateMetadataPartitionState: unable to locate field 'isr', which is mandatory in version " + _version);
            } else {
                if (!_isrNode.isArray()) {
                    throw new RuntimeException("UpdateMetadataPartitionState expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_isrNode.size());
                _object.isr = _collection;
                for (JsonNode _element : _isrNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "UpdateMetadataPartitionState element"));
                }
            }
            JsonNode _zkVersionNode = _node.get("zkVersion");
            if (_zkVersionNode == null) {
                throw new RuntimeException("UpdateMetadataPartitionState: unable to locate field 'zkVersion', which is mandatory in version " + _version);
            } else {
                _object.zkVersion = MessageUtil.jsonNodeToInt(_zkVersionNode, "UpdateMetadataPartitionState");
            }
            JsonNode _replicasNode = _node.get("replicas");
            if (_replicasNode == null) {
                throw new RuntimeException("UpdateMetadataPartitionState: unable to locate field 'replicas', which is mandatory in version " + _version);
            } else {
                if (!_replicasNode.isArray()) {
                    throw new RuntimeException("UpdateMetadataPartitionState expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_replicasNode.size());
                _object.replicas = _collection;
                for (JsonNode _element : _replicasNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "UpdateMetadataPartitionState element"));
                }
            }
            JsonNode _offlineReplicasNode = _node.get("offlineReplicas");
            if (_offlineReplicasNode == null) {
                if (_version >= 4) {
                    throw new RuntimeException("UpdateMetadataPartitionState: unable to locate field 'offlineReplicas', which is mandatory in version " + _version);
                } else {
                    _object.offlineReplicas = new ArrayList<Integer>(0);
                }
            } else {
                if (!_offlineReplicasNode.isArray()) {
                    throw new RuntimeException("UpdateMetadataPartitionState expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_offlineReplicasNode.size());
                _object.offlineReplicas = _collection;
                for (JsonNode _element : _offlineReplicasNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "UpdateMetadataPartitionState element"));
                }
            }
            return _object;
        }
        public static JsonNode write(UpdateMetadataPartitionState _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            if (_version <= 4) {
                _node.set("topicName", new TextNode(_object.topicName));
            }
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("controllerEpoch", new IntNode(_object.controllerEpoch));
            _node.set("leader", new IntNode(_object.leader));
            _node.set("leaderEpoch", new IntNode(_object.leaderEpoch));
            ArrayNode _isrArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.isr) {
                _isrArray.add(new IntNode(_element));
            }
            _node.set("isr", _isrArray);
            _node.set("zkVersion", new IntNode(_object.zkVersion));
            ArrayNode _replicasArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.replicas) {
                _replicasArray.add(new IntNode(_element));
            }
            _node.set("replicas", _replicasArray);
            if (_version >= 4) {
                ArrayNode _offlineReplicasArray = new ArrayNode(JsonNodeFactory.instance);
                for (Integer _element : _object.offlineReplicas) {
                    _offlineReplicasArray.add(new IntNode(_element));
                }
                _node.set("offlineReplicas", _offlineReplicasArray);
            }
            return _node;
        }
        public static JsonNode write(UpdateMetadataPartitionState _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class UpdateMetadataTopicStateJsonConverter {
        public static UpdateMetadataTopicState read(JsonNode _node, short _version) {
            UpdateMetadataTopicState _object = new UpdateMetadataTopicState();
            if (_version < 5) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of UpdateMetadataTopicState");
            }
            JsonNode _topicNameNode = _node.get("topicName");
            if (_topicNameNode == null) {
                throw new RuntimeException("UpdateMetadataTopicState: unable to locate field 'topicName', which is mandatory in version " + _version);
            } else {
                if (!_topicNameNode.isTextual()) {
                    throw new RuntimeException("UpdateMetadataTopicState expected a string type, but got " + _node.getNodeType());
                }
                _object.topicName = _topicNameNode.asText();
            }
            JsonNode _topicIdNode = _node.get("topicId");
            if (_topicIdNode == null) {
                if (_version >= 7) {
                    throw new RuntimeException("UpdateMetadataTopicState: unable to locate field 'topicId', which is mandatory in version " + _version);
                } else {
                    _object.topicId = Uuid.ZERO_UUID;
                }
            } else {
                if (!_topicIdNode.isTextual()) {
                    throw new RuntimeException("UpdateMetadataTopicState expected a JSON string type, but got " + _node.getNodeType());
                }
                _object.topicId = Uuid.fromString(_topicIdNode.asText());
            }
            JsonNode _partitionStatesNode = _node.get("partitionStates");
            if (_partitionStatesNode == null) {
                throw new RuntimeException("UpdateMetadataTopicState: unable to locate field 'partitionStates', which is mandatory in version " + _version);
            } else {
                if (!_partitionStatesNode.isArray()) {
                    throw new RuntimeException("UpdateMetadataTopicState expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<UpdateMetadataPartitionState> _collection = new ArrayList<UpdateMetadataPartitionState>(_partitionStatesNode.size());
                _object.partitionStates = _collection;
                for (JsonNode _element : _partitionStatesNode) {
                    _collection.add(UpdateMetadataPartitionStateJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(UpdateMetadataTopicState _object, short _version, boolean _serializeRecords) {
            if (_version < 5) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of UpdateMetadataTopicState");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topicName", new TextNode(_object.topicName));
            if (_version >= 7) {
                _node.set("topicId", new TextNode(_object.topicId.toString()));
            }
            ArrayNode _partitionStatesArray = new ArrayNode(JsonNodeFactory.instance);
            for (UpdateMetadataPartitionState _element : _object.partitionStates) {
                _partitionStatesArray.add(UpdateMetadataPartitionStateJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitionStates", _partitionStatesArray);
            return _node;
        }
        public static JsonNode write(UpdateMetadataTopicState _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
