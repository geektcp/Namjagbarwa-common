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
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.WriteTxnMarkersRequestData.*;

public class WriteTxnMarkersRequestDataJsonConverter {
    public static WriteTxnMarkersRequestData read(JsonNode _node, short _version) {
        WriteTxnMarkersRequestData _object = new WriteTxnMarkersRequestData();
        JsonNode _markersNode = _node.get("markers");
        if (_markersNode == null) {
            throw new RuntimeException("WriteTxnMarkersRequestData: unable to locate field 'markers', which is mandatory in version " + _version);
        } else {
            if (!_markersNode.isArray()) {
                throw new RuntimeException("WriteTxnMarkersRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<WritableTxnMarker> _collection = new ArrayList<WritableTxnMarker>(_markersNode.size());
            _object.markers = _collection;
            for (JsonNode _element : _markersNode) {
                _collection.add(WritableTxnMarkerJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(WriteTxnMarkersRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _markersArray = new ArrayNode(JsonNodeFactory.instance);
        for (WritableTxnMarker _element : _object.markers) {
            _markersArray.add(WritableTxnMarkerJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("markers", _markersArray);
        return _node;
    }
    public static JsonNode write(WriteTxnMarkersRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class WritableTxnMarkerJsonConverter {
        public static WritableTxnMarker read(JsonNode _node, short _version) {
            WritableTxnMarker _object = new WritableTxnMarker();
            JsonNode _producerIdNode = _node.get("producerId");
            if (_producerIdNode == null) {
                throw new RuntimeException("WritableTxnMarker: unable to locate field 'producerId', which is mandatory in version " + _version);
            } else {
                _object.producerId = MessageUtil.jsonNodeToLong(_producerIdNode, "WritableTxnMarker");
            }
            JsonNode _producerEpochNode = _node.get("producerEpoch");
            if (_producerEpochNode == null) {
                throw new RuntimeException("WritableTxnMarker: unable to locate field 'producerEpoch', which is mandatory in version " + _version);
            } else {
                _object.producerEpoch = MessageUtil.jsonNodeToShort(_producerEpochNode, "WritableTxnMarker");
            }
            JsonNode _transactionResultNode = _node.get("transactionResult");
            if (_transactionResultNode == null) {
                throw new RuntimeException("WritableTxnMarker: unable to locate field 'transactionResult', which is mandatory in version " + _version);
            } else {
                if (!_transactionResultNode.isBoolean()) {
                    throw new RuntimeException("WritableTxnMarker expected Boolean type, but got " + _node.getNodeType());
                }
                _object.transactionResult = _transactionResultNode.asBoolean();
            }
            JsonNode _topicsNode = _node.get("topics");
            if (_topicsNode == null) {
                throw new RuntimeException("WritableTxnMarker: unable to locate field 'topics', which is mandatory in version " + _version);
            } else {
                if (!_topicsNode.isArray()) {
                    throw new RuntimeException("WritableTxnMarker expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<WritableTxnMarkerTopic> _collection = new ArrayList<WritableTxnMarkerTopic>(_topicsNode.size());
                _object.topics = _collection;
                for (JsonNode _element : _topicsNode) {
                    _collection.add(WritableTxnMarkerTopicJsonConverter.read(_element, _version));
                }
            }
            JsonNode _coordinatorEpochNode = _node.get("coordinatorEpoch");
            if (_coordinatorEpochNode == null) {
                throw new RuntimeException("WritableTxnMarker: unable to locate field 'coordinatorEpoch', which is mandatory in version " + _version);
            } else {
                _object.coordinatorEpoch = MessageUtil.jsonNodeToInt(_coordinatorEpochNode, "WritableTxnMarker");
            }
            return _object;
        }
        public static JsonNode write(WritableTxnMarker _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("producerId", new LongNode(_object.producerId));
            _node.set("producerEpoch", new ShortNode(_object.producerEpoch));
            _node.set("transactionResult", BooleanNode.valueOf(_object.transactionResult));
            ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
            for (WritableTxnMarkerTopic _element : _object.topics) {
                _topicsArray.add(WritableTxnMarkerTopicJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topics", _topicsArray);
            _node.set("coordinatorEpoch", new IntNode(_object.coordinatorEpoch));
            return _node;
        }
        public static JsonNode write(WritableTxnMarker _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class WritableTxnMarkerTopicJsonConverter {
        public static WritableTxnMarkerTopic read(JsonNode _node, short _version) {
            WritableTxnMarkerTopic _object = new WritableTxnMarkerTopic();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("WritableTxnMarkerTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("WritableTxnMarkerTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionIndexesNode = _node.get("partitionIndexes");
            if (_partitionIndexesNode == null) {
                throw new RuntimeException("WritableTxnMarkerTopic: unable to locate field 'partitionIndexes', which is mandatory in version " + _version);
            } else {
                if (!_partitionIndexesNode.isArray()) {
                    throw new RuntimeException("WritableTxnMarkerTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_partitionIndexesNode.size());
                _object.partitionIndexes = _collection;
                for (JsonNode _element : _partitionIndexesNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "WritableTxnMarkerTopic element"));
                }
            }
            return _object;
        }
        public static JsonNode write(WritableTxnMarkerTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionIndexesArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.partitionIndexes) {
                _partitionIndexesArray.add(new IntNode(_element));
            }
            _node.set("partitionIndexes", _partitionIndexesArray);
            return _node;
        }
        public static JsonNode write(WritableTxnMarkerTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
