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
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DeleteRecordsRequestData.*;

public class DeleteRecordsRequestDataJsonConverter {
    public static DeleteRecordsRequestData read(JsonNode _node, short _version) {
        DeleteRecordsRequestData _object = new DeleteRecordsRequestData();
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("DeleteRecordsRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("DeleteRecordsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<DeleteRecordsTopic> _collection = new ArrayList<DeleteRecordsTopic>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(DeleteRecordsTopicJsonConverter.read(_element, _version));
            }
        }
        JsonNode _timeoutMsNode = _node.get("timeoutMs");
        if (_timeoutMsNode == null) {
            throw new RuntimeException("DeleteRecordsRequestData: unable to locate field 'timeoutMs', which is mandatory in version " + _version);
        } else {
            _object.timeoutMs = MessageUtil.jsonNodeToInt(_timeoutMsNode, "DeleteRecordsRequestData");
        }
        return _object;
    }
    public static JsonNode write(DeleteRecordsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (DeleteRecordsTopic _element : _object.topics) {
            _topicsArray.add(DeleteRecordsTopicJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        _node.set("timeoutMs", new IntNode(_object.timeoutMs));
        return _node;
    }
    public static JsonNode write(DeleteRecordsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DeleteRecordsPartitionJsonConverter {
        public static DeleteRecordsPartition read(JsonNode _node, short _version) {
            DeleteRecordsPartition _object = new DeleteRecordsPartition();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("DeleteRecordsPartition: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "DeleteRecordsPartition");
            }
            JsonNode _offsetNode = _node.get("offset");
            if (_offsetNode == null) {
                throw new RuntimeException("DeleteRecordsPartition: unable to locate field 'offset', which is mandatory in version " + _version);
            } else {
                _object.offset = MessageUtil.jsonNodeToLong(_offsetNode, "DeleteRecordsPartition");
            }
            return _object;
        }
        public static JsonNode write(DeleteRecordsPartition _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("offset", new LongNode(_object.offset));
            return _node;
        }
        public static JsonNode write(DeleteRecordsPartition _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class DeleteRecordsTopicJsonConverter {
        public static DeleteRecordsTopic read(JsonNode _node, short _version) {
            DeleteRecordsTopic _object = new DeleteRecordsTopic();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("DeleteRecordsTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("DeleteRecordsTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("DeleteRecordsTopic: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("DeleteRecordsTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<DeleteRecordsPartition> _collection = new ArrayList<DeleteRecordsPartition>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(DeleteRecordsPartitionJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(DeleteRecordsTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (DeleteRecordsPartition _element : _object.partitions) {
                _partitionsArray.add(DeleteRecordsPartitionJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(DeleteRecordsTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
