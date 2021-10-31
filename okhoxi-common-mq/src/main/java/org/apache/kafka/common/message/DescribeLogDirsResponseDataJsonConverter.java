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

import static org.apache.kafka.common.message.DescribeLogDirsResponseData.*;

public class DescribeLogDirsResponseDataJsonConverter {
    public static DescribeLogDirsResponseData read(JsonNode _node, short _version) {
        DescribeLogDirsResponseData _object = new DescribeLogDirsResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("DescribeLogDirsResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "DescribeLogDirsResponseData");
        }
        JsonNode _resultsNode = _node.get("results");
        if (_resultsNode == null) {
            throw new RuntimeException("DescribeLogDirsResponseData: unable to locate field 'results', which is mandatory in version " + _version);
        } else {
            if (!_resultsNode.isArray()) {
                throw new RuntimeException("DescribeLogDirsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<DescribeLogDirsResult> _collection = new ArrayList<DescribeLogDirsResult>(_resultsNode.size());
            _object.results = _collection;
            for (JsonNode _element : _resultsNode) {
                _collection.add(DescribeLogDirsResultJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(DescribeLogDirsResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        ArrayNode _resultsArray = new ArrayNode(JsonNodeFactory.instance);
        for (DescribeLogDirsResult _element : _object.results) {
            _resultsArray.add(DescribeLogDirsResultJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("results", _resultsArray);
        return _node;
    }
    public static JsonNode write(DescribeLogDirsResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DescribeLogDirsPartitionJsonConverter {
        public static DescribeLogDirsPartition read(JsonNode _node, short _version) {
            DescribeLogDirsPartition _object = new DescribeLogDirsPartition();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("DescribeLogDirsPartition: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "DescribeLogDirsPartition");
            }
            JsonNode _partitionSizeNode = _node.get("partitionSize");
            if (_partitionSizeNode == null) {
                throw new RuntimeException("DescribeLogDirsPartition: unable to locate field 'partitionSize', which is mandatory in version " + _version);
            } else {
                _object.partitionSize = MessageUtil.jsonNodeToLong(_partitionSizeNode, "DescribeLogDirsPartition");
            }
            JsonNode _offsetLagNode = _node.get("offsetLag");
            if (_offsetLagNode == null) {
                throw new RuntimeException("DescribeLogDirsPartition: unable to locate field 'offsetLag', which is mandatory in version " + _version);
            } else {
                _object.offsetLag = MessageUtil.jsonNodeToLong(_offsetLagNode, "DescribeLogDirsPartition");
            }
            JsonNode _isFutureKeyNode = _node.get("isFutureKey");
            if (_isFutureKeyNode == null) {
                throw new RuntimeException("DescribeLogDirsPartition: unable to locate field 'isFutureKey', which is mandatory in version " + _version);
            } else {
                if (!_isFutureKeyNode.isBoolean()) {
                    throw new RuntimeException("DescribeLogDirsPartition expected Boolean type, but got " + _node.getNodeType());
                }
                _object.isFutureKey = _isFutureKeyNode.asBoolean();
            }
            return _object;
        }
        public static JsonNode write(DescribeLogDirsPartition _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("partitionSize", new LongNode(_object.partitionSize));
            _node.set("offsetLag", new LongNode(_object.offsetLag));
            _node.set("isFutureKey", BooleanNode.valueOf(_object.isFutureKey));
            return _node;
        }
        public static JsonNode write(DescribeLogDirsPartition _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class DescribeLogDirsResultJsonConverter {
        public static DescribeLogDirsResult read(JsonNode _node, short _version) {
            DescribeLogDirsResult _object = new DescribeLogDirsResult();
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("DescribeLogDirsResult: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "DescribeLogDirsResult");
            }
            JsonNode _logDirNode = _node.get("logDir");
            if (_logDirNode == null) {
                throw new RuntimeException("DescribeLogDirsResult: unable to locate field 'logDir', which is mandatory in version " + _version);
            } else {
                if (!_logDirNode.isTextual()) {
                    throw new RuntimeException("DescribeLogDirsResult expected a string type, but got " + _node.getNodeType());
                }
                _object.logDir = _logDirNode.asText();
            }
            JsonNode _topicsNode = _node.get("topics");
            if (_topicsNode == null) {
                throw new RuntimeException("DescribeLogDirsResult: unable to locate field 'topics', which is mandatory in version " + _version);
            } else {
                if (!_topicsNode.isArray()) {
                    throw new RuntimeException("DescribeLogDirsResult expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<DescribeLogDirsTopic> _collection = new ArrayList<DescribeLogDirsTopic>(_topicsNode.size());
                _object.topics = _collection;
                for (JsonNode _element : _topicsNode) {
                    _collection.add(DescribeLogDirsTopicJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(DescribeLogDirsResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("errorCode", new ShortNode(_object.errorCode));
            _node.set("logDir", new TextNode(_object.logDir));
            ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
            for (DescribeLogDirsTopic _element : _object.topics) {
                _topicsArray.add(DescribeLogDirsTopicJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topics", _topicsArray);
            return _node;
        }
        public static JsonNode write(DescribeLogDirsResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class DescribeLogDirsTopicJsonConverter {
        public static DescribeLogDirsTopic read(JsonNode _node, short _version) {
            DescribeLogDirsTopic _object = new DescribeLogDirsTopic();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("DescribeLogDirsTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("DescribeLogDirsTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("DescribeLogDirsTopic: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("DescribeLogDirsTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<DescribeLogDirsPartition> _collection = new ArrayList<DescribeLogDirsPartition>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(DescribeLogDirsPartitionJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(DescribeLogDirsTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (DescribeLogDirsPartition _element : _object.partitions) {
                _partitionsArray.add(DescribeLogDirsPartitionJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(DescribeLogDirsTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
