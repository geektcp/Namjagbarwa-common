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

import static org.apache.kafka.common.message.StopReplicaResponseData.*;

public class StopReplicaResponseDataJsonConverter {
    public static StopReplicaResponseData read(JsonNode _node, short _version) {
        StopReplicaResponseData _object = new StopReplicaResponseData();
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("StopReplicaResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "StopReplicaResponseData");
        }
        JsonNode _partitionErrorsNode = _node.get("partitionErrors");
        if (_partitionErrorsNode == null) {
            throw new RuntimeException("StopReplicaResponseData: unable to locate field 'partitionErrors', which is mandatory in version " + _version);
        } else {
            if (!_partitionErrorsNode.isArray()) {
                throw new RuntimeException("StopReplicaResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<StopReplicaPartitionError> _collection = new ArrayList<StopReplicaPartitionError>(_partitionErrorsNode.size());
            _object.partitionErrors = _collection;
            for (JsonNode _element : _partitionErrorsNode) {
                _collection.add(StopReplicaPartitionErrorJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(StopReplicaResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("errorCode", new ShortNode(_object.errorCode));
        ArrayNode _partitionErrorsArray = new ArrayNode(JsonNodeFactory.instance);
        for (StopReplicaPartitionError _element : _object.partitionErrors) {
            _partitionErrorsArray.add(StopReplicaPartitionErrorJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("partitionErrors", _partitionErrorsArray);
        return _node;
    }
    public static JsonNode write(StopReplicaResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class StopReplicaPartitionErrorJsonConverter {
        public static StopReplicaPartitionError read(JsonNode _node, short _version) {
            StopReplicaPartitionError _object = new StopReplicaPartitionError();
            JsonNode _topicNameNode = _node.get("topicName");
            if (_topicNameNode == null) {
                throw new RuntimeException("StopReplicaPartitionError: unable to locate field 'topicName', which is mandatory in version " + _version);
            } else {
                if (!_topicNameNode.isTextual()) {
                    throw new RuntimeException("StopReplicaPartitionError expected a string type, but got " + _node.getNodeType());
                }
                _object.topicName = _topicNameNode.asText();
            }
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("StopReplicaPartitionError: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "StopReplicaPartitionError");
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("StopReplicaPartitionError: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "StopReplicaPartitionError");
            }
            return _object;
        }
        public static JsonNode write(StopReplicaPartitionError _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topicName", new TextNode(_object.topicName));
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            return _node;
        }
        public static JsonNode write(StopReplicaPartitionError _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
