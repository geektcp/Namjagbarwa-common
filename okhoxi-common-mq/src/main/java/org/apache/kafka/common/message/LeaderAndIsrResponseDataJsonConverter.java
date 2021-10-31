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
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.LeaderAndIsrResponseData.*;

public class LeaderAndIsrResponseDataJsonConverter {
    public static LeaderAndIsrResponseData read(JsonNode _node, short _version) {
        LeaderAndIsrResponseData _object = new LeaderAndIsrResponseData();
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("LeaderAndIsrResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "LeaderAndIsrResponseData");
        }
        JsonNode _partitionErrorsNode = _node.get("partitionErrors");
        if (_partitionErrorsNode == null) {
            if (_version <= 4) {
                throw new RuntimeException("LeaderAndIsrResponseData: unable to locate field 'partitionErrors', which is mandatory in version " + _version);
            } else {
                _object.partitionErrors = new ArrayList<LeaderAndIsrPartitionError>(0);
            }
        } else {
            if (!_partitionErrorsNode.isArray()) {
                throw new RuntimeException("LeaderAndIsrResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<LeaderAndIsrPartitionError> _collection = new ArrayList<LeaderAndIsrPartitionError>(_partitionErrorsNode.size());
            _object.partitionErrors = _collection;
            for (JsonNode _element : _partitionErrorsNode) {
                _collection.add(LeaderAndIsrPartitionErrorJsonConverter.read(_element, _version));
            }
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            if (_version >= 5) {
                throw new RuntimeException("LeaderAndIsrResponseData: unable to locate field 'topics', which is mandatory in version " + _version);
            } else {
                _object.topics = new ArrayList<LeaderAndIsrTopicError>(0);
            }
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("LeaderAndIsrResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<LeaderAndIsrTopicError> _collection = new ArrayList<LeaderAndIsrTopicError>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(LeaderAndIsrTopicErrorJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(LeaderAndIsrResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("errorCode", new ShortNode(_object.errorCode));
        if (_version <= 4) {
            ArrayNode _partitionErrorsArray = new ArrayNode(JsonNodeFactory.instance);
            for (LeaderAndIsrPartitionError _element : _object.partitionErrors) {
                _partitionErrorsArray.add(LeaderAndIsrPartitionErrorJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitionErrors", _partitionErrorsArray);
        } else {
            if (!_object.partitionErrors.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default partitionErrors at version " + _version);
            }
        }
        if (_version >= 5) {
            ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
            for (LeaderAndIsrTopicError _element : _object.topics) {
                _topicsArray.add(LeaderAndIsrTopicErrorJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topics", _topicsArray);
        } else {
            if (!_object.topics.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topics at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(LeaderAndIsrResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class LeaderAndIsrPartitionErrorJsonConverter {
        public static LeaderAndIsrPartitionError read(JsonNode _node, short _version) {
            LeaderAndIsrPartitionError _object = new LeaderAndIsrPartitionError();
            JsonNode _topicNameNode = _node.get("topicName");
            if (_topicNameNode == null) {
                if (_version <= 4) {
                    throw new RuntimeException("LeaderAndIsrPartitionError: unable to locate field 'topicName', which is mandatory in version " + _version);
                } else {
                    _object.topicName = "";
                }
            } else {
                if (!_topicNameNode.isTextual()) {
                    throw new RuntimeException("LeaderAndIsrPartitionError expected a string type, but got " + _node.getNodeType());
                }
                _object.topicName = _topicNameNode.asText();
            }
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("LeaderAndIsrPartitionError: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "LeaderAndIsrPartitionError");
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("LeaderAndIsrPartitionError: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "LeaderAndIsrPartitionError");
            }
            return _object;
        }
        public static JsonNode write(LeaderAndIsrPartitionError _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            if (_version <= 4) {
                _node.set("topicName", new TextNode(_object.topicName));
            }
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            return _node;
        }
        public static JsonNode write(LeaderAndIsrPartitionError _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class LeaderAndIsrTopicErrorJsonConverter {
        public static LeaderAndIsrTopicError read(JsonNode _node, short _version) {
            LeaderAndIsrTopicError _object = new LeaderAndIsrTopicError();
            if (_version < 5) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of LeaderAndIsrTopicError");
            }
            JsonNode _topicIdNode = _node.get("topicId");
            if (_topicIdNode == null) {
                throw new RuntimeException("LeaderAndIsrTopicError: unable to locate field 'topicId', which is mandatory in version " + _version);
            } else {
                if (!_topicIdNode.isTextual()) {
                    throw new RuntimeException("LeaderAndIsrTopicError expected a JSON string type, but got " + _node.getNodeType());
                }
                _object.topicId = Uuid.fromString(_topicIdNode.asText());
            }
            JsonNode _partitionErrorsNode = _node.get("partitionErrors");
            if (_partitionErrorsNode == null) {
                throw new RuntimeException("LeaderAndIsrTopicError: unable to locate field 'partitionErrors', which is mandatory in version " + _version);
            } else {
                if (!_partitionErrorsNode.isArray()) {
                    throw new RuntimeException("LeaderAndIsrTopicError expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<LeaderAndIsrPartitionError> _collection = new ArrayList<LeaderAndIsrPartitionError>(_partitionErrorsNode.size());
                _object.partitionErrors = _collection;
                for (JsonNode _element : _partitionErrorsNode) {
                    _collection.add(LeaderAndIsrPartitionErrorJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(LeaderAndIsrTopicError _object, short _version, boolean _serializeRecords) {
            if (_version < 5) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of LeaderAndIsrTopicError");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topicId", new TextNode(_object.topicId.toString()));
            ArrayNode _partitionErrorsArray = new ArrayNode(JsonNodeFactory.instance);
            for (LeaderAndIsrPartitionError _element : _object.partitionErrors) {
                _partitionErrorsArray.add(LeaderAndIsrPartitionErrorJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitionErrors", _partitionErrorsArray);
            return _node;
        }
        public static JsonNode write(LeaderAndIsrTopicError _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
