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

import static org.apache.kafka.common.message.OffsetFetchResponseData.*;

public class OffsetFetchResponseDataJsonConverter {
    public static OffsetFetchResponseData read(JsonNode _node, short _version) {
        OffsetFetchResponseData _object = new OffsetFetchResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("OffsetFetchResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
            } else {
                _object.throttleTimeMs = 0;
            }
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "OffsetFetchResponseData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("OffsetFetchResponseData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("OffsetFetchResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<OffsetFetchResponseTopic> _collection = new ArrayList<OffsetFetchResponseTopic>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(OffsetFetchResponseTopicJsonConverter.read(_element, _version));
            }
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            if (_version >= 2) {
                throw new RuntimeException("OffsetFetchResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = (short) 0;
            }
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "OffsetFetchResponseData");
        }
        return _object;
    }
    public static JsonNode write(OffsetFetchResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 3) {
            _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        }
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (OffsetFetchResponseTopic _element : _object.topics) {
            _topicsArray.add(OffsetFetchResponseTopicJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        if (_version >= 2) {
            _node.set("errorCode", new ShortNode(_object.errorCode));
        }
        return _node;
    }
    public static JsonNode write(OffsetFetchResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class OffsetFetchResponsePartitionJsonConverter {
        public static OffsetFetchResponsePartition read(JsonNode _node, short _version) {
            OffsetFetchResponsePartition _object = new OffsetFetchResponsePartition();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("OffsetFetchResponsePartition: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "OffsetFetchResponsePartition");
            }
            JsonNode _committedOffsetNode = _node.get("committedOffset");
            if (_committedOffsetNode == null) {
                throw new RuntimeException("OffsetFetchResponsePartition: unable to locate field 'committedOffset', which is mandatory in version " + _version);
            } else {
                _object.committedOffset = MessageUtil.jsonNodeToLong(_committedOffsetNode, "OffsetFetchResponsePartition");
            }
            JsonNode _committedLeaderEpochNode = _node.get("committedLeaderEpoch");
            if (_committedLeaderEpochNode == null) {
                if (_version >= 5) {
                    throw new RuntimeException("OffsetFetchResponsePartition: unable to locate field 'committedLeaderEpoch', which is mandatory in version " + _version);
                } else {
                    _object.committedLeaderEpoch = -1;
                }
            } else {
                _object.committedLeaderEpoch = MessageUtil.jsonNodeToInt(_committedLeaderEpochNode, "OffsetFetchResponsePartition");
            }
            JsonNode _metadataNode = _node.get("metadata");
            if (_metadataNode == null) {
                throw new RuntimeException("OffsetFetchResponsePartition: unable to locate field 'metadata', which is mandatory in version " + _version);
            } else {
                if (_metadataNode.isNull()) {
                    _object.metadata = null;
                } else {
                    if (!_metadataNode.isTextual()) {
                        throw new RuntimeException("OffsetFetchResponsePartition expected a string type, but got " + _node.getNodeType());
                    }
                    _object.metadata = _metadataNode.asText();
                }
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("OffsetFetchResponsePartition: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "OffsetFetchResponsePartition");
            }
            return _object;
        }
        public static JsonNode write(OffsetFetchResponsePartition _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("committedOffset", new LongNode(_object.committedOffset));
            if (_version >= 5) {
                _node.set("committedLeaderEpoch", new IntNode(_object.committedLeaderEpoch));
            }
            if (_object.metadata == null) {
                _node.set("metadata", NullNode.instance);
            } else {
                _node.set("metadata", new TextNode(_object.metadata));
            }
            _node.set("errorCode", new ShortNode(_object.errorCode));
            return _node;
        }
        public static JsonNode write(OffsetFetchResponsePartition _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class OffsetFetchResponseTopicJsonConverter {
        public static OffsetFetchResponseTopic read(JsonNode _node, short _version) {
            OffsetFetchResponseTopic _object = new OffsetFetchResponseTopic();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("OffsetFetchResponseTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("OffsetFetchResponseTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("OffsetFetchResponseTopic: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("OffsetFetchResponseTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<OffsetFetchResponsePartition> _collection = new ArrayList<OffsetFetchResponsePartition>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(OffsetFetchResponsePartitionJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(OffsetFetchResponseTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (OffsetFetchResponsePartition _element : _object.partitions) {
                _partitionsArray.add(OffsetFetchResponsePartitionJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(OffsetFetchResponseTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
