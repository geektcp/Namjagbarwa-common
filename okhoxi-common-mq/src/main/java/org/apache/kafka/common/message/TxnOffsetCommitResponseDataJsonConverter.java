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

import static org.apache.kafka.common.message.TxnOffsetCommitResponseData.*;

public class TxnOffsetCommitResponseDataJsonConverter {
    public static TxnOffsetCommitResponseData read(JsonNode _node, short _version) {
        TxnOffsetCommitResponseData _object = new TxnOffsetCommitResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("TxnOffsetCommitResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "TxnOffsetCommitResponseData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("TxnOffsetCommitResponseData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("TxnOffsetCommitResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<TxnOffsetCommitResponseTopic> _collection = new ArrayList<TxnOffsetCommitResponseTopic>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(TxnOffsetCommitResponseTopicJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(TxnOffsetCommitResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (TxnOffsetCommitResponseTopic _element : _object.topics) {
            _topicsArray.add(TxnOffsetCommitResponseTopicJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        return _node;
    }
    public static JsonNode write(TxnOffsetCommitResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class TxnOffsetCommitResponsePartitionJsonConverter {
        public static TxnOffsetCommitResponsePartition read(JsonNode _node, short _version) {
            TxnOffsetCommitResponsePartition _object = new TxnOffsetCommitResponsePartition();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("TxnOffsetCommitResponsePartition: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "TxnOffsetCommitResponsePartition");
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("TxnOffsetCommitResponsePartition: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "TxnOffsetCommitResponsePartition");
            }
            return _object;
        }
        public static JsonNode write(TxnOffsetCommitResponsePartition _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            return _node;
        }
        public static JsonNode write(TxnOffsetCommitResponsePartition _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class TxnOffsetCommitResponseTopicJsonConverter {
        public static TxnOffsetCommitResponseTopic read(JsonNode _node, short _version) {
            TxnOffsetCommitResponseTopic _object = new TxnOffsetCommitResponseTopic();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("TxnOffsetCommitResponseTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("TxnOffsetCommitResponseTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("TxnOffsetCommitResponseTopic: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("TxnOffsetCommitResponseTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<TxnOffsetCommitResponsePartition> _collection = new ArrayList<TxnOffsetCommitResponsePartition>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(TxnOffsetCommitResponsePartitionJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(TxnOffsetCommitResponseTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (TxnOffsetCommitResponsePartition _element : _object.partitions) {
                _partitionsArray.add(TxnOffsetCommitResponsePartitionJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(TxnOffsetCommitResponseTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
