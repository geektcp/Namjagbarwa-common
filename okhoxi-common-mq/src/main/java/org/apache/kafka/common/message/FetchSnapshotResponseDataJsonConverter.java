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
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.record.MemoryRecords;

import static org.apache.kafka.common.message.FetchSnapshotResponseData.*;

public class FetchSnapshotResponseDataJsonConverter {
    public static FetchSnapshotResponseData read(JsonNode _node, short _version) {
        FetchSnapshotResponseData _object = new FetchSnapshotResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("FetchSnapshotResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "FetchSnapshotResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("FetchSnapshotResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "FetchSnapshotResponseData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("FetchSnapshotResponseData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("FetchSnapshotResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<TopicSnapshot> _collection = new ArrayList<TopicSnapshot>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(TopicSnapshotJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(FetchSnapshotResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        _node.set("errorCode", new ShortNode(_object.errorCode));
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (TopicSnapshot _element : _object.topics) {
            _topicsArray.add(TopicSnapshotJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        return _node;
    }
    public static JsonNode write(FetchSnapshotResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class LeaderIdAndEpochJsonConverter {
        public static LeaderIdAndEpoch read(JsonNode _node, short _version) {
            LeaderIdAndEpoch _object = new LeaderIdAndEpoch();
            JsonNode _leaderIdNode = _node.get("leaderId");
            if (_leaderIdNode == null) {
                throw new RuntimeException("LeaderIdAndEpoch: unable to locate field 'leaderId', which is mandatory in version " + _version);
            } else {
                _object.leaderId = MessageUtil.jsonNodeToInt(_leaderIdNode, "LeaderIdAndEpoch");
            }
            JsonNode _leaderEpochNode = _node.get("leaderEpoch");
            if (_leaderEpochNode == null) {
                throw new RuntimeException("LeaderIdAndEpoch: unable to locate field 'leaderEpoch', which is mandatory in version " + _version);
            } else {
                _object.leaderEpoch = MessageUtil.jsonNodeToInt(_leaderEpochNode, "LeaderIdAndEpoch");
            }
            return _object;
        }
        public static JsonNode write(LeaderIdAndEpoch _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("leaderId", new IntNode(_object.leaderId));
            _node.set("leaderEpoch", new IntNode(_object.leaderEpoch));
            return _node;
        }
        public static JsonNode write(LeaderIdAndEpoch _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class PartitionSnapshotJsonConverter {
        public static PartitionSnapshot read(JsonNode _node, short _version) {
            PartitionSnapshot _object = new PartitionSnapshot();
            JsonNode _indexNode = _node.get("index");
            if (_indexNode == null) {
                throw new RuntimeException("PartitionSnapshot: unable to locate field 'index', which is mandatory in version " + _version);
            } else {
                _object.index = MessageUtil.jsonNodeToInt(_indexNode, "PartitionSnapshot");
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("PartitionSnapshot: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "PartitionSnapshot");
            }
            JsonNode _snapshotIdNode = _node.get("snapshotId");
            if (_snapshotIdNode == null) {
                throw new RuntimeException("PartitionSnapshot: unable to locate field 'snapshotId', which is mandatory in version " + _version);
            } else {
                _object.snapshotId = SnapshotIdJsonConverter.read(_snapshotIdNode, _version);
            }
            JsonNode _currentLeaderNode = _node.get("currentLeader");
            if (_currentLeaderNode == null) {
                _object.currentLeader = new LeaderIdAndEpoch();
            } else {
                _object.currentLeader = LeaderIdAndEpochJsonConverter.read(_currentLeaderNode, _version);
            }
            JsonNode _sizeNode = _node.get("size");
            if (_sizeNode == null) {
                throw new RuntimeException("PartitionSnapshot: unable to locate field 'size', which is mandatory in version " + _version);
            } else {
                _object.size = MessageUtil.jsonNodeToLong(_sizeNode, "PartitionSnapshot");
            }
            JsonNode _positionNode = _node.get("position");
            if (_positionNode == null) {
                throw new RuntimeException("PartitionSnapshot: unable to locate field 'position', which is mandatory in version " + _version);
            } else {
                _object.position = MessageUtil.jsonNodeToLong(_positionNode, "PartitionSnapshot");
            }
            JsonNode _unalignedRecordsNode = _node.get("unalignedRecords");
            if (_unalignedRecordsNode == null) {
                throw new RuntimeException("PartitionSnapshot: unable to locate field 'unalignedRecords', which is mandatory in version " + _version);
            } else {
                _object.unalignedRecords = MemoryRecords.readableRecords(ByteBuffer.wrap(MessageUtil.jsonNodeToBinary(_unalignedRecordsNode, "PartitionSnapshot")));
            }
            return _object;
        }
        public static JsonNode write(PartitionSnapshot _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("index", new IntNode(_object.index));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            _node.set("snapshotId", SnapshotIdJsonConverter.write(_object.snapshotId, _version, _serializeRecords));
            if (!_object.currentLeader.equals(new LeaderIdAndEpoch())) {
                _node.set("currentLeader", LeaderIdAndEpochJsonConverter.write(_object.currentLeader, _version, _serializeRecords));
            }
            _node.set("size", new LongNode(_object.size));
            _node.set("position", new LongNode(_object.position));
            if (_serializeRecords) {
                _node.set("unalignedRecords", new BinaryNode(new byte[]{}));
            } else {
                _node.set("unalignedRecordsSizeInBytes", new IntNode(_object.unalignedRecords.sizeInBytes()));
            }
            return _node;
        }
        public static JsonNode write(PartitionSnapshot _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class SnapshotIdJsonConverter {
        public static SnapshotId read(JsonNode _node, short _version) {
            SnapshotId _object = new SnapshotId();
            JsonNode _endOffsetNode = _node.get("endOffset");
            if (_endOffsetNode == null) {
                throw new RuntimeException("SnapshotId: unable to locate field 'endOffset', which is mandatory in version " + _version);
            } else {
                _object.endOffset = MessageUtil.jsonNodeToLong(_endOffsetNode, "SnapshotId");
            }
            JsonNode _epochNode = _node.get("epoch");
            if (_epochNode == null) {
                throw new RuntimeException("SnapshotId: unable to locate field 'epoch', which is mandatory in version " + _version);
            } else {
                _object.epoch = MessageUtil.jsonNodeToInt(_epochNode, "SnapshotId");
            }
            return _object;
        }
        public static JsonNode write(SnapshotId _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("endOffset", new LongNode(_object.endOffset));
            _node.set("epoch", new IntNode(_object.epoch));
            return _node;
        }
        public static JsonNode write(SnapshotId _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class TopicSnapshotJsonConverter {
        public static TopicSnapshot read(JsonNode _node, short _version) {
            TopicSnapshot _object = new TopicSnapshot();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("TopicSnapshot: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("TopicSnapshot expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("TopicSnapshot: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("TopicSnapshot expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<PartitionSnapshot> _collection = new ArrayList<PartitionSnapshot>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(PartitionSnapshotJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(TopicSnapshot _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (PartitionSnapshot _element : _object.partitions) {
                _partitionsArray.add(PartitionSnapshotJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(TopicSnapshot _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
