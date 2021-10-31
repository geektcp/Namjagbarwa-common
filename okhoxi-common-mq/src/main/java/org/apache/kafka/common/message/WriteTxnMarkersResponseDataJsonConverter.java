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
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.WriteTxnMarkersResponseData.*;

public class WriteTxnMarkersResponseDataJsonConverter {
    public static WriteTxnMarkersResponseData read(JsonNode _node, short _version) {
        WriteTxnMarkersResponseData _object = new WriteTxnMarkersResponseData();
        JsonNode _markersNode = _node.get("markers");
        if (_markersNode == null) {
            throw new RuntimeException("WriteTxnMarkersResponseData: unable to locate field 'markers', which is mandatory in version " + _version);
        } else {
            if (!_markersNode.isArray()) {
                throw new RuntimeException("WriteTxnMarkersResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<WritableTxnMarkerResult> _collection = new ArrayList<WritableTxnMarkerResult>(_markersNode.size());
            _object.markers = _collection;
            for (JsonNode _element : _markersNode) {
                _collection.add(WritableTxnMarkerResultJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(WriteTxnMarkersResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _markersArray = new ArrayNode(JsonNodeFactory.instance);
        for (WritableTxnMarkerResult _element : _object.markers) {
            _markersArray.add(WritableTxnMarkerResultJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("markers", _markersArray);
        return _node;
    }
    public static JsonNode write(WriteTxnMarkersResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class WritableTxnMarkerPartitionResultJsonConverter {
        public static WritableTxnMarkerPartitionResult read(JsonNode _node, short _version) {
            WritableTxnMarkerPartitionResult _object = new WritableTxnMarkerPartitionResult();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("WritableTxnMarkerPartitionResult: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "WritableTxnMarkerPartitionResult");
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("WritableTxnMarkerPartitionResult: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "WritableTxnMarkerPartitionResult");
            }
            return _object;
        }
        public static JsonNode write(WritableTxnMarkerPartitionResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            return _node;
        }
        public static JsonNode write(WritableTxnMarkerPartitionResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class WritableTxnMarkerResultJsonConverter {
        public static WritableTxnMarkerResult read(JsonNode _node, short _version) {
            WritableTxnMarkerResult _object = new WritableTxnMarkerResult();
            JsonNode _producerIdNode = _node.get("producerId");
            if (_producerIdNode == null) {
                throw new RuntimeException("WritableTxnMarkerResult: unable to locate field 'producerId', which is mandatory in version " + _version);
            } else {
                _object.producerId = MessageUtil.jsonNodeToLong(_producerIdNode, "WritableTxnMarkerResult");
            }
            JsonNode _topicsNode = _node.get("topics");
            if (_topicsNode == null) {
                throw new RuntimeException("WritableTxnMarkerResult: unable to locate field 'topics', which is mandatory in version " + _version);
            } else {
                if (!_topicsNode.isArray()) {
                    throw new RuntimeException("WritableTxnMarkerResult expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<WritableTxnMarkerTopicResult> _collection = new ArrayList<WritableTxnMarkerTopicResult>(_topicsNode.size());
                _object.topics = _collection;
                for (JsonNode _element : _topicsNode) {
                    _collection.add(WritableTxnMarkerTopicResultJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(WritableTxnMarkerResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("producerId", new LongNode(_object.producerId));
            ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
            for (WritableTxnMarkerTopicResult _element : _object.topics) {
                _topicsArray.add(WritableTxnMarkerTopicResultJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topics", _topicsArray);
            return _node;
        }
        public static JsonNode write(WritableTxnMarkerResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class WritableTxnMarkerTopicResultJsonConverter {
        public static WritableTxnMarkerTopicResult read(JsonNode _node, short _version) {
            WritableTxnMarkerTopicResult _object = new WritableTxnMarkerTopicResult();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("WritableTxnMarkerTopicResult: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("WritableTxnMarkerTopicResult expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("WritableTxnMarkerTopicResult: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("WritableTxnMarkerTopicResult expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<WritableTxnMarkerPartitionResult> _collection = new ArrayList<WritableTxnMarkerPartitionResult>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(WritableTxnMarkerPartitionResultJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(WritableTxnMarkerTopicResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (WritableTxnMarkerPartitionResult _element : _object.partitions) {
                _partitionsArray.add(WritableTxnMarkerPartitionResultJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(WritableTxnMarkerTopicResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
