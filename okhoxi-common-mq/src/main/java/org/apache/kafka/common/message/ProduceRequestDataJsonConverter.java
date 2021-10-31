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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.record.MemoryRecords;

import static org.apache.kafka.common.message.ProduceRequestData.*;

public class ProduceRequestDataJsonConverter {
    public static ProduceRequestData read(JsonNode _node, short _version) {
        ProduceRequestData _object = new ProduceRequestData();
        JsonNode _transactionalIdNode = _node.get("transactionalId");
        if (_transactionalIdNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("ProduceRequestData: unable to locate field 'transactionalId', which is mandatory in version " + _version);
            } else {
                _object.transactionalId = null;
            }
        } else {
            if (_transactionalIdNode.isNull()) {
                _object.transactionalId = null;
            } else {
                if (!_transactionalIdNode.isTextual()) {
                    throw new RuntimeException("ProduceRequestData expected a string type, but got " + _node.getNodeType());
                }
                _object.transactionalId = _transactionalIdNode.asText();
            }
        }
        JsonNode _acksNode = _node.get("acks");
        if (_acksNode == null) {
            throw new RuntimeException("ProduceRequestData: unable to locate field 'acks', which is mandatory in version " + _version);
        } else {
            _object.acks = MessageUtil.jsonNodeToShort(_acksNode, "ProduceRequestData");
        }
        JsonNode _timeoutMsNode = _node.get("timeoutMs");
        if (_timeoutMsNode == null) {
            throw new RuntimeException("ProduceRequestData: unable to locate field 'timeoutMs', which is mandatory in version " + _version);
        } else {
            _object.timeoutMs = MessageUtil.jsonNodeToInt(_timeoutMsNode, "ProduceRequestData");
        }
        JsonNode _topicDataNode = _node.get("topicData");
        if (_topicDataNode == null) {
            throw new RuntimeException("ProduceRequestData: unable to locate field 'topicData', which is mandatory in version " + _version);
        } else {
            if (!_topicDataNode.isArray()) {
                throw new RuntimeException("ProduceRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            TopicProduceDataCollection _collection = new TopicProduceDataCollection(_topicDataNode.size());
            _object.topicData = _collection;
            for (JsonNode _element : _topicDataNode) {
                _collection.add(TopicProduceDataJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(ProduceRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 3) {
            if (_object.transactionalId == null) {
                _node.set("transactionalId", NullNode.instance);
            } else {
                _node.set("transactionalId", new TextNode(_object.transactionalId));
            }
        } else {
            if (_object.transactionalId != null) {
                throw new UnsupportedVersionException("Attempted to write a non-default transactionalId at version " + _version);
            }
        }
        _node.set("acks", new ShortNode(_object.acks));
        _node.set("timeoutMs", new IntNode(_object.timeoutMs));
        ArrayNode _topicDataArray = new ArrayNode(JsonNodeFactory.instance);
        for (TopicProduceData _element : _object.topicData) {
            _topicDataArray.add(TopicProduceDataJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topicData", _topicDataArray);
        return _node;
    }
    public static JsonNode write(ProduceRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class PartitionProduceDataJsonConverter {
        public static PartitionProduceData read(JsonNode _node, short _version) {
            PartitionProduceData _object = new PartitionProduceData();
            JsonNode _indexNode = _node.get("index");
            if (_indexNode == null) {
                throw new RuntimeException("PartitionProduceData: unable to locate field 'index', which is mandatory in version " + _version);
            } else {
                _object.index = MessageUtil.jsonNodeToInt(_indexNode, "PartitionProduceData");
            }
            JsonNode _recordsNode = _node.get("records");
            if (_recordsNode == null) {
                throw new RuntimeException("PartitionProduceData: unable to locate field 'records', which is mandatory in version " + _version);
            } else {
                if (_recordsNode.isNull()) {
                    _object.records = null;
                } else {
                    _object.records = MemoryRecords.readableRecords(ByteBuffer.wrap(MessageUtil.jsonNodeToBinary(_recordsNode, "PartitionProduceData")));
                }
            }
            return _object;
        }
        public static JsonNode write(PartitionProduceData _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("index", new IntNode(_object.index));
            if (_object.records == null) {
                _node.set("records", NullNode.instance);
            } else {
                if (_serializeRecords) {
                    _node.set("records", new BinaryNode(new byte[]{}));
                } else {
                    _node.set("recordsSizeInBytes", new IntNode(_object.records.sizeInBytes()));
                }
            }
            return _node;
        }
        public static JsonNode write(PartitionProduceData _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class TopicProduceDataJsonConverter {
        public static TopicProduceData read(JsonNode _node, short _version) {
            TopicProduceData _object = new TopicProduceData();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("TopicProduceData: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("TopicProduceData expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionDataNode = _node.get("partitionData");
            if (_partitionDataNode == null) {
                throw new RuntimeException("TopicProduceData: unable to locate field 'partitionData', which is mandatory in version " + _version);
            } else {
                if (!_partitionDataNode.isArray()) {
                    throw new RuntimeException("TopicProduceData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<PartitionProduceData> _collection = new ArrayList<PartitionProduceData>(_partitionDataNode.size());
                _object.partitionData = _collection;
                for (JsonNode _element : _partitionDataNode) {
                    _collection.add(PartitionProduceDataJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(TopicProduceData _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionDataArray = new ArrayNode(JsonNodeFactory.instance);
            for (PartitionProduceData _element : _object.partitionData) {
                _partitionDataArray.add(PartitionProduceDataJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitionData", _partitionDataArray);
            return _node;
        }
        public static JsonNode write(TopicProduceData _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
