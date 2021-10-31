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
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.OffsetCommitRequestData.*;

public class OffsetCommitRequestDataJsonConverter {
    public static OffsetCommitRequestData read(JsonNode _node, short _version) {
        OffsetCommitRequestData _object = new OffsetCommitRequestData();
        JsonNode _groupIdNode = _node.get("groupId");
        if (_groupIdNode == null) {
            throw new RuntimeException("OffsetCommitRequestData: unable to locate field 'groupId', which is mandatory in version " + _version);
        } else {
            if (!_groupIdNode.isTextual()) {
                throw new RuntimeException("OffsetCommitRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.groupId = _groupIdNode.asText();
        }
        JsonNode _generationIdNode = _node.get("generationId");
        if (_generationIdNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("OffsetCommitRequestData: unable to locate field 'generationId', which is mandatory in version " + _version);
            } else {
                _object.generationId = -1;
            }
        } else {
            _object.generationId = MessageUtil.jsonNodeToInt(_generationIdNode, "OffsetCommitRequestData");
        }
        JsonNode _memberIdNode = _node.get("memberId");
        if (_memberIdNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("OffsetCommitRequestData: unable to locate field 'memberId', which is mandatory in version " + _version);
            } else {
                _object.memberId = "";
            }
        } else {
            if (!_memberIdNode.isTextual()) {
                throw new RuntimeException("OffsetCommitRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.memberId = _memberIdNode.asText();
        }
        JsonNode _groupInstanceIdNode = _node.get("groupInstanceId");
        if (_groupInstanceIdNode == null) {
            if (_version >= 7) {
                throw new RuntimeException("OffsetCommitRequestData: unable to locate field 'groupInstanceId', which is mandatory in version " + _version);
            } else {
                _object.groupInstanceId = null;
            }
        } else {
            if (_groupInstanceIdNode.isNull()) {
                _object.groupInstanceId = null;
            } else {
                if (!_groupInstanceIdNode.isTextual()) {
                    throw new RuntimeException("OffsetCommitRequestData expected a string type, but got " + _node.getNodeType());
                }
                _object.groupInstanceId = _groupInstanceIdNode.asText();
            }
        }
        JsonNode _retentionTimeMsNode = _node.get("retentionTimeMs");
        if (_retentionTimeMsNode == null) {
            if ((_version >= 2) && (_version <= 4)) {
                throw new RuntimeException("OffsetCommitRequestData: unable to locate field 'retentionTimeMs', which is mandatory in version " + _version);
            } else {
                _object.retentionTimeMs = -1L;
            }
        } else {
            _object.retentionTimeMs = MessageUtil.jsonNodeToLong(_retentionTimeMsNode, "OffsetCommitRequestData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("OffsetCommitRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("OffsetCommitRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<OffsetCommitRequestTopic> _collection = new ArrayList<OffsetCommitRequestTopic>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(OffsetCommitRequestTopicJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(OffsetCommitRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("groupId", new TextNode(_object.groupId));
        if (_version >= 1) {
            _node.set("generationId", new IntNode(_object.generationId));
        }
        if (_version >= 1) {
            _node.set("memberId", new TextNode(_object.memberId));
        }
        if (_version >= 7) {
            if (_object.groupInstanceId == null) {
                _node.set("groupInstanceId", NullNode.instance);
            } else {
                _node.set("groupInstanceId", new TextNode(_object.groupInstanceId));
            }
        } else {
            if (_object.groupInstanceId != null) {
                throw new UnsupportedVersionException("Attempted to write a non-default groupInstanceId at version " + _version);
            }
        }
        if ((_version >= 2) && (_version <= 4)) {
            _node.set("retentionTimeMs", new LongNode(_object.retentionTimeMs));
        }
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (OffsetCommitRequestTopic _element : _object.topics) {
            _topicsArray.add(OffsetCommitRequestTopicJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        return _node;
    }
    public static JsonNode write(OffsetCommitRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class OffsetCommitRequestPartitionJsonConverter {
        public static OffsetCommitRequestPartition read(JsonNode _node, short _version) {
            OffsetCommitRequestPartition _object = new OffsetCommitRequestPartition();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("OffsetCommitRequestPartition: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "OffsetCommitRequestPartition");
            }
            JsonNode _committedOffsetNode = _node.get("committedOffset");
            if (_committedOffsetNode == null) {
                throw new RuntimeException("OffsetCommitRequestPartition: unable to locate field 'committedOffset', which is mandatory in version " + _version);
            } else {
                _object.committedOffset = MessageUtil.jsonNodeToLong(_committedOffsetNode, "OffsetCommitRequestPartition");
            }
            JsonNode _committedLeaderEpochNode = _node.get("committedLeaderEpoch");
            if (_committedLeaderEpochNode == null) {
                if (_version >= 6) {
                    throw new RuntimeException("OffsetCommitRequestPartition: unable to locate field 'committedLeaderEpoch', which is mandatory in version " + _version);
                } else {
                    _object.committedLeaderEpoch = -1;
                }
            } else {
                _object.committedLeaderEpoch = MessageUtil.jsonNodeToInt(_committedLeaderEpochNode, "OffsetCommitRequestPartition");
            }
            JsonNode _commitTimestampNode = _node.get("commitTimestamp");
            if (_commitTimestampNode == null) {
                if ((_version >= 1) && (_version <= 1)) {
                    throw new RuntimeException("OffsetCommitRequestPartition: unable to locate field 'commitTimestamp', which is mandatory in version " + _version);
                } else {
                    _object.commitTimestamp = -1L;
                }
            } else {
                _object.commitTimestamp = MessageUtil.jsonNodeToLong(_commitTimestampNode, "OffsetCommitRequestPartition");
            }
            JsonNode _committedMetadataNode = _node.get("committedMetadata");
            if (_committedMetadataNode == null) {
                throw new RuntimeException("OffsetCommitRequestPartition: unable to locate field 'committedMetadata', which is mandatory in version " + _version);
            } else {
                if (_committedMetadataNode.isNull()) {
                    _object.committedMetadata = null;
                } else {
                    if (!_committedMetadataNode.isTextual()) {
                        throw new RuntimeException("OffsetCommitRequestPartition expected a string type, but got " + _node.getNodeType());
                    }
                    _object.committedMetadata = _committedMetadataNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(OffsetCommitRequestPartition _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("committedOffset", new LongNode(_object.committedOffset));
            if (_version >= 6) {
                _node.set("committedLeaderEpoch", new IntNode(_object.committedLeaderEpoch));
            }
            if ((_version >= 1) && (_version <= 1)) {
                _node.set("commitTimestamp", new LongNode(_object.commitTimestamp));
            } else {
                if (_object.commitTimestamp != -1L) {
                    throw new UnsupportedVersionException("Attempted to write a non-default commitTimestamp at version " + _version);
                }
            }
            if (_object.committedMetadata == null) {
                _node.set("committedMetadata", NullNode.instance);
            } else {
                _node.set("committedMetadata", new TextNode(_object.committedMetadata));
            }
            return _node;
        }
        public static JsonNode write(OffsetCommitRequestPartition _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class OffsetCommitRequestTopicJsonConverter {
        public static OffsetCommitRequestTopic read(JsonNode _node, short _version) {
            OffsetCommitRequestTopic _object = new OffsetCommitRequestTopic();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("OffsetCommitRequestTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("OffsetCommitRequestTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("OffsetCommitRequestTopic: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("OffsetCommitRequestTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<OffsetCommitRequestPartition> _collection = new ArrayList<OffsetCommitRequestPartition>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(OffsetCommitRequestPartitionJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(OffsetCommitRequestTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (OffsetCommitRequestPartition _element : _object.partitions) {
                _partitionsArray.add(OffsetCommitRequestPartitionJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(OffsetCommitRequestTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
