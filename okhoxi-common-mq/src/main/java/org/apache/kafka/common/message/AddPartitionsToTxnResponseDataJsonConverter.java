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
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.AddPartitionsToTxnResponseData.*;

public class AddPartitionsToTxnResponseDataJsonConverter {
    public static AddPartitionsToTxnResponseData read(JsonNode _node, short _version) {
        AddPartitionsToTxnResponseData _object = new AddPartitionsToTxnResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("AddPartitionsToTxnResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "AddPartitionsToTxnResponseData");
        }
        JsonNode _resultsNode = _node.get("results");
        if (_resultsNode == null) {
            throw new RuntimeException("AddPartitionsToTxnResponseData: unable to locate field 'results', which is mandatory in version " + _version);
        } else {
            if (!_resultsNode.isArray()) {
                throw new RuntimeException("AddPartitionsToTxnResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            AddPartitionsToTxnTopicResultCollection _collection = new AddPartitionsToTxnTopicResultCollection(_resultsNode.size());
            _object.results = _collection;
            for (JsonNode _element : _resultsNode) {
                _collection.add(AddPartitionsToTxnTopicResultJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(AddPartitionsToTxnResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        ArrayNode _resultsArray = new ArrayNode(JsonNodeFactory.instance);
        for (AddPartitionsToTxnTopicResult _element : _object.results) {
            _resultsArray.add(AddPartitionsToTxnTopicResultJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("results", _resultsArray);
        return _node;
    }
    public static JsonNode write(AddPartitionsToTxnResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class AddPartitionsToTxnPartitionResultJsonConverter {
        public static AddPartitionsToTxnPartitionResult read(JsonNode _node, short _version) {
            AddPartitionsToTxnPartitionResult _object = new AddPartitionsToTxnPartitionResult();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("AddPartitionsToTxnPartitionResult: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "AddPartitionsToTxnPartitionResult");
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("AddPartitionsToTxnPartitionResult: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "AddPartitionsToTxnPartitionResult");
            }
            return _object;
        }
        public static JsonNode write(AddPartitionsToTxnPartitionResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            return _node;
        }
        public static JsonNode write(AddPartitionsToTxnPartitionResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class AddPartitionsToTxnTopicResultJsonConverter {
        public static AddPartitionsToTxnTopicResult read(JsonNode _node, short _version) {
            AddPartitionsToTxnTopicResult _object = new AddPartitionsToTxnTopicResult();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("AddPartitionsToTxnTopicResult: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("AddPartitionsToTxnTopicResult expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _resultsNode = _node.get("results");
            if (_resultsNode == null) {
                throw new RuntimeException("AddPartitionsToTxnTopicResult: unable to locate field 'results', which is mandatory in version " + _version);
            } else {
                if (!_resultsNode.isArray()) {
                    throw new RuntimeException("AddPartitionsToTxnTopicResult expected a JSON array, but got " + _node.getNodeType());
                }
                AddPartitionsToTxnPartitionResultCollection _collection = new AddPartitionsToTxnPartitionResultCollection(_resultsNode.size());
                _object.results = _collection;
                for (JsonNode _element : _resultsNode) {
                    _collection.add(AddPartitionsToTxnPartitionResultJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(AddPartitionsToTxnTopicResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _resultsArray = new ArrayNode(JsonNodeFactory.instance);
            for (AddPartitionsToTxnPartitionResult _element : _object.results) {
                _resultsArray.add(AddPartitionsToTxnPartitionResultJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("results", _resultsArray);
            return _node;
        }
        public static JsonNode write(AddPartitionsToTxnTopicResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
