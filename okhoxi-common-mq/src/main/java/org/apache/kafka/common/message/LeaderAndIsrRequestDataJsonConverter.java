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
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.LeaderAndIsrRequestData.*;

public class LeaderAndIsrRequestDataJsonConverter {
    public static LeaderAndIsrRequestData read(JsonNode _node, short _version) {
        LeaderAndIsrRequestData _object = new LeaderAndIsrRequestData();
        JsonNode _controllerIdNode = _node.get("controllerId");
        if (_controllerIdNode == null) {
            throw new RuntimeException("LeaderAndIsrRequestData: unable to locate field 'controllerId', which is mandatory in version " + _version);
        } else {
            _object.controllerId = MessageUtil.jsonNodeToInt(_controllerIdNode, "LeaderAndIsrRequestData");
        }
        JsonNode _controllerEpochNode = _node.get("controllerEpoch");
        if (_controllerEpochNode == null) {
            throw new RuntimeException("LeaderAndIsrRequestData: unable to locate field 'controllerEpoch', which is mandatory in version " + _version);
        } else {
            _object.controllerEpoch = MessageUtil.jsonNodeToInt(_controllerEpochNode, "LeaderAndIsrRequestData");
        }
        JsonNode _brokerEpochNode = _node.get("brokerEpoch");
        if (_brokerEpochNode == null) {
            if (_version >= 2) {
                throw new RuntimeException("LeaderAndIsrRequestData: unable to locate field 'brokerEpoch', which is mandatory in version " + _version);
            } else {
                _object.brokerEpoch = -1L;
            }
        } else {
            _object.brokerEpoch = MessageUtil.jsonNodeToLong(_brokerEpochNode, "LeaderAndIsrRequestData");
        }
        JsonNode _typeNode = _node.get("type");
        if (_typeNode == null) {
            if (_version >= 5) {
                throw new RuntimeException("LeaderAndIsrRequestData: unable to locate field 'type', which is mandatory in version " + _version);
            } else {
                _object.type = (byte) 0;
            }
        } else {
            _object.type = MessageUtil.jsonNodeToByte(_typeNode, "LeaderAndIsrRequestData");
        }
        JsonNode _ungroupedPartitionStatesNode = _node.get("ungroupedPartitionStates");
        if (_ungroupedPartitionStatesNode == null) {
            if (_version <= 1) {
                throw new RuntimeException("LeaderAndIsrRequestData: unable to locate field 'ungroupedPartitionStates', which is mandatory in version " + _version);
            } else {
                _object.ungroupedPartitionStates = new ArrayList<LeaderAndIsrPartitionState>(0);
            }
        } else {
            if (!_ungroupedPartitionStatesNode.isArray()) {
                throw new RuntimeException("LeaderAndIsrRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<LeaderAndIsrPartitionState> _collection = new ArrayList<LeaderAndIsrPartitionState>(_ungroupedPartitionStatesNode.size());
            _object.ungroupedPartitionStates = _collection;
            for (JsonNode _element : _ungroupedPartitionStatesNode) {
                _collection.add(LeaderAndIsrPartitionStateJsonConverter.read(_element, _version));
            }
        }
        JsonNode _topicStatesNode = _node.get("topicStates");
        if (_topicStatesNode == null) {
            if (_version >= 2) {
                throw new RuntimeException("LeaderAndIsrRequestData: unable to locate field 'topicStates', which is mandatory in version " + _version);
            } else {
                _object.topicStates = new ArrayList<LeaderAndIsrTopicState>(0);
            }
        } else {
            if (!_topicStatesNode.isArray()) {
                throw new RuntimeException("LeaderAndIsrRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<LeaderAndIsrTopicState> _collection = new ArrayList<LeaderAndIsrTopicState>(_topicStatesNode.size());
            _object.topicStates = _collection;
            for (JsonNode _element : _topicStatesNode) {
                _collection.add(LeaderAndIsrTopicStateJsonConverter.read(_element, _version));
            }
        }
        JsonNode _liveLeadersNode = _node.get("liveLeaders");
        if (_liveLeadersNode == null) {
            throw new RuntimeException("LeaderAndIsrRequestData: unable to locate field 'liveLeaders', which is mandatory in version " + _version);
        } else {
            if (!_liveLeadersNode.isArray()) {
                throw new RuntimeException("LeaderAndIsrRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<LeaderAndIsrLiveLeader> _collection = new ArrayList<LeaderAndIsrLiveLeader>(_liveLeadersNode.size());
            _object.liveLeaders = _collection;
            for (JsonNode _element : _liveLeadersNode) {
                _collection.add(LeaderAndIsrLiveLeaderJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(LeaderAndIsrRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("controllerId", new IntNode(_object.controllerId));
        _node.set("controllerEpoch", new IntNode(_object.controllerEpoch));
        if (_version >= 2) {
            _node.set("brokerEpoch", new LongNode(_object.brokerEpoch));
        }
        if (_version >= 5) {
            _node.set("type", new ShortNode(_object.type));
        } else {
            if (_object.type != (byte) 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default type at version " + _version);
            }
        }
        if (_version <= 1) {
            ArrayNode _ungroupedPartitionStatesArray = new ArrayNode(JsonNodeFactory.instance);
            for (LeaderAndIsrPartitionState _element : _object.ungroupedPartitionStates) {
                _ungroupedPartitionStatesArray.add(LeaderAndIsrPartitionStateJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("ungroupedPartitionStates", _ungroupedPartitionStatesArray);
        } else {
            if (!_object.ungroupedPartitionStates.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default ungroupedPartitionStates at version " + _version);
            }
        }
        if (_version >= 2) {
            ArrayNode _topicStatesArray = new ArrayNode(JsonNodeFactory.instance);
            for (LeaderAndIsrTopicState _element : _object.topicStates) {
                _topicStatesArray.add(LeaderAndIsrTopicStateJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topicStates", _topicStatesArray);
        } else {
            if (!_object.topicStates.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topicStates at version " + _version);
            }
        }
        ArrayNode _liveLeadersArray = new ArrayNode(JsonNodeFactory.instance);
        for (LeaderAndIsrLiveLeader _element : _object.liveLeaders) {
            _liveLeadersArray.add(LeaderAndIsrLiveLeaderJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("liveLeaders", _liveLeadersArray);
        return _node;
    }
    public static JsonNode write(LeaderAndIsrRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class LeaderAndIsrLiveLeaderJsonConverter {
        public static LeaderAndIsrLiveLeader read(JsonNode _node, short _version) {
            LeaderAndIsrLiveLeader _object = new LeaderAndIsrLiveLeader();
            JsonNode _brokerIdNode = _node.get("brokerId");
            if (_brokerIdNode == null) {
                throw new RuntimeException("LeaderAndIsrLiveLeader: unable to locate field 'brokerId', which is mandatory in version " + _version);
            } else {
                _object.brokerId = MessageUtil.jsonNodeToInt(_brokerIdNode, "LeaderAndIsrLiveLeader");
            }
            JsonNode _hostNameNode = _node.get("hostName");
            if (_hostNameNode == null) {
                throw new RuntimeException("LeaderAndIsrLiveLeader: unable to locate field 'hostName', which is mandatory in version " + _version);
            } else {
                if (!_hostNameNode.isTextual()) {
                    throw new RuntimeException("LeaderAndIsrLiveLeader expected a string type, but got " + _node.getNodeType());
                }
                _object.hostName = _hostNameNode.asText();
            }
            JsonNode _portNode = _node.get("port");
            if (_portNode == null) {
                throw new RuntimeException("LeaderAndIsrLiveLeader: unable to locate field 'port', which is mandatory in version " + _version);
            } else {
                _object.port = MessageUtil.jsonNodeToInt(_portNode, "LeaderAndIsrLiveLeader");
            }
            return _object;
        }
        public static JsonNode write(LeaderAndIsrLiveLeader _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("brokerId", new IntNode(_object.brokerId));
            _node.set("hostName", new TextNode(_object.hostName));
            _node.set("port", new IntNode(_object.port));
            return _node;
        }
        public static JsonNode write(LeaderAndIsrLiveLeader _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class LeaderAndIsrPartitionStateJsonConverter {
        public static LeaderAndIsrPartitionState read(JsonNode _node, short _version) {
            LeaderAndIsrPartitionState _object = new LeaderAndIsrPartitionState();
            JsonNode _topicNameNode = _node.get("topicName");
            if (_topicNameNode == null) {
                if (_version <= 1) {
                    throw new RuntimeException("LeaderAndIsrPartitionState: unable to locate field 'topicName', which is mandatory in version " + _version);
                } else {
                    _object.topicName = "";
                }
            } else {
                if (!_topicNameNode.isTextual()) {
                    throw new RuntimeException("LeaderAndIsrPartitionState expected a string type, but got " + _node.getNodeType());
                }
                _object.topicName = _topicNameNode.asText();
            }
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("LeaderAndIsrPartitionState: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "LeaderAndIsrPartitionState");
            }
            JsonNode _controllerEpochNode = _node.get("controllerEpoch");
            if (_controllerEpochNode == null) {
                throw new RuntimeException("LeaderAndIsrPartitionState: unable to locate field 'controllerEpoch', which is mandatory in version " + _version);
            } else {
                _object.controllerEpoch = MessageUtil.jsonNodeToInt(_controllerEpochNode, "LeaderAndIsrPartitionState");
            }
            JsonNode _leaderNode = _node.get("leader");
            if (_leaderNode == null) {
                throw new RuntimeException("LeaderAndIsrPartitionState: unable to locate field 'leader', which is mandatory in version " + _version);
            } else {
                _object.leader = MessageUtil.jsonNodeToInt(_leaderNode, "LeaderAndIsrPartitionState");
            }
            JsonNode _leaderEpochNode = _node.get("leaderEpoch");
            if (_leaderEpochNode == null) {
                throw new RuntimeException("LeaderAndIsrPartitionState: unable to locate field 'leaderEpoch', which is mandatory in version " + _version);
            } else {
                _object.leaderEpoch = MessageUtil.jsonNodeToInt(_leaderEpochNode, "LeaderAndIsrPartitionState");
            }
            JsonNode _isrNode = _node.get("isr");
            if (_isrNode == null) {
                throw new RuntimeException("LeaderAndIsrPartitionState: unable to locate field 'isr', which is mandatory in version " + _version);
            } else {
                if (!_isrNode.isArray()) {
                    throw new RuntimeException("LeaderAndIsrPartitionState expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_isrNode.size());
                _object.isr = _collection;
                for (JsonNode _element : _isrNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "LeaderAndIsrPartitionState element"));
                }
            }
            JsonNode _zkVersionNode = _node.get("zkVersion");
            if (_zkVersionNode == null) {
                throw new RuntimeException("LeaderAndIsrPartitionState: unable to locate field 'zkVersion', which is mandatory in version " + _version);
            } else {
                _object.zkVersion = MessageUtil.jsonNodeToInt(_zkVersionNode, "LeaderAndIsrPartitionState");
            }
            JsonNode _replicasNode = _node.get("replicas");
            if (_replicasNode == null) {
                throw new RuntimeException("LeaderAndIsrPartitionState: unable to locate field 'replicas', which is mandatory in version " + _version);
            } else {
                if (!_replicasNode.isArray()) {
                    throw new RuntimeException("LeaderAndIsrPartitionState expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_replicasNode.size());
                _object.replicas = _collection;
                for (JsonNode _element : _replicasNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "LeaderAndIsrPartitionState element"));
                }
            }
            JsonNode _addingReplicasNode = _node.get("addingReplicas");
            if (_addingReplicasNode == null) {
                if (_version >= 3) {
                    throw new RuntimeException("LeaderAndIsrPartitionState: unable to locate field 'addingReplicas', which is mandatory in version " + _version);
                } else {
                    _object.addingReplicas = new ArrayList<Integer>(0);
                }
            } else {
                if (!_addingReplicasNode.isArray()) {
                    throw new RuntimeException("LeaderAndIsrPartitionState expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_addingReplicasNode.size());
                _object.addingReplicas = _collection;
                for (JsonNode _element : _addingReplicasNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "LeaderAndIsrPartitionState element"));
                }
            }
            JsonNode _removingReplicasNode = _node.get("removingReplicas");
            if (_removingReplicasNode == null) {
                if (_version >= 3) {
                    throw new RuntimeException("LeaderAndIsrPartitionState: unable to locate field 'removingReplicas', which is mandatory in version " + _version);
                } else {
                    _object.removingReplicas = new ArrayList<Integer>(0);
                }
            } else {
                if (!_removingReplicasNode.isArray()) {
                    throw new RuntimeException("LeaderAndIsrPartitionState expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_removingReplicasNode.size());
                _object.removingReplicas = _collection;
                for (JsonNode _element : _removingReplicasNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "LeaderAndIsrPartitionState element"));
                }
            }
            JsonNode _isNewNode = _node.get("isNew");
            if (_isNewNode == null) {
                if (_version >= 1) {
                    throw new RuntimeException("LeaderAndIsrPartitionState: unable to locate field 'isNew', which is mandatory in version " + _version);
                } else {
                    _object.isNew = false;
                }
            } else {
                if (!_isNewNode.isBoolean()) {
                    throw new RuntimeException("LeaderAndIsrPartitionState expected Boolean type, but got " + _node.getNodeType());
                }
                _object.isNew = _isNewNode.asBoolean();
            }
            return _object;
        }
        public static JsonNode write(LeaderAndIsrPartitionState _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            if (_version <= 1) {
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
            if (_version >= 3) {
                ArrayNode _addingReplicasArray = new ArrayNode(JsonNodeFactory.instance);
                for (Integer _element : _object.addingReplicas) {
                    _addingReplicasArray.add(new IntNode(_element));
                }
                _node.set("addingReplicas", _addingReplicasArray);
            }
            if (_version >= 3) {
                ArrayNode _removingReplicasArray = new ArrayNode(JsonNodeFactory.instance);
                for (Integer _element : _object.removingReplicas) {
                    _removingReplicasArray.add(new IntNode(_element));
                }
                _node.set("removingReplicas", _removingReplicasArray);
            }
            if (_version >= 1) {
                _node.set("isNew", BooleanNode.valueOf(_object.isNew));
            }
            return _node;
        }
        public static JsonNode write(LeaderAndIsrPartitionState _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class LeaderAndIsrTopicStateJsonConverter {
        public static LeaderAndIsrTopicState read(JsonNode _node, short _version) {
            LeaderAndIsrTopicState _object = new LeaderAndIsrTopicState();
            if (_version < 2) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of LeaderAndIsrTopicState");
            }
            JsonNode _topicNameNode = _node.get("topicName");
            if (_topicNameNode == null) {
                throw new RuntimeException("LeaderAndIsrTopicState: unable to locate field 'topicName', which is mandatory in version " + _version);
            } else {
                if (!_topicNameNode.isTextual()) {
                    throw new RuntimeException("LeaderAndIsrTopicState expected a string type, but got " + _node.getNodeType());
                }
                _object.topicName = _topicNameNode.asText();
            }
            JsonNode _topicIdNode = _node.get("topicId");
            if (_topicIdNode == null) {
                if (_version >= 5) {
                    throw new RuntimeException("LeaderAndIsrTopicState: unable to locate field 'topicId', which is mandatory in version " + _version);
                } else {
                    _object.topicId = Uuid.ZERO_UUID;
                }
            } else {
                if (!_topicIdNode.isTextual()) {
                    throw new RuntimeException("LeaderAndIsrTopicState expected a JSON string type, but got " + _node.getNodeType());
                }
                _object.topicId = Uuid.fromString(_topicIdNode.asText());
            }
            JsonNode _partitionStatesNode = _node.get("partitionStates");
            if (_partitionStatesNode == null) {
                throw new RuntimeException("LeaderAndIsrTopicState: unable to locate field 'partitionStates', which is mandatory in version " + _version);
            } else {
                if (!_partitionStatesNode.isArray()) {
                    throw new RuntimeException("LeaderAndIsrTopicState expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<LeaderAndIsrPartitionState> _collection = new ArrayList<LeaderAndIsrPartitionState>(_partitionStatesNode.size());
                _object.partitionStates = _collection;
                for (JsonNode _element : _partitionStatesNode) {
                    _collection.add(LeaderAndIsrPartitionStateJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(LeaderAndIsrTopicState _object, short _version, boolean _serializeRecords) {
            if (_version < 2) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of LeaderAndIsrTopicState");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topicName", new TextNode(_object.topicName));
            if (_version >= 5) {
                _node.set("topicId", new TextNode(_object.topicId.toString()));
            }
            ArrayNode _partitionStatesArray = new ArrayNode(JsonNodeFactory.instance);
            for (LeaderAndIsrPartitionState _element : _object.partitionStates) {
                _partitionStatesArray.add(LeaderAndIsrPartitionStateJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitionStates", _partitionStatesArray);
            return _node;
        }
        public static JsonNode write(LeaderAndIsrTopicState _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
